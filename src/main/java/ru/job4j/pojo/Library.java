package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book book1 = new Book("Clean Code", "462");
        Book book2 = new Book("White Teeth: A Novel", "464");
        Book book3 = new Book("The Ocean at the End of the Lane", "181");
        Book book4 = new Book("The Paying Guests", "592");
        Book[] array = {book1, book2, book3, book4};
        print(array);
        swap(array, 0, 3);
        print(array);
        filteredPrint(array, "Clean Code");
    }

    public static void print(Book[] array) {
        for (int index = 0; index < array.length; index++) {
            System.out.println("Title : " + array[index].getTitle() + System.lineSeparator()
                             + "Pages : " + array[index].getPageCount() + System.lineSeparator());
        }
    }

    public static Book[] swap(Book[] array, int src, int dest) {
        Book temp = array[src];
        array[src] = array[dest];
        array[dest] = temp;
        return array;
    }

    public static void filteredPrint(Book[] array, String title) {
        for (int index = 0; index < array.length; index++) {
            if (array[index].getTitle().equals(title)) {
                System.out.println("Title : " + array[index].getTitle() + System.lineSeparator()
                                 + "Pages : " + array[index].getPageCount() + System.lineSeparator());
            }
        }
    }

}
