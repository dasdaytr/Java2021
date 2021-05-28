package dan.HomeWork.Service;


import dan.HomeWork.Models.Person;
import dan.HomeWork.Repo.PersonRepository;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Iterable<Person> findAllPersons() {
        return personRepository.findAll();
    }

    public Person findPersonID(int id) {
        return personRepository.findById(id);
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

    public List<Person> sortLastName() {
        return personRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
    }

    public List<Person> sortFirstName() {
        return personRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
    }
}
