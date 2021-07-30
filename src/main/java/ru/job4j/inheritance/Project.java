package ru.job4j.inheritance;

public class Project {

    private String company;
    private String address;
    private String task;
    private String deadLine;

    public Project() {
    }

    public Project(String company, String address, String task, String deadLine) {
        this.company = company;
        this.address = address;
        this.task = task;
        this.deadLine = deadLine;
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

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

}