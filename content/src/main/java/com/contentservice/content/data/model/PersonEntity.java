package com.contentservice.content.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "person")
public class PersonEntity {

    @Id
    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
}
