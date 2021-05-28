package dan.work.Controllers;
import dan.work.Model.Dog;
import dan.work.Model.Person;
import dan.work.DAO.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {
    @Autowired
    UserService userService;
    @GetMapping("/allFootBaller")
    public String viewsAllFootBaller(Model model){
        System.out.println(userService.getUsers());
        model.addAttribute("allPeople",userService.getUsers());
        return "index";
    }
    @PostMapping("allFootBaller/lastname")
    public String orderPersonLast(Model model){
        model.addAttribute("allPeople",userService.orderPersonLastName());
        return "index";
    }
    @PostMapping("allFootBaller/FirstName")
    public String orderPersonFirst(Model model){
        model.addAttribute("allPeople",userService.orderPersonFirstNamw());
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
    @PostMapping("showPeoplee/{id}")
    public String orderDoga(@PathVariable("id") int id, Model model) {
        model.addAttribute("person",userService.getUser(id));

        userService.orderDogs();
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
