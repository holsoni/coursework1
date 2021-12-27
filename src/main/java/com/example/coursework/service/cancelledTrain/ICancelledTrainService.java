package com.example.coursework.service.cancelledTrain;

import com.example.coursework.model.CancelledTrain;
import com.example.coursework.model.Train;

import java.util.List;

public interface ICancelledTrainService {

    CancelledTrain getById(String id);
    CancelledTrain create(CancelledTrain train);
    CancelledTrain update(CancelledTrain train);
    CancelledTrain delete(String id);
    List<CancelledTrain> getAll();
}
