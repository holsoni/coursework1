package com.example.coursework.repository;

import com.example.coursework.model.DeparturedTrain;
import com.example.coursework.model.Train;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDTrainRepository extends MongoRepository<DeparturedTrain,String> {

}
