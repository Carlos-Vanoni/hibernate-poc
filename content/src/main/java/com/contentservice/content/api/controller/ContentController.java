package com.contentservice.content.api.controller;

import com.contentservice.content.api.model.*;
import com.contentservice.content.business.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/content")
@RequiredArgsConstructor
public class ContentController {

    private final ContentService service;

    @GetMapping("/find-contents-by-content-creators")
    public List<ContentResponseBody> findContentByContentCreator(@RequestParam String contentCreator) {
        return service.findContentsByContentCreator(contentCreator);
    }

    @GetMapping("/find-all-content-creators")
    public List<ContentCreatorResponseBody> findAllContentCreators() {
        return service.findAllContentCreators();
    }

    @GetMapping("/find-person")
    public PersonResponseBody findPerson(@RequestParam String email) {
        return service.findPersonByEmail(email);
    }

    @GetMapping("/find-content")
    public ContentResponseBody findContent(@RequestParam String title) {
        return service.findContentByTitle(title);
    }

    @GetMapping("/find-all-contents")
    public List<ContentResponseBody> findAllContents() {
        return service.findAllContents();
    }

    @PostMapping("/adjust-assessment")
    public ContentResponseBody publishAssessment(@RequestParam String title, @RequestParam BigDecimal assessment) {
        return service.insertAssessment(title, assessment);
    }

    @PostMapping("/create-content-creator-account")
    public void createContentCreateAccount(@RequestBody ContentCreatorRequestBody contentCreatorRequestBody) {
        service.createContentCreatorAccount(contentCreatorRequestBody);
    }

    @PostMapping("/upload-video")
    public void uploadVideo(@RequestBody VideoRequestBody videoRequestBody) {
        service.saveVideo(videoRequestBody);
    }
}
