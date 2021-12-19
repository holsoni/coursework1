package com.example.coursework.service.route;

import com.example.coursework.model.Train;

import java.util.List;

public interface ITrainService {

    Train getById(String id);
    Train create(Train train);
    Train update(Train train);
    Train delete(String id);
    List<Train> getAll();
}
