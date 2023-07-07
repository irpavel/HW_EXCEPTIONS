package ru.netology.java.qa59;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "телефон", 3_000);
        Product product2 = new Product(22, "книга", 300);
        Product product3 = new Product(33, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(22);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "телефон", 3_000);
        Product product2 = new Product(22, "книга", 300);
        Product product3 = new Product(33, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(44)
                );
    }

    @Test
    public void testAddWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "телефон", 3_000);
        Product product2 = new Product(22, "книга", 300);
        Product product3 = new Product(33, "машина", 3_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddWhenProductAlreadyExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "телефон", 3_000);
        Product product2 = new Product(22, "книга", 300);
        Product product3 = new Product(33, "машина", 3_000_000);
        Product product4 = new Product(33, "автомобиль", 4_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(AlreadyExistsException.class,
                () -> repo.add(product4)
        );
    }

}