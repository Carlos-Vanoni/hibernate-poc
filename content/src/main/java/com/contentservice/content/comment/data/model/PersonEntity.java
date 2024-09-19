package com.contentservice.content.comment.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "person")
@Builder
public class PersonEntity {

    @Id
    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
}
