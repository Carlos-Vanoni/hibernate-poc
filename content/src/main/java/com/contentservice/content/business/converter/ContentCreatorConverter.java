package com.contentservice.content.business.converter;

import com.contentservice.content.api.model.ContentCreatorResponseBody;
import com.contentservice.content.api.model.ContentResponseBody;
import com.contentservice.content.data.model.ContentCreatorEntity;
import com.contentservice.content.data.model.ContentEntity;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContentCreatorConverter {

    public ContentCreatorResponseBody toResponseBody(@NotNull ContentCreatorEntity contentCreatorEntity) {
        return ContentCreatorResponseBody.builder()
                .contentCreatorName(contentCreatorEntity.getContentCreatorName())
                .feedback(contentCreatorEntity.getFeedback())
                .personId(contentCreatorEntity.getPersonId())
                .build();
    }

    public List<ContentCreatorResponseBody> toResponseBodyList(List<ContentCreatorEntity> contentCreatorEntities) {
        return contentCreatorEntities.stream()
                .map(this::toResponseBody)
                .collect(Collectors.toList());
    }
}
