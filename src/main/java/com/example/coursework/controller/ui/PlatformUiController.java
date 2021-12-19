package com.example.coursework.controller.ui;

import com.example.coursework.model.Platform;
import com.example.coursework.model.Route;
import com.example.coursework.service.platform.PlatformServiceImpl;
import com.example.coursework.service.train.RootServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/platform")
@Controller
public class PlatformUiController {

    @Autowired
    PlatformServiceImpl platformService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Platform> platformList = platformService.getAll();
        model.addAttribute("platformList", platformList);

        return "platform/platformList";
    }

 /*   @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable(value="id") String id, Model model){
        Platform platform = platformService.getById(id);
        model.addAttribute("platform", platform);

        return "platform/updatePlatform";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("route") @RequestBody Platform platform) {

        platformService.update(platform);
        return "redirect:/ui/platform/get/all";
    }*/

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {

        Platform platform = new Platform();
        model.addAttribute("platform", platform);

        return "platform/newPlatform";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("platform") @RequestBody Platform platform) {
        platform.setFree(true);
        model.addAttribute("platform", platformService.create(platform));
        return "redirect:/ui/platform/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id) {
        platformService.delete(id);
        return "redirect:/ui/platform/get/all";
    }



}