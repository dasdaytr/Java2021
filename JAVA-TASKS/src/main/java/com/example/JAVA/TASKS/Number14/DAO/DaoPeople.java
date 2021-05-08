package com.example.JAVA.TASKS.Number14.DAO;

import com.example.JAVA.TASKS.Number14.Model.FootBaller;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DaoPeople {
    private int id = 2;
    private List <FootBaller> footBallers;
    {
        footBallers = new ArrayList<>();
        footBallers.add(new FootBaller(1,"dan","svitki"));
        footBallers.add(new FootBaller(2,"Nikita","Klimenko"));
    }
    public List<FootBaller> findAll(){
        return footBallers;
    }
    public FootBaller findFootBaller(int id){
        return footBallers.stream().filter(x->x.getId()==id).findAny().orElse(null);
    }
    public void deleteFootBaller(int id){
        footBallers.remove(footBallers.stream().filter(x->x.getId()==id).findAny().orElse(null));
    }
    @Override
    public String toString() {
        return "DaoPeople{" +
                "footBallers=" + footBallers +
                '}';
    }
    public void add(FootBaller footBaller){
        footBaller.setId(++id);
        footBallers.add(footBaller);
    }
}
