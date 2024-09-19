package com.contentservice.content.comment.data.dao;

import com.contentservice.content.comment.data.model.ContentCreatorEntity;
import org.springframework.data.repository.CrudRepository;

public interface ContentCreatorDao extends CrudRepository<ContentCreatorEntity, Long> {
}
