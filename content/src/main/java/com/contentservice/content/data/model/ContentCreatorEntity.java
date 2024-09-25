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
@Table(name = "content_creator")
public class ContentCreatorEntity {

    @Id
    private Long id;
    private String contentCreatorName;
    private BigDecimal feedback;
    private Long personId;

}
