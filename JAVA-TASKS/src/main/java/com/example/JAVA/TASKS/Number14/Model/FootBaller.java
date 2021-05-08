package com.example.JAVA.TASKS.Number14.Model;

public class FootBaller {
    private String firstName;
    private String lastName;
    private int id;
    public FootBaller(){

    }
    public FootBaller(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public FootBaller(int id,String firstName, String lastName) {
        this.id = id ;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "FootBaller{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}
