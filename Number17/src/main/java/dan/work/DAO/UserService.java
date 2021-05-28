package dan.work.DAO;

import dan.work.Model.Dog;
import dan.work.Model.Person;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;
import java.util.List;
@Component
@RequiredArgsConstructor
public class UserService {
    private final SessionFactory sessionFactory;
    private Session session;
    CriteriaBuilder builder;
    @PostConstruct
    public void init(){
        session = sessionFactory.openSession();
    }
    public List<Person> getUsers(){
        return session.createQuery("select u from Person u", Person.class).getResultList();
    }
    public Person getUser(int id){
        return req(id);
    }
    public void add(Person person){
        var transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
    }
    public void delete(int id){
        var transaction = session.beginTransaction();
        session.delete(req(id));
        transaction.commit();
    }
    public  Person  req(int id){
        Query query = session.createQuery("FROM Person u where u.id = : id");
        query.setParameter("id",id);
        List<Person> list = query.getResultList();
        return list.get(0);
    }
    public void addDogs(int id, Dog dog){
        var transaction = session.beginTransaction();
        session.createQuery("select u from Person u", Person.class).getResultList().stream().filter(x->x.getId() ==id).findAny()
                .map(person -> {
                    dog.setPerson2(person);
                    session.save(dog);
                    session.save(person);
                    return null;
                });
        transaction.commit();
    }
    public List<Person> orderPersonLastName(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Person> personCriteriaQuery = builder.createQuery(Person.class);
        Root <Person> root = personCriteriaQuery.from(Person.class);
        personCriteriaQuery.select(root).orderBy(builder.asc(root.get("lastName")));
        Query <Person> query = session.createQuery(personCriteriaQuery);
        return  query.getResultList();
    }
    public List<Person> orderPersonFirstNamw(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Person> personCriteriaQuery = builder.createQuery(Person.class);
        Root <Person> root = personCriteriaQuery.from(Person.class);
        personCriteriaQuery.select(root).orderBy(builder.asc(root.get("firstName")));
        Query <Person> query = session.createQuery(personCriteriaQuery);
        return  query.getResultList();
    }
    public List<Tuple> orderDogs(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = builder.createTupleQuery();
        Root <Dog> dog = cq.from(Dog.class);
        Join<Person,Dog> dogs = dog.join("person2",JoinType.LEFT);
        cq.select(builder.tuple(dog,builder.count(dogs)));
        cq.groupBy(dog.get("id"));
        cq.orderBy(builder.asc(dog.get("name")));
        List<Tuple> result = session.createQuery(cq).getResultList();
        for (Tuple t : result) {
            Dog c = (Dog) t.get(0);
            Long cnt = (Long) t.get(1);
            System.out.println("Customer " + c.getName() + " has " + cnt + " orders");
        }


        return  session.createQuery(cq).getResultList();
    }
}
