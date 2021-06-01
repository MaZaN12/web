package com.example.blogtest.contoller;

import com.example.blogtest.entity.Users;
import com.example.blogtest.repo.MainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class GeneralController {

    @Autowired
    private MainRepo mainRepo;

    @GetMapping("/authorization")
    public String authorizationGet(Model model){
        return "authorization";
    }
    @PostMapping("/authorization")
        public String authorizationPost(Model model){
        return "authorization";
    }
    @GetMapping("/registration")
    public String registrationGet(Model model){
        return "registration";
    }
    @PostMapping("/registration")
    public String registrationPost(Model model){
        return "registration";
    }

    @GetMapping("/home")
    public String homeGet(Model model) {
        Iterable<Users> mainEntity = mainRepo.findAll();
        model.addAttribute("user", mainEntity);
        return "home";
    }
    @PostMapping("/home")
    public String homePost(Model model) {
        return "redirect:/home";
    }

    @GetMapping("/addingUser")
    public String addingUserGet(Model model) {
        return "addingUser";
    }

    @GetMapping("/userEditing")
    public String userEditingGet(Model model) {
        return "userEditing";
    }

    @GetMapping("/userEditingSearch")
    public String userEditingSearchGet(Model model) {
        return "userEditingSearch";
    }
}