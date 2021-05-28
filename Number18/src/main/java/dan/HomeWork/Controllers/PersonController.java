package dan.HomeWork.Controllers;

import dan.HomeWork.Models.Person;
import dan.HomeWork.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/allFootBaller")
    public String viewsAllFootBaller(Model model) {
        model.addAttribute("allPeople", personService.findAllPersons());
        return "index";
    }

    @GetMapping("showPeople/{id}")
    public String ShowPeople(@PathVariable("id") int id, Model model) {

        model.addAttribute("person", personService.findPersonID(id));
        model.addAttribute("url", id + "/addDogs");
        return "person";
    }

    @GetMapping("/allFootBaller/add")
    public String addFootBaller() {
        return "add";
    }

    @PostMapping("/addFootBaller/add")
    public String addPostFootBaller(@Autowired Person footBaller) {
        personService.addPerson(footBaller);
        return "redirect:/allFootBaller";
    }

    @PostMapping("showPeople/{id}")
    public String deleteFootBaller(@PathVariable("id") int id) {
        personService.deletePerson(id);
        return "redirect:/allFootBaller";
    }

    @PostMapping("allFootBaller/lastname")
    public String orderPersonLast(Model model) {
        model.addAttribute("allPeople", personService.sortLastName());
        return "index";
    }

    @PostMapping("allFootBaller/FirstName")
    public String orderPersonFirst(Model model) {
        model.addAttribute("allPeople", personService.sortFirstName());
        return "index";
    }
}
