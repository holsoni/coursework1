package com.example.coursework.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@Document(collection = "departuredTrain")
public class DeparturedTrain extends Train{

    public DeparturedTrain(Train train) {
        super(train.getId(), train.getCode(), train.getRoute(), train.getPlatform(), train.getTimeOfDeparture(), train.getTimeOfArrival(), train.getTimeOfStop(), train.isOnStation());
    }
}
