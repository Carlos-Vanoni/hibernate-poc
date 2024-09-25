package com.contentservice.content.api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ContentCreatorResponseBody {

    private String contentCreatorName;
    private BigDecimal feedback;
    private Long personId;
}
