package com.example.coursework.repository;

import com.example.coursework.model.Route;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IRouteRepository extends MongoRepository<Route, String> {


}
