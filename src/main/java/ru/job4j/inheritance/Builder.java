package ru.job4j.inheritance;

public class Builder extends Engineer {

    private String equipment;

    public Builder(String name, String surname, String education, String birthday, String id, String equipment) {
        super(name, surname, education, birthday, id);
        this.equipment = equipment;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public Project plaster(Client client) {
        return new Project(client.getCompany(), client.getAddress(), client.getTask(), "deadline");
    }

}