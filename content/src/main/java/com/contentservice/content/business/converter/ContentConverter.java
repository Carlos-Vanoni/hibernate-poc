package com.contentservice.content.business.converter;

import com.contentservice.content.api.model.ContentResponseBody;
import com.contentservice.content.api.model.PersonResponseBody;
import com.contentservice.content.data.model.ContentEntity;
import com.contentservice.content.data.model.PersonEntity;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContentConverter {

    public ContentResponseBody toResponseBody(@NotNull ContentEntity contentEntity) {
        return ContentResponseBody.builder()
                .title(contentEntity.getTitle())
                .price(contentEntity.getPrice())
                .assessment(contentEntity.getAssessment())
                .comment(contentEntity.getComment())
                .build();
    }

    public PersonResponseBody.ContentResponseBody toPersonContentResponseBody(@NotNull ContentEntity contentEntity) {
        return PersonResponseBody.ContentResponseBody.builder()
                .title(contentEntity.getTitle())
                .price(contentEntity.getPrice())
                .assessment(contentEntity.getAssessment())
                .comment(contentEntity.getComment())
                .build();
    }

    public ContentResponseBody.PersonResponseBody toContentPersonResponseBody(@NotNull PersonEntity personEntity) {
        return ContentResponseBody.PersonResponseBody.builder()
                .name(personEntity.getName())
                .birthDate(personEntity.getBirthDate())
                .email(personEntity.getEmail())
                .build();
    }

    public List<ContentResponseBody> toResponseBodyList(List<ContentEntity> contentEntities) {
        return contentEntities.stream()
                .map(this::toResponseBody)
                .collect(Collectors.toList());
    }

    public List<PersonResponseBody.ContentResponseBody> toPersonContentResponseBodyList(List<ContentEntity> contentEntities) {
        return contentEntities.stream()
                .map(this::toPersonContentResponseBody)
                .collect(Collectors.toList());
    }

    public List<ContentResponseBody.PersonResponseBody> toContentPersonResponseBodyList(List<PersonEntity> personEntities) {
        return personEntities.stream()
                .map(this::toContentPersonResponseBody)
                .collect(Collectors.toList());
    }

    public PersonResponseBody toPersonResponseBody(@NotNull PersonEntity personEntity, @NotNull List<ContentEntity> contentEntities) {
        return PersonResponseBody.builder()
                .name(personEntity.getName())
                .birthDate(personEntity.getBirthDate())
                .email(personEntity.getEmail())
                .purchasedContent(toPersonContentResponseBodyList(contentEntities))
                .build();
    }

    public ContentResponseBody toContentResponseBody(@NotNull ContentEntity contentEntity, @NotNull List<PersonEntity> personEntities) {
        return ContentResponseBody.builder()
                .title(contentEntity.getTitle())
                .price(contentEntity.getPrice())
                .assessment(contentEntity.getAssessment())
                .comment(contentEntity.getComment())
                .purchaser(toContentPersonResponseBodyList(personEntities))
                .build();
    }
}
