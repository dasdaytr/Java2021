package dan.HomeWork.Service;

import dan.HomeWork.Models.Dog;
import dan.HomeWork.Models.Person;
import dan.HomeWork.Repo.DogRepository;
import dan.HomeWork.Repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {
    @Autowired
    DogRepository dogRepository;
    @Autowired
    PersonRepository personRepository;

    public void addDogs(int id, Dog dog) {
        Person person = personRepository.findById(id);
        dog.setPerson2(person);
        dogRepository.save(dog);
    }

    public List<Person> sortDogs(int id) {
        Person person = personRepository.findById(id);
        return dogRepository.findByPerson2OrderByNameAsc(person);
    }
}
