package Main;

import Main.domein.Product;

public class Main {
    public static void main(String[] args) {
        Product product = new Product(1, "sen", "test", 10);
        System.out.println(product);
    }
}
