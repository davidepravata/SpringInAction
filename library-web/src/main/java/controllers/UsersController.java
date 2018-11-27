package controllers;

import entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repositories.jpa.UsersRepositoryJPA;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UsersRepositoryJPA usersRepositoryJPA;

    @Autowired
    public UsersController(UsersRepositoryJPA usersRepositoryJPA) {
        this.usersRepositoryJPA = usersRepositoryJPA;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String retrieveAvailableUsers(Model model) {

        List<Users> availableUsers = usersRepositoryJPA.findAll();
        if (availableUsers != null) {
            model.addAttribute("users", availableUsers);
        }
        return "users";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String addUsers(Users user) {
        usersRepositoryJPA.save(user);
        return "redirect:/users";
    }

}
