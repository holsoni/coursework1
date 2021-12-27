package com.example.coursework.repository;

import com.example.coursework.model.CancelledTrain;
import com.example.coursework.model.Train;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICTrainRepository extends MongoRepository<CancelledTrain,String> {

}
