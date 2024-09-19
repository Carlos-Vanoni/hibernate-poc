package com.contentservice.content.comment.business.service;

import com.contentservice.content.comment.api.model.ContentCreatorRequestBody;
import com.contentservice.content.comment.api.model.ContentResponseBody;
import com.contentservice.content.comment.business.converter.ContentConverter;
import com.contentservice.content.comment.data.dao.ContentCreatorDao;
import com.contentservice.content.comment.data.dao.ContentDao;
import com.contentservice.content.comment.data.dao.PersonDao;
import com.contentservice.content.comment.data.model.ContentCreatorEntity;
import com.contentservice.content.comment.data.model.ContentEntity;
import com.contentservice.content.comment.data.model.PersonEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    @Autowired
    private ContentDao contentDao;
    @Autowired
    private PersonDao personDao;
    @Autowired
    private ContentCreatorDao contentCreatorDao;
    @Autowired
    private ContentConverter contentConverter;

    public ContentResponseBody insertAssessment(String title, BigDecimal assessment) {
        Optional<ContentEntity> contentEntityOptional = contentDao.findByTitle(title);

        if (contentEntityOptional.isPresent()) {
            ContentEntity contentEntity = contentEntityOptional.get();
            contentEntity.setAssessment(assessment);
            contentDao.save(contentEntity);
        } else {
            throw new EntityNotFoundException("Title not found: " + title);
        }
        ContentEntity contentEntity = contentEntityOptional.orElse(null);
        return contentConverter.toResponseBody(contentEntity);
    }

    public List<ContentResponseBody> findContentsByContentCreator(String contentCreatorName) {
        List<ContentEntity> byContentCreatorName = contentDao.findByContentCreatorName(contentCreatorName);

        return contentConverter.toResponseBodyList(byContentCreatorName);
    }

    public void createContentCreatorAccount(ContentCreatorRequestBody contentCreatorRequestBody) {
        Optional<PersonEntity> personFound = personDao.findByEmail(contentCreatorRequestBody.getEmail());
        if (personFound.isEmpty()) {

            PersonEntity personToSave = PersonEntity.builder()
                    .name(contentCreatorRequestBody.getName())
                    .email(contentCreatorRequestBody.getEmail())
                    .birthDate(contentCreatorRequestBody.getBirthDate())
                    .build();

            ContentCreatorEntity contentCreatorToSave = ContentCreatorEntity.builder()
                    .contentCreatorName(contentCreatorRequestBody.getContentCreatorName())
                    .personId(personFound.get().getId())
                    .build();

            personDao.save(personToSave);
            contentCreatorDao.save(contentCreatorToSave);
        }
    }

}
