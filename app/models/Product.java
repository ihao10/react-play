package models;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private static List<Product> products;

    static {
        products = new ArrayList<Product>();
        products.add(new Product("123", "qwe"));
    }

    public String name;
    public String description;
    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static List<Product> findAll() {
        return new ArrayList<Product>(products);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
