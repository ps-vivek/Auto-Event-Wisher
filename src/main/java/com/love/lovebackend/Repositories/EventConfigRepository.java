package com.love.lovebackend.Repositories;


import com.love.lovebackend.Entities.EventConfig;
import com.love.lovebackend.Entities.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventConfigRepository extends MongoRepository<EventConfig, String> {
}
