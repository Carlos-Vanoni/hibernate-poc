package com.contentservice.content.api.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ContentResponseBody {

    private String title;
    private BigDecimal price;
    private BigDecimal assessment;
    private String comment;
    private List<PersonResponseBody> purchaser;

    @Data
    @Builder

    public static class PersonResponseBody {

        private String name;
        private String email;
        private LocalDate birthDate;

    }
}
