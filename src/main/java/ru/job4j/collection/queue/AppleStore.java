package ru.job4j.collection.queue;

import java.util.Queue;

/**
 * Модель данных, которая описывает магазин.
 */
public class AppleStore {
    /**
     * Поле queue хранит в себе очередь клиентов.
     * Данное поле не может быть пустым.
     */
    private final Queue<Customer> queue;
    /**
     * Поле count хранит в себе количество
     * доступного к покупке товара.
     */
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    /**
     * Метод getLastHappyCustomer() должен вернуть
     * имя последнего счастливого обладателя желаемого товара.
     * @return Имя последнего клиента, кому достался товар.
     */
    public String getLastHappyCustomer() {
        for (int i = 0; i < count - 1; i++) {
            queue.poll();
        }
        return queue.peek().name();
    }

    /**
     * метод getLastUpsetCustomer() должен вернуть
     * имя первого клиента, которому сегодня не повезло
     * и ему не хватило товара.
     * @return Имя первого клиента, кому не достался товар.
     */
    public String getLastUpsetCustomer() {
        for (int i = 0; i < count; i++) {
            queue.poll();
        }
        return queue.peek().name();
    }
}
