package ru.job4j.inheritance;

public class Diagnosis {

    private String name;
    private String surname;
    private String id;
    private String birthday;
    private String symptoms;

    public Diagnosis() {
    }

    public Diagnosis(String name, String surname, String id, String birthday, String symptoms) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.birthday = birthday;
        this.symptoms = symptoms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

}