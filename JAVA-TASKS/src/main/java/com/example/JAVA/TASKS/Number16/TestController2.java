package com.example.JAVA.TASKS.Number16;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController2 {
    @Autowired
    User2Service userService;
    @GetMapping("/allFootBaller")
    public String viewsAllFootBaller(Model model){
        System.out.println(userService.getUsers());
        model.addAttribute("allPeople",userService.getUsers());
        return "index";
    }
    @GetMapping("/allFootBaller/add")
    public String addFootBaller(){
        return "add";
    }
    @GetMapping("showPeople/{id}")
    public String ShowPeople(@PathVariable("id") int id, Model model){
        model.addAttribute("person",userService.getUser(id));
        model.addAttribute("url",id +"/addDogs");
        return "person";
    }
    @PostMapping("/addFootBaller/add")
    public String addPostFootBaller(@Autowired Person footBaller){
        userService.add(footBaller);
        return "redirect:/allFootBaller";
    }
    @PostMapping("showPeople/{id}")
    public String deleteFootBaller(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/allFootBaller";
    }
    @GetMapping("showPeople/{id}/addDogs")
    public String addDogsGet(@PathVariable("id") int id,Model model){
        String url = "/addDogs/"+id;
        System.out.println(url);
        model.addAttribute("url",url);
        return "addDogs";
    }
    @PostMapping("/addDogs/{id}")
    public String addDogsPost(@PathVariable("id") int id, @ModelAttribute Dog dog){

        userService.addDogs(id,dog);
        return "redirect:/showPeople/"+id;
    }
}
