package com.example.coursework.service.train;

import com.example.coursework.model.Route;
import com.example.coursework.model.Train;

import java.util.List;

public interface IRootService {
    Route getById(String id);
    Route create(Route route);
    Route update(Route route);
    Route delete(String id);
    List<Route> getAll();
}
