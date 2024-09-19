package com.contentservice.content.comment.business.converter;

import com.contentservice.content.comment.api.model.ContentResponseBody;
import com.contentservice.content.comment.data.model.ContentEntity;
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

    public List<ContentResponseBody> toResponseBodyList(List<ContentEntity> contentEntity) {
        return contentEntity.stream()
                .map(this::toResponseBody)
                .collect(Collectors.toList());
    }
}
