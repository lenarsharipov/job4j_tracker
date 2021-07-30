package ru.job4j.inheritance;

public class Client {

    private String company;
    private String address;
    private String task;

    public Client() {
    }

    public Client(String company, String address, String task) {
        this.company = company;
        this.address = address;
        this.task = task;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

}