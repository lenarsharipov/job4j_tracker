/*
* 3. Перегрузить метод max для трех чисел [#122644]
* Задание:
* 1. В классе ru.job4j.condition.Max из задания
* "4.2. Максимум из двух чисел" добавить перегруженный
* метод max для трех и четырех чисел. Постарайтесь,
* аналогично, примеру из задания переиспользовать уже существующие методы.
* 2. Написать тесты.
* 3. Залить код и перевести ответственного на Арсентьева Петра.
 */

package ru.job4j.oop;

public class Max {
    public static int max(int first, int second) {
        return first >= second ? first : second;
    }

    public static int max(int first, int second, int third) {
        return max(first, max(second, third));
    }

    public static int max(int first, int second, int third, int fourth) {
        return max(first, max(second, third, fourth));
    }

}