package com.contentservice.content.comment.api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ContentResponseBody {

    private String title;
    private BigDecimal price;
    private BigDecimal assessment;
    private String comment;
}
