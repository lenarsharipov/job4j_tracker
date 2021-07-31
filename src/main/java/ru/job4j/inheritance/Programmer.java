package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String technologyStack;

    public Programmer(String name, String surname, String education, String birthday, String id, String technologyStack) {
        super(name, surname, education, birthday, id);
        this.technologyStack = technologyStack;
    }

    public String getTechnologyStack() {
        return technologyStack;
    }

    public void setTechnologyStack(String technologyStack) {
        this.technologyStack = technologyStack;
    }

    public Project parse(Client client) {
        return new Project(client.getCompany(), client.getAddress(), client.getTask(), "deadline");
    }

}