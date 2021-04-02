package ru;

import org.springframework.stereotype.Component;
import javax.annotation.*;

@Component
public class ClassicalMusic implements Music {
    @Override
    public String getSong() {
        return "Hungarian Rhapsod";
    }

    public void doMyInit(){
        System.out.println("Doing my initialization");
    }

    public  void  doMyDestroy(){
        System.out.println("Doing my Destruction");
    }
}
