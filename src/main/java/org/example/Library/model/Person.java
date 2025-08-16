package org.example.Library.model;

import org.example.Library.exception.BadEntityException;

abstract class Person implements Entity {

    protected Integer id;
    protected String name;
    protected Gender gender;


    public Person() {
    }

    public Person(Integer id, String name, Gender gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public Integer getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public abstract void readFromConsole() throws BadEntityException;

    public void showOnConsole() {
        System.out.println("ID: " + id + " | Name: " + name + " | Gender: " + gender);
    }
}


