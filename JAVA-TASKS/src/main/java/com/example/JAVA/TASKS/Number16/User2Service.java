package com.example.JAVA.TASKS.Number16;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
@Component
@RequiredArgsConstructor
public class User2Service {
    private final SessionFactory sessionFactory;
    private Session session;
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
    public void addDogs(int id,Dog dog){
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
}
