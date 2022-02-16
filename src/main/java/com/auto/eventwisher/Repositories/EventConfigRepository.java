package com.auto.eventwisher.Repositories;


import com.auto.eventwisher.Entities.EventConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventConfigRepository extends MongoRepository<EventConfig, String> {
}
