package ru.job4j.collection.queue;

import java.util.Deque;
import java.util.Iterator;

/**
 * Класс ReconstructPhrase используется для демонстрации работы
 * логики структуры данных DEQUE(двусторонняя очередь), основных
 * методов - pollFirst(), peekFirst(), descendingIterator().
 *
 * @author Lenar Sharipov
 * @version 1.0
 */
public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    /**
     * Приватный метод getEvenElements() должен взять из очереди evenElements
     * только четные символы и все их собрать в результирующую строку.
     * @return результирующую строку в формате {@link String}.
     */
    private String getEvenElements() {
        StringBuilder sb = new StringBuilder();
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                sb.append(evenElements.peekFirst());
            }
            evenElements.pollFirst();
        }
        return sb.toString();
    }

    /**
     * Приватный метод getDescendingElements() должен брать символы начиная
     * с последнего символа и так пока не заберет их все. Каждый
     * символ мы добавляем в результирующую строку, формируем
     * с помощью {@link StringBuilder}.
     * @return результирующую строку в формате {@link String}.
     */
    private String getDescendingElements() {
        StringBuilder sb = new StringBuilder();
        Iterator<Character> iterator = descendingElements.descendingIterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        return sb.toString();
    }

    /**
     * Метод getReconstructionPhrase() возвращает результирующую строку
     * при помощи дополнительных приватных методов getDescendingElements(),
     * getEvenElements(). Результаты обоих методов "склеиваются" в результирующую строку.
     * @return результирующую строку в формате {@link String}.
     */
    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }

}
