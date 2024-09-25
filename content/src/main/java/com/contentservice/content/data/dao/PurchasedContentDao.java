package com.contentservice.content.data.dao;

import com.contentservice.content.data.model.PurchasedContentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PurchasedContentDao extends CrudRepository<PurchasedContentEntity, Long> {

    List<PurchasedContentEntity> findByContent(Long id);
    List<PurchasedContentEntity> findByPerson(Long id);
}