/*
package com.example.JAVA.TASKS.Number15.Controller;

import com.example.JAVA.TASKS.Number15.DAO.UserService;
import com.example.JAVA.TASKS.Number15.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    UserService userService;

    @GetMapping("/allFootBaller")
    public String viewsAllFootBaller(Model model){
        model.addAttribute("allPeople",userService.getUsers());
        return "index";
    }
    @GetMapping("/allFootBaller/add")
    public String addFootBaller(){
        return "add";
    }
    @GetMapping("showPeople/{id}")
    public String ShowPeople(@PathVariable("id") int id, Model model){
        model.addAttribute("person",userService.getUsers(id));
        return "person";
    }
    @PostMapping("/addFootBaller/add")
    public String addPostFootBaller(@Autowired Person footBaller){
        System.out.println(footBaller);
        userService.add(footBaller);
        return "redirect:/allFootBaller";
    }
    @PostMapping("showPeople/{id}")
    public String deleteFootBaller(@PathVariable("id") int id) {
        System.out.println(id);
        userService.delete(id);
        return "redirect:/allFootBaller";
    }
}
*/
