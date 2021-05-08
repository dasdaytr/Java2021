package com.example.JAVA.TASKS.Number15.DAO;

//import com.example.JAVA.TASKS.Number15.Model.Person;
import com.example.JAVA.TASKS.Number16.Person;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserService{
    private final SessionFactory sessionFactory;
    private Session session;
    @PostConstruct
    public void init(){
        session = sessionFactory.openSession();
    }
    public List <Person> getUsers(){
        return session.createQuery("select u from Person u",Person.class).getResultList();
    }
    public Person getUsers(int id){
        Query query = session.createQuery("FROM Person u where u.id = : id");
        query.setParameter("id",id);
        List<Person> list = query.getResultList();
        return list.get(0);
    }
    public void add(Person person){
        var transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
    }
    public void delete(int id){
        Query query = session.createQuery("FROM Person u where u.id = : id");
        query.setParameter("id",id);
        List<Person> list = query.getResultList();
        var transaction = session.beginTransaction();
        session.delete(list.get(0));
        transaction.commit();
    }
}
