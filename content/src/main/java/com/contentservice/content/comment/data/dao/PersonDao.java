package com.contentservice.content.comment.data.dao;

import com.contentservice.content.comment.data.model.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonDao extends CrudRepository<PersonEntity, Long> {

    Optional<PersonEntity> findByEmail(String email);

}
