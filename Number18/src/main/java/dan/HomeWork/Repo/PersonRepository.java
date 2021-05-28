package dan.HomeWork.Repo;

import dan.HomeWork.Models.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    Person findById(int id);


}
