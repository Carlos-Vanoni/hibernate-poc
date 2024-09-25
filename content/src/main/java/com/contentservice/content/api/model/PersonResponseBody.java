package com.contentservice.content.api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class PersonResponseBody {

    private String name;
    private String email;
    private LocalDate birthDate;
    private List<PersonResponseBody.ContentResponseBody> purchasedContent;

    @Data
    @Builder
    public static class ContentResponseBody {

        private String title;
        private BigDecimal price;
        private BigDecimal assessment;
        private String comment;

    }
}
