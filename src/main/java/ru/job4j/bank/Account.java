package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счёта, который содержит
 * баланс и реквизиты.
 * @author Lenar Sharipov
 * @version 1.0
 */
public class Account {
    /**
     * Хранение уникального реквизита счёта в приватной переменной типа String
     * и баланса в приватной переменной типа double.
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор принимает указанные данные и инициализирует поля.
     * @param requisite - уникальные реквизиты счёта.
     * @param balance - баланс счёта.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер поля.
     * @return - возвращает значение поля {@link Account#requisite}.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер поля.
     * @param requisite - уникальные реквизиты счёта, которые можно перезаписать.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер поля.
     * @return - возвращает значение поля {@link Account#balance}.
     */public double getBalance() {
        return balance;
    }

    /**
     * Сеттер поля.
     * @param balance - баланс счёта, который можно перезаписать.
     */public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределенный метод equals сравнивает содержимое объектов и выводит
     * значение типа {@code boolean}.
     * Помимо стандартного сравнения, здесь происходит сравнение по уникальному
     * полю {@link Account#requisite}.
     * @param o - это объект, с которым будет сравниваться модель данных.
     * @return {@code true} если содержимое эквивалентно, {@code false} - если нет.
     */@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределенный метод hashCode.
     * @return возвращает хеш код модели данных типа {@code int}
     * на основе уникального поля {@link Account#requisite}.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}