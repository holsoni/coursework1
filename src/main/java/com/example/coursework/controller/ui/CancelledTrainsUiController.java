package com.example.coursework.controller.ui;

import com.example.coursework.model.CancelledTrain;
import com.example.coursework.model.Train;
import com.example.coursework.service.cancelledTrain.CancelledTrainServiceImpl;
import com.example.coursework.service.platform.PlatformServiceImpl;
import com.example.coursework.service.route.TrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping("/ui/cancelledTrains")
@Controller
public class CancelledTrainsUiController {

        @Autowired
        CancelledTrainServiceImpl trainService;

        @RequestMapping("/get/all")
        public String showAll(Model model){

            List<CancelledTrain> trainList =  trainService.getAll();

            model.addAttribute("trainList", trainList);

            return "cancelled/trainList";

    }
    @GetMapping("/deleteAll")
    public String deleteAll(Model model) {
        trainService.deleteAll();
        return "cancelled/trainList";
    }
}
