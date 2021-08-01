package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int counter = index; counter < products.length - 1; counter++) {
            if (products[counter] == null) {
                swap(products, counter);
            }
        }
        return products;
    }

    public static Product[] swap(Product[] products, int index) {
        Product temp = products[index];
        products[index] = products[index + 1];
        products[index + 1] = temp;
        return products;
    }
}