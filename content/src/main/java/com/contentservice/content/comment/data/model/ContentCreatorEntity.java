package com.contentservice.content.comment.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "content_creator")
@Builder
public class ContentCreatorEntity {

    @Id
    private Long id;
    private String contentCreatorName;
    private BigDecimal feedback;
    private Long personId;

}
