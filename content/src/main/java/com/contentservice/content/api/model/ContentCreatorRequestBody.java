package com.contentservice.content.api.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ContentCreatorRequestBody {

    private String name;
    private String email;
    private LocalDate birthDate;
    private String comment;
    private String contentCreatorName;

}
