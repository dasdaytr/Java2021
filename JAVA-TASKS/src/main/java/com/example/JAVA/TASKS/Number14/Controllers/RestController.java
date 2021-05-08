package com.example.JAVA.TASKS.Number14.Controllers;

import com.example.JAVA.TASKS.Number14.DAO.DaoPeople;
import com.example.JAVA.TASKS.Number14.Model.FootBaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RestController {
    /*@Autowired
    private DaoPeople daoPeople;
    @GetMapping("/allFootBaller")
    public String viewsAllFootBaller(Model model){
        model.addAttribute("allPeople",daoPeople.findAll());
        return "index";
    }
    @GetMapping("/allFootBaller/add")
    public String addFootBaller(){
        return "add";
    }
    @GetMapping("showPeople/{id}")
    public String ShowPeople(@PathVariable("id") int id,Model model){
        model.addAttribute("person",daoPeople.findFootBaller(id));
        return "person";
    }
    @PostMapping("/addFootBaller/add")
    public String addPostFootBaller(@Autowired FootBaller footBaller){
        System.out.println(footBaller);
        daoPeople.add(footBaller);
        return "redirect:/allFootBaller";
    }
    @PostMapping("showPeople/{id}")
    public String deleteFootBaller(@PathVariable("id") int id){
        System.out.println(id);
        daoPeople.deleteFootBaller(id);
        return "redirect:/allFootBaller";
    }*/

}
