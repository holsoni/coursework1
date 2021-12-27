package com.example.coursework.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "cancelledTrain")
public class CancelledTrain extends Train{
    public CancelledTrain(Train train) {
        super(train.getId(), train.getCode(), train.getRoute(), train.getPlatform(), train.getTimeOfDeparture(), train.getTimeOfArrival(), train.getTimeOfStop(), train.isOnStation());
    }
}
