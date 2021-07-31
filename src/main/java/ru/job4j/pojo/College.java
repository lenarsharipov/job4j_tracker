package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstName("Иван");
        student.setSecondName("Иванов");
        student.setFatherName("Иванович");
        student.setGroup("2021-407");
        student.setEntryDate("31.07.2021");
        System.out.println("Фамилия          : " + student.getSecondName() + System.lineSeparator()
                         + "Имя              : " + student.getFirstName() + System.lineSeparator()
                         + "Отчество         : " + student.getFatherName() + System.lineSeparator()
                         + "Группа           : " + student.getGroup() + System.lineSeparator()
                         + "Дата поступления : " + student.getEntryDate() + System.lineSeparator());
    }
}
