package ru.job4j.inheritance;

public class Dentist extends Doctor {

    public Dentist(String name, String surname, String education, String birthday, String id) {
        super(name, surname, education, birthday, id);
    }

    public Diagnosis removeTeeth(Patient patient) {
        return new Diagnosis(patient.getName(), patient.getSurname(), patient.getId(), patient.getBirthday(), patient.getSymptoms());
    }

    public Diagnosis fillCavity(Patient patient) {
        return new Diagnosis(patient.getName(), patient.getSurname(), patient.getId(), patient.getBirthday(), patient.getSymptoms());
    }

}