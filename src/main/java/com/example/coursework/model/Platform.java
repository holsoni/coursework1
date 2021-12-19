package com.example.coursework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "platform")
public class Platform {
    @Id
    private String id;
    private int number;
    private boolean free;

    public Platform(int number) {
        this.number = number;
        this.free = true;
    }
}
