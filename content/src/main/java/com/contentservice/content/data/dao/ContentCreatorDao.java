package com.contentservice.content.data.dao;

import com.contentservice.content.data.model.ContentCreatorEntity;
import com.contentservice.content.data.model.VideoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ContentCreatorDao extends CrudRepository<ContentCreatorEntity, Long> {

    Optional<VideoEntity> findByContentCreatorName(String contentCreatorName);
}
