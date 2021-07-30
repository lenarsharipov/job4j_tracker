package ru.job4j.inheritance;

public class Profession {

    private String name;
    private String surname;
    private String education;
    private String birthday;

    public Profession() {
    }

    public Profession(String name, String surname, String education, String birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String aSurname) {
        this.surname = aSurname;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String anEducation) {
        this.education = anEducation;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String aBirthday) {
        this.birthday = aBirthday;
    }

}