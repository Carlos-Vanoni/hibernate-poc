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
@Table(name = "video")
public class VideoEntity {

    @Id
    private Long id;
    private String title;
    private String link;
    private Long updatedBy;

}
