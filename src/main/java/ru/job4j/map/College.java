package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        return students.keySet()
                .stream()
                .filter(student -> student.getAccount().equals(account))
                .findFirst();
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        return findByAccount(account)
                .flatMap(value -> students.get(value)
                .stream()
                .filter(student -> student.getName().equals(name))
                .findFirst());
    }

}