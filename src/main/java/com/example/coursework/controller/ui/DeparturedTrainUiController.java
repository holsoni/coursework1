package com.example.coursework.controller.ui;

import com.example.coursework.model.*;
import com.example.coursework.service.departuredTrain.DeparturedTrainServiceImpl;
import com.example.coursework.service.platform.PlatformServiceImpl;
import com.example.coursework.service.route.TrainServiceImpl;
import com.example.coursework.service.train.RootServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;

@RequestMapping("/ui/departuredTrains")
@Controller
public class DeparturedTrainUiController {

    @Autowired
    DeparturedTrainServiceImpl trainService;


    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<DeparturedTrain> trainList =  trainService.getAll();

        model.addAttribute("trainList", trainList);

        return "departured/trainList";
    }


    @GetMapping("/deleteAll")
    public String deleteAll(Model model) {
        trainService.deleteAll();
        return "departured/trainList";
    }
}
