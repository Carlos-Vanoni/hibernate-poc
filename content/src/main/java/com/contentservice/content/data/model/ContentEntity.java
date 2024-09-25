package com.contentservice.content.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
