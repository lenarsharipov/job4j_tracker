package ru.job4j.lombok;

import lombok.*;

import java.util.List;

/**
 * Шаблон Builder позволяет избавить синтаксис от get set префиксов, что делает код чище.
 * Ключ builderMethodName задает имя метода создания объекта контейнера.
 * По умолчанию он называется builder().
 */
@Builder(builderMethodName = "of")
@ToString
@Getter
public class Role {

    private int id;
    private String name;

    /**
     * Аннотация @Singular позволяет аккумулировать отдельные элементы коллекции.
     * Если ее убрать, то метод accessBy должен принимать список.
     */
    @Singular("accessBy")
    private List<String> accessBy;

    public static void main(String[] args) {
        var role = Role.of()
                .id(1)
                .name("ADMIN")
                .accessBy("create")
                .accessBy("update")
                .accessBy("read")
                .accessBy("delete")
                .build();
        System.out.println(role);
    }
}