package sk.fei.stuba.oop.zadanie3.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sk.fei.stuba.oop.zadanie3.model.user.User;
import sk.fei.stuba.oop.zadanie3.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;
    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/adduser")
    public String adduser(Model model) {
        model.addAttribute("item", new User());
        LOGGER.warn("adduser" + model.toString());
        return "user/adduser";
    }

    @PostMapping("/adduser")
    public String submit(@ModelAttribute("item") @Valid User item, Model model) {
        LOGGER.warn("submit " + item.toString());
        try {
            userService.addNewUser(item);
            return "redirect:/index";
        } catch (IllegalArgumentException ex) {
            System.err.println("SUBMIT ERROR");
            return "error";
        }
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        User user  = userService.getUserById(id);
        LOGGER.warn("edit " + user.toString());
        model.addAttribute("item",user);
        return "user/edituser";
    }
    @GetMapping("details/{id}")
    public String details(@PathVariable("id") String id, Model model) {
        User user  = userService.getUserById(id);
        LOGGER.warn("details " + user.toString());
        model.addAttribute("items",user);
        return "user/viewoneuser";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("item") @Valid User item, Model model) {
        LOGGER.warn("Update " + item.toString());
        try {
            item.setListOfContracts(userService.getUserById(item.getUserId()).getListOfContracts());
            userService.editUser(item);
            model.addAttribute("items", item);
            return "user/viewoneuser";
        } catch (IllegalArgumentException ex) {
            System.err.println("UPDATE ERROR");
            return "error";
        }
    }


    @GetMapping("/index")
    public String findAll(Model model) {
        model.addAttribute("items", userService.getAllUser());
        return "user/viewusers";
    }



    @GetMapping()
    public String index() {
        return "redirect:/index";
    }


}
