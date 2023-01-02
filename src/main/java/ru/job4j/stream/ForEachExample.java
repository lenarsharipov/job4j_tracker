package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

/**
 *  Демонстрация работы методов Stream API - forEach(), peek().
 */
public class ForEachExample {
    private static final List<String> STRINGS = Arrays.asList("One", "Two", "Three");
    private static final List<StringBuilder> NAMES = Arrays.asList(
            new StringBuilder("Michael"),
            new StringBuilder("Ivan"),
            new StringBuilder("Helen")
    );

    /**
     *  forEach() - это конечная операция. Выполняет действие для каждого элемента потока,
     * завершая поток.
     */
    public static void doForEach() {
        STRINGS.stream()
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }

    /**
     *  peek() - это промежуточная операция, которая выполняет действие для каждого элемента потока,
     * возвращая поток, состоящий из измененных элементов.
     * Так как peek() - промежуточный метод, то после изменения эти объекты можно использовать
     * дальше в этом потоке, применяя другие промежуточные методы. В данном методе после метода
     * peek() демонстрируется применение другого промежуточного метода после выполнения
     * peek() - сортировки элементов в листе по возрастанию.
     *  Также метод peek() похож на метод map(). Разница между этими методами в том,
     * что peek() просто преобразует элементы потока и возвращает поток из измененных
     * элементов того же типа, а метод map() в процессе преобразования элементов
     * может возвращать поток из элементов другого типа после изменения.
     * Поэтому метод peek() чаще используется в отладочных целях для вывода
     * состояния элемента в потоке, нежели для каких-либо преобразований.
     */
    public static void doPeek() {
        List<StringBuilder> editedNames = NAMES.stream()
                .peek(el -> el.append(" (Job4j Student)"))
                .sorted()
                .toList();
        System.out.println(editedNames);
    }

    public static void main(String[] args) {
        doForEach();
        doPeek();
    }
}
