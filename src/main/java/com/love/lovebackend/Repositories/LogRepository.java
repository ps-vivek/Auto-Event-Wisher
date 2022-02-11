package com.love.lovebackend.Repositories;


import com.love.lovebackend.Entities.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, String> {
}
