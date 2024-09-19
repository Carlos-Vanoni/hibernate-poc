package com.contentservice.content.comment.api.controller;

import com.contentservice.content.comment.api.model.ContentCreatorRequestBody;
import com.contentservice.content.comment.api.model.ContentResponseBody;
import com.contentservice.content.comment.api.model.VideoRequestBody;
import com.contentservice.content.comment.business.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/content")
@RequiredArgsConstructor
public class ContentController {

    private final ContentService service;

    @PostMapping("/adjust-assessment")
    public ContentResponseBody publishAssessment(@RequestParam String title, @RequestParam BigDecimal assessment) {
        return service.insertAssessment(title, assessment);
    }

    @GetMapping("/find-contents-by-content-creator")
    public List<ContentResponseBody> publishAssessment(@RequestParam String contentCreator) {
        return service.findContentsByContentCreator(contentCreator);
    }

    @PostMapping("/create-content-creator-account")
    public void createContentCreateAccount(@RequestBody ContentCreatorRequestBody contentCreatorRequestBody) {
        service.createContentCreatorAccount(contentCreatorRequestBody);
    }

//    @PostMapping("/upload-video")
//    public List<ContentResponseBody> uploadVideo(@RequestBody VideoRequestBody videoRequestBody) {
//        return service.findContentsByContentCreator(contentCreator);
//    }
}
