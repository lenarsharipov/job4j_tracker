package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    public Surgeon() {
    }

    public Surgeon(String name, String surname, String education, String birthday, String id) {
        super(name, surname, education, birthday, id);
    }

    public Diagnosis excise(Patient patient) {
        return new Diagnosis(patient.getName(), patient.getSurname(), patient.getId(), patient.getBirthday(), patient.getSymptoms());
    }

    public Diagnosis transplant(Patient patient) {
        return new Diagnosis(patient.getName(), patient.getSurname(), patient.getId(), patient.getBirthday(), patient.getSymptoms());
    }

}