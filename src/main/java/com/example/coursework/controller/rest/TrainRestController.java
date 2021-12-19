package com.example.coursework.controller.rest;

import com.example.coursework.model.Route;
import com.example.coursework.model.Train;
import com.example.coursework.service.route.TrainServiceImpl;
import com.example.coursework.service.train.RootServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/train")
public class TrainRestController {
    @Autowired
    TrainServiceImpl service;

    @GetMapping("/get/all")
    public List<Train> getManager(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Train getById(@PathVariable("id") String id){
        Train byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Train deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public Train create(@RequestBody Train train){
        return service.create(train);
    }

    @PostMapping ("/update/")
    public Train update(@RequestBody Train train){
        return service.update(train);
    }
}
