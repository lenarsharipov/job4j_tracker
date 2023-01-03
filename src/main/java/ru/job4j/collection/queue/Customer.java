package ru.job4j.collection.queue;

/**
 * Модель данных, описывающая клиента магазина.
 * @param name Имя клиента
 * @param amount Сумма денег
 */
public record Customer(String name, int amount) {
}
