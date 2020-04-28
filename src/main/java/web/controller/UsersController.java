package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    UserService userService = UserServiceImpl.getInstance();


    @RequestMapping("/users")
    public String printUsers(ModelMap model) {

        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "users";
    }


    @PostMapping("/users")
    public String addUser(@ModelAttribute(name = "user") User user) {

        userService.addUser(user);
        return "redirect:/users";

    }

    @PostMapping("/delete")
    public String deleteUser(@ModelAttribute(name = "id") Long id) {

        userService.deleteUser(userService.getUserById(id));

        return "redirect:/users";
    }


    @GetMapping("/update")
    public String updateUser(ModelMap model, @ModelAttribute(name = "id") Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update";

    }

    @PostMapping("/update")
    public String confirmUpdate(@ModelAttribute User user) {

        userService.updateUser(user);
        return "redirect:/users";

    }

}
