package dan.HomeWork.Controllers;

import dan.HomeWork.Models.Dog;
import dan.HomeWork.Service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DogController {
    @Autowired
    private DogService dogService;
    @GetMapping("showPeople/{id}/addDogs")
    public String addDogsGet(@PathVariable("id") int id, Model model){
        String url = "/addDogs/"+id;
        model.addAttribute("url",url);
        return "addDogs";
    }
    @PostMapping("/addDogs/{id}")
    public String addDogsPost(@PathVariable("id") int id, @ModelAttribute Dog dog){

        dogService.addDogs(id,dog);
        return "redirect:/showPeople/"+id;
    }
    @PostMapping("showPeoplee/{id}")
    public String orderDoga(@PathVariable("id") int id, Model model) {
        model.addAttribute("person",dogService.sortDogs(id));
        return "person";
    }
}
