package com.contentservice.content.comment.data.dao;

import com.contentservice.content.comment.data.model.ContentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ContentDao extends CrudRepository<ContentEntity, Long> {

    Optional<ContentEntity> findByTitle(String title);


    @Query("SELECT c FROM ContentEntity c WHERE c.content_creator_id = (SELECT cc.id FROM ContentCreatorEntity cc WHERE cc.content_creator_name = :creatorName)")
    List<ContentEntity> findByContentCreatorName(String creatorName);

    @Query("SELECT c FROM ContentEntity c WHERE c.content_creator_id = (SELECT cc.id FROM ContentCreatorEntity cc WHERE cc.content_creator_name = :creatorName)")
    List<ContentEntity> find(String creatorName);
}
