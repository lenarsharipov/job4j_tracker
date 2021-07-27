/*
* 1.8. Состояние объекта [#167388]
* Задание:
* 1. Создать класс ru.job4j.oop.Battery. в нем должно быть поле private int load.
* 2. Создать метод public void exchange(Battery another). Этот метод должен
*    списывать заряд из батареи у кого вызывали метод exchange и добавить к объекту another.
* 3. Залейте код в репозиторий.
* 4. Выставьте ответственного Петра Арсентьева.
 */

package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int level) {
        this.load = level;
    }

    public void exchange(Battery another) {
        another.load = another.load + this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(50);
        Battery second = new Battery(30);
        System.out.println("First battery level : " + first.load);
        System.out.println("Second battery level : " + second.load);
        first.exchange(second);
        System.out.println("First battery level : " + first.load);
        System.out.println("Second battery level : " + second.load);
    }
}