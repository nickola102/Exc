package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager product = new ProductManager(repository);

    Product first = new Book(1354, "1984", 300, "George Orwell");
    Product second = new Book(2687, "20,000 Leagues Under the Sea", 800, "Jules Verne");
    Product third = new Smartphone(3235, "6S Plus", 25000, "Apple");
    Product forth = new Book(435, "Harry Potter", 600, "J. K. Rowling");
    Product fifth = new Smartphone(568, "Blade", 15000, "ZTE");
    Product sixth = new Smartphone(6254, "Galaxy A19", 18000, "Samsung");

    @Test
    public void shouldAddProducts() {

        product.add(first);
        product.add(second);
        product.add(third);
        product.add(forth);
        product.add(fifth);
        product.add(sixth);

        Product[] expected = {first, second, third, forth, fifth, sixth};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddBooks() {

        product.add(first);
        product.add(second);
        product.add(forth);

        Product[] expected = {first, second, forth};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddSmartphones() {

        product.add(third);
        product.add(fifth);
        product.add(sixth);

        Product[] expected = {third, fifth, sixth};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBy() {

        product.add(first);
        product.add(second);
        product.add(third);
        product.add(forth);
        product.add(fifth);
        product.add(sixth);

        Product[] expected = {first, sixth};
        Product[] actual = product.searchBy("19");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchNoOne() {

        product.add(first);
        product.add(second);
        product.add(third);
        product.add(forth);
        product.add(fifth);
        product.add(sixth);

        Product[] expected = {};
        Product[] actual = product.searchBy("super");

        assertArrayEquals(expected, actual);
    }
}