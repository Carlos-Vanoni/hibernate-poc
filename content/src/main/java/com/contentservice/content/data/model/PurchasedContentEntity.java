package com.contentservice.content.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "purchased_content")
public class PurchasedContentEntity {

    @Id
    private Long id;
    private boolean isFavorite;
    private Long person;
    private Long content;

}
