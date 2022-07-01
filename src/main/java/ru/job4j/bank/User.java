package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банка, которая содержит
 * номер паспорта и ФИО клиента.
 * @author Lenar Sharipov
 * @version 1.0
 */
public class User {
    /**
     * Хранение уникального паспортного номера и имени клиента осуществляется
     * в приватных полях типа String.
     */
    private String passport;
    private String username;

    /**
     * Конструктор принимает указанные данные и инициализирует поля.
     * @param passport - уникальный паспортный код клиента.
     * @param username - имя клиента.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттер поля.
     * @return - возвращает значение поля {@link User#passport}.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер поля.
     * @param passport - уникальный код паспорта, который можно перезаписать в поле.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер поля.
     * @return - возвращает значение поля {@link User#username}.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер поля.
     * @param username - имя клиента, которое можно перезаписать.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод equals сравнивает содержимое объектов и выводит
     * значение типа {@code boolean}.
     * Помимо стандартного сравнения, здесь происходит сравнение по уникальному
     * полю {@link User#passport}.
     * @param o - это объект, с которым будет сравниваться модель данных.
     * @return {@code true} если содержимое эквивалентно, {@code false} - если нет.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределенный метод hashCode.
     * @return возвращает хеш код модели данных типа {@code int}
     * на основе уникального поля {@link User#passport}.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}