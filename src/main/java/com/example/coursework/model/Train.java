package com.example.coursework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "trains")
public class Train implements Cloneable{
    @Id
    private String id;
    private String code;
    private Route route;
    private Platform platform;
    private LocalTime timeOfDeparture;
    private LocalTime timeOfArrival;
    private Duration timeOfStop;
    private boolean onStation;

    public Train clone(){
        return this.clone();
    }
}
