package com.vorova.controller;

import com.vorova.model.User;
import com.vorova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", userService.allUsers());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public String add(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userService.add(user);
        return "redirect: /";
    }

    @GetMapping(value="/delete/{id}")
    public String delete(@PathVariable long id) {
        User user = new User();
        user.setId(id);
        userService.delete(user);
        return "redirect: /";
    }

    @GetMapping(value="/edit/{id}")
    public ModelAndView edit(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("user", userService.getById(id));

        modelAndView.setViewName("edit");
        return modelAndView;
    }

    @PostMapping(value="/save")
    public ModelAndView edit(@RequestParam String id, @RequestParam String name, @RequestParam String email) {
        ModelAndView modelAndView = new ModelAndView();

        User user = new User();

        user.setId(Long.parseLong(id));
        user.setName(name);
        user.setEmail(email);

        userService.edit(user);

        modelAndView.setViewName("redirect: /");
        return modelAndView;
    }

}
