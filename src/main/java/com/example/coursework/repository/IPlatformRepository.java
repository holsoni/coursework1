package com.example.coursework.repository;

import com.example.coursework.model.Platform;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPlatformRepository extends MongoRepository<Platform, String> {
}
