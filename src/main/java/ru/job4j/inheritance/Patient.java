package ru.job4j.inheritance;

public class Patient {

    private String name;
    private String surname;
    private String id;
    private String birthday;
    private String symptoms;

    public Patient() {
    }

    public Patient(String name, String surname, String id, String birthday, String symptoms) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.birthday = birthday;
        this.symptoms = symptoms;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getId() {
        return id;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getSymptoms() {
        return symptoms;
    }

}