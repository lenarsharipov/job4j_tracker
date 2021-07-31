package ru.job4j.inheritance;

public class Engineer extends Profession {

    private String id;

    public Engineer(String name, String surname, String education, String birthday, String id) {
        super(name, surname, education, birthday);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Project analyse(Client client) {
        return new Project(client.getCompany(), client.getAddress(), client.getTask(), "deadline");
    }

    public Project design(Client client) {
        return new Project(client.getCompany(), client.getAddress(), client.getTask(), "deadline");
    }

}