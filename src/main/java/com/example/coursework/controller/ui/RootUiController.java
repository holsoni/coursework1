package com.example.coursework.controller.ui;

import com.example.coursework.model.Route;
import com.example.coursework.model.Train;
import com.example.coursework.service.route.TrainServiceImpl;
import com.example.coursework.service.train.RootServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/route")
@Controller
public class RootUiController {

    @Autowired
    RootServiceImpl rootService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Route> routeList = rootService.getAll();
        model.addAttribute("routeList", routeList);

        return "route/routeList";
    }

  /*  @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable(value="id") String id, Model model){
        Route route = rootService.getById(id);
        model.addAttribute("route", route);

        return "route/updateRoute";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("route") @RequestBody Route route) {

        rootService.update(route);
        return "redirect:/ui/route/get/all";
    }*/

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Route route = new Route();
        model.addAttribute("route", route);

        return "route/newRoute";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("route") @RequestBody Route route) {

        route.setName(route.getStartStation()+" - " + route.getEndStation());
        model.addAttribute("route", rootService.create(route));
        return "redirect:/ui/route/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id) {
        rootService.delete(id);
        return "redirect:/ui/route/get/all";
    } }