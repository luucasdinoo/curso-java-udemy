package application;

import entities.Product;

import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {

        Map<Product , Double> stock = new HashMap<>();

        Product p1 = new Product("TV", 900.0);
        Product p2 = new Product("Notebook", 1200.0);
        Product p3 = new Product("Tablet", 400.0);

        stock.put(p1, 10000.0);
        stock.put(p2, 20000.0);
        stock.put(p3, 15000.0);

        Product ps = new Product("TV", 900.0);

        System.out.println("Contém chave 'ps' : " + stock.containsKey(ps));
    }
}
