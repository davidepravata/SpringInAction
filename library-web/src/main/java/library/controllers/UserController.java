package library.controllers;

import library.entities.User;
import library.repositories.jpa.UsersRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UsersRepositoryJPA usersRepositoryJPA;

    @Autowired
    public UserController(UsersRepositoryJPA usersRepositoryJPA) {
        this.usersRepositoryJPA = usersRepositoryJPA;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String retrieveAvailableUsers(Model model) {

        List<User> availableUsers = usersRepositoryJPA.findAll();
        if (availableUsers != null) {
            model.addAttribute("users", availableUsers);
        }
        return "users";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String addUsers(User user) {
        usersRepositoryJPA.save(user);
        return "redirect:/users";
    }

}
