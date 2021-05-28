package dan.HomeWork.Repo;

import dan.HomeWork.Models.Dog;
import dan.HomeWork.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog,Integer> {
    List<Person> findByPerson2OrderByNameAsc(Person person);
}
