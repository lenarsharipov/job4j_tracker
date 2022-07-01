package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу простейшего банковского сервиса.
 * @author Lenar Sharipov
 * @version 1.0
 */
public class BankService {
    /**
     * Поле содержит всех пользователей системы
     * с привязанными к ним счетами в коллекции типа HashMap.
     * Ключом коллекции является {@link User}, значением - коллекция типа ArrayList,
     * хранящая {@link Account}.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему с привязанным к нему счётом.
     * В методе осуществляется проверка на наличие такого пользователя в системе.
     * Если такого пользователя еще нет, он добавляется. Если он есть, то
     * новый пользователь не добавляется.
     * @param user - новый пользователь, который будет добавлен, при
     *             выполнении всех условий метода.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый счёт к пользователю.
     * Метод проверяет наличие в системе пользователя по передаваемому паспорту.
     * Если пользователь найден, то метод проверяет все счета пользователя в системе.
     * Если счёта, с указанными реквизитами нет, то пользователю добавляется новый счёт.
     * @param passport - номер паспорта, по которому происходит поиск пользователя.
     * @param account - счёт, который планируется добавить пользователю.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод находит пользователя в системе.
     * @param passport - номер паспорта, по которому происходит поиск пользователя.
     * @return возвращает пользователя в системе при его наличии
     * или null, если пользователь не найден.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод находит счёт по передаваемым паспортным данным и реквизитам.
     * @param passport - номер паспорта, по которому происходит поиск пользователя в системе.
     * @param requisite - реквизиты, по которым происходит поиск счёта
     * у найденного пользователя.
     * @return возвращает найденный счёт или null, если счёт не найден.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод перечисляет деньги с исходного счёта на конечный,
     * при условии, что счета найдены и на первом достаточно баланса.
     * @param srcPassport - номер паспорта исходного счёта.
     * @param srcRequisite - реквизиты исходного счёта.
     * @param destPassport - номер паспорта конечного счёта
     * @param destRequisite - реквизиты конечного счёта.
     * @param amount - перечисляемая сумма.
     * @return возвращает {@code true}, если деньги перечислены,
     * и {@code false} если нет.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}