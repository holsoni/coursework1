package com.example.coursework.controller.ui;

import com.example.coursework.model.Platform;
import com.example.coursework.model.Route;
import com.example.coursework.model.Train;
import com.example.coursework.service.platform.PlatformServiceImpl;
import com.example.coursework.service.route.TrainServiceImpl;
import com.example.coursework.service.train.RootServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

@RequestMapping("/ui/train")
@Controller
public class TrainUiController {
    @Autowired
    TrainServiceImpl trainService;

    @Autowired
    RootServiceImpl rootService;

    @Autowired
    PlatformServiceImpl platformService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Train> trainList = trainService.getAll();
        trainList.sort(Comparator.comparing(Train::getTimeOfArrival));
        for (Train train :trainList
        ) {
            System.out.println("HH");
            if(train.getTimeOfArrival().isBefore(LocalTime.now())){
                train.setOnStation(true);
                Platform platform = platformService.getById(train.getPlatform().getId());
                platform.setFree(false);
                platformService.update(platform);
                System.out.println(platform);
            }
            if(train.getTimeOfDeparture().isBefore(LocalTime.now())){
                trainService.delete(train.getId());

                Platform platform = platformService.getById(train.getPlatform().getId());
                platform.setFree(false);
                platformService.update(platform);
            }

        };

        model.addAttribute("trainList", trainList);

        return "train/trainList";
    }

   /* @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable(value="id") String id, Model model){
        Train train = trainService.getById(id);
        model.addAttribute("train", train);
        List<Route> routeList = rootService.getAll();
        model.addAttribute("routeList", routeList);
        return "train/updateTrain";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("train") @RequestBody Train train) {
        Platform platform = train.getPlatform();
        String id = train.getId();
        trainService.update(train);
        train.setPlatform(platform);
        Duration timeOfStop = Duration.between(train.getTimeOfDeparture(),train.getTimeOfArrival());
        train.setTimeOfStop(timeOfStop);
        train.setId(id);

        return "redirect:/ui/train/get/all";
    }*/

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Train train = new Train();
        model.addAttribute("train", train);
        List<Platform> platformList = platformService.getAll();
        model.addAttribute("platformList", platformList);
        List<Route> routeList = rootService.getAll();
        model.addAttribute("routeList", routeList);
        return "train/newTrain";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("train") @RequestBody Train train) {
        Duration timeOfStop = Duration.between(train.getTimeOfDeparture(),train.getTimeOfArrival());
        train.setTimeOfStop(timeOfStop);
        train.setPlatform(getPlatform());
        model.addAttribute("train", trainService.create(train));


        return "redirect:/ui/train/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        trainService.delete(id);
        return "redirect:/ui/train/get/all";
    }

    public Platform getPlatform(){

        List<Platform> platformList = platformService.getAll();

        Platform firstFree = platformList.stream().filter(elem->elem.isFree() == true).findFirst().orElse(null);

        return firstFree;
    }

}
