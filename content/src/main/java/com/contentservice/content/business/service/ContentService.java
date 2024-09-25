package com.contentservice.content.business.service;

import com.contentservice.content.api.model.*;
import com.contentservice.content.business.converter.ContentConverter;
import com.contentservice.content.business.converter.ContentCreatorConverter;
import com.contentservice.content.data.dao.*;
import com.contentservice.content.data.model.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    @Autowired
    private ContentDao contentDao;
    @Autowired
    private PersonDao personDao;
    @Autowired
    private VideoDao videoDao;
    @Autowired
    PurchasedContentDao purchasedContentDao;
    @Autowired
    private ContentCreatorDao contentCreatorDao;
    @Autowired
    private ContentConverter contentConverter;
    @Autowired
    private ContentCreatorConverter contentCreatorConverter;

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

    public PersonResponseBody findPersonByEmail(String email) {
        PersonEntity personEntity = personDao.findByEmail(email).orElse(null);
        if (personEntity != null) {
            List<PurchasedContentEntity> purchasedContentsEntity = purchasedContentDao.findByPerson(personEntity.getId());
            if (!purchasedContentsEntity.isEmpty()) {
                List<ContentEntity> contentEntityList = new ArrayList<>();
                purchasedContentsEntity
                        .forEach(purchasedContent -> {
                            ContentEntity contentEntity = contentDao.findById(purchasedContent.getContent()).orElse(null);
                            contentEntityList.add(contentEntity);
                        });
                return contentConverter.toPersonResponseBody(personEntity, contentEntityList);

            }
        }

        return null;
    }

    public ContentResponseBody findContentByTitle(String title) {
        ContentEntity contentEntity = contentDao.findByTitle(title).orElse(null);
        if (contentEntity != null) {
            List<PurchasedContentEntity> purchasedContentsEntity = purchasedContentDao.findByContent(contentEntity.getId());
            if (!purchasedContentsEntity.isEmpty()) {
                List<PersonEntity> personEntityList = new ArrayList<>();
                purchasedContentsEntity
                        .forEach(purchasedContent -> {
                            PersonEntity personEntity = personDao.findById(purchasedContent.getPerson()).orElse(null);
                            personEntityList.add(personEntity);
                        });
                return contentConverter.toContentResponseBody(contentEntity, personEntityList);

            }
        }

        return null;
    }

    public void createContentCreatorAccount(ContentCreatorRequestBody contentCreatorRequestBody) {
        PersonEntity personFound = personDao.findByEmail(contentCreatorRequestBody.getEmail()).orElse(null);
        if (personFound != null) {

            PersonEntity personToSave = PersonEntity.builder()
                    .name(contentCreatorRequestBody.getName())
                    .email(contentCreatorRequestBody.getEmail())
                    .birthDate(contentCreatorRequestBody.getBirthDate())
                    .build();

            ContentCreatorEntity contentCreatorToSave = ContentCreatorEntity.builder()
                    .contentCreatorName(contentCreatorRequestBody.getContentCreatorName())
                    .personId(personFound.getId())
                    .build();

            personDao.save(personToSave);
            contentCreatorDao.save(contentCreatorToSave);
        }
    }

    public List<ContentResponseBody> findAllContents() {
        List<ContentEntity> contents = Streamable.of(contentDao.findAll()).toList();

        return contentConverter.toResponseBodyList(contents);
    }

    public List<ContentCreatorResponseBody> findAllContentCreators() {
        List<ContentCreatorEntity> contentCreators = Streamable.of(contentCreatorDao.findAll()).toList();

        return contentCreatorConverter.toResponseBodyList(contentCreators);
    }

    public void saveVideo(VideoRequestBody videoRequestBody) {
        VideoEntity videoEntity = contentCreatorDao.findByContentCreatorName(videoRequestBody.getContentCreatorName()).orElse(null);
        if (videoEntity != null) {
            VideoEntity videoToSave = VideoEntity.builder()
                    .link(videoRequestBody.getLink())
                    .title(videoRequestBody.getTitle())
                    .updatedBy(videoEntity.getUpdatedBy())
                    .build();

            videoDao.save(videoToSave);
        }
    }
}
