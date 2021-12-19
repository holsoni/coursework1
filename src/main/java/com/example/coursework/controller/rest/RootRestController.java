package com.example.coursework.controller.rest;

import com.example.coursework.model.Route;
import com.example.coursework.service.train.RootServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/route")
public class RootRestController {
    @Autowired
    RootServiceImpl service;

    @GetMapping("/get/all")
    public List<Route> getManager(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Route getById(@PathVariable("id") String id){
        Route byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Route deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping("/create/")
    public Route create(@RequestBody Route route){
        return service.create(route);
    }

    @PostMapping ("/update/")
    public Route update(@RequestBody Route route){
        return service.update(route);
    }

}
