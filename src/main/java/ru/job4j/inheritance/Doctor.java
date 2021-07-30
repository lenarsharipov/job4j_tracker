package ru.job4j.inheritance;

public class Doctor extends Profession {

    private String id;

    public Doctor() {
    }

    public Doctor(String name, String surname, String education, String birthday, String id) {
        super(name, surname, education, birthday);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Diagnosis chekUp(Patient patient) {
        return new Diagnosis(patient.getName(), patient.getSurname(), patient.getId(), patient.getBirthday(), patient.getSymptoms());
    }

    public Diagnosis anesthetize(Patient patient) {
        return new Diagnosis(patient.getName(), patient.getSurname(), patient.getId(), patient.getBirthday(), patient.getSymptoms());
    }

    public Diagnosis heal(Patient patient) {
        return new Diagnosis(patient.getName(), patient.getSurname(), patient.getId(), patient.getBirthday(), patient.getSymptoms());
    }

}
