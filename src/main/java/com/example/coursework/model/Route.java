package com.example.coursework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "route")
public class Route {
    @Id
    private String id;
    private String startStation;
    private String endStation;
    private String time;
    private String name;

    public Route(String id, String startStation, String endStation, String time) {
        this.id = id;
        this.startStation = startStation;
        this.endStation = endStation;
        this.time = time;
        this.name = startStation + " - " + endStation;
    }

}
