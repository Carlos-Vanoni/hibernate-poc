package com.contentservice.content.comment.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "content")
public class ContentEntity {

    @Id
    private Long id;
    private String title;
    private BigDecimal price;
    private BigDecimal assessment;
    private String comment;
    private Long content_creator_id;


}
