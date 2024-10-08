package com.contentservice.content.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VideoRequestBody {

    private String link;
    private String title;
    private String contentCreatorName;
}
