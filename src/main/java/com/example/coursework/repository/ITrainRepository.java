package com.example.coursework.repository;

import com.example.coursework.model.Train;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ITrainRepository extends MongoRepository<Train,String> {

}
