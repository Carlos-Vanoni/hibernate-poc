package com.contentservice.content.data.dao;

import com.contentservice.content.data.model.VideoEntity;
import org.springframework.data.repository.CrudRepository;

public interface VideoDao extends CrudRepository<VideoEntity, Long> {



}
