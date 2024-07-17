package lesson4.task2.model;

import lesson4.task2.enums.Gender;

public class Customer {
    private String name;
    private int id;
    private Gender gender;

    public Customer(String name, int id, Gender gender) {
        this.name = name;
        this.id = id;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}