package com.example.coursework.service.departuredTrain;

import com.example.coursework.model.DeparturedTrain;
import com.example.coursework.model.Train;

import java.util.List;

public interface IDeparturedTrainService {

    DeparturedTrain getById(String id);
    DeparturedTrain create(DeparturedTrain train);
    DeparturedTrain update(DeparturedTrain train);
    DeparturedTrain delete(String id);
    List<DeparturedTrain> getAll();
}
