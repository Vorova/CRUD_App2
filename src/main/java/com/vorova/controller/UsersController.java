package com.vorova.controller;

import com.vorova.model.User;
import com.vorova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {

    private final UserService userService;
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/")
    public String main(ModelMap model) {
        model.addAttribute("users", userService.allUsers());
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping(value = "/add")
    public String add(@ModelAttribute User user) {
        userService.add(user);
        return "redirect: /";
    }

    @GetMapping(value="/delete/{id}")
    public String delete(@PathVariable long id) {
        userService.delete(id);
        return "redirect: /";
    }

    @GetMapping(value="/edit/{id}")
    public String edit(@PathVariable long id, ModelMap model) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @PostMapping(value="/save")
    public String save(@ModelAttribute User user) {
        userService.edit(user);
        return "redirect: /";
    }

}
