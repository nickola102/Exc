package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.exception.NotFoundException;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();

    Product first = new Book(1354, "1984", 300, "George Orwell");
    Product second = new Book(2687, "20,000 Leagues Under the Sea", 800, "Jules Verne");
    Product third = new Smartphone(3235, "6S Plus", 25000, "Apple");
    Product forth = new Book(435, "Harry Potter", 600, "J. K. Rowling");
    Product fifth = new Smartphone(568, "Blade", 15000, "ZTE");
    Product sixth = new Smartphone(6254, "Galaxy A19", 18000, "Samsung");

    @Test
    void shouldFindAll() {

        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product[] expected = {first, second, third};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(forth);
        repository.save(fifth);
        repository.save(sixth);

        repository.removeById(3235);

        Product[] expected = {first, second, forth, fifth, sixth};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByNotFoundId() {

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(forth);
        repository.save(fifth);
        repository.save(sixth);

        assertThrows(NotFoundException.class, () -> repository.removeById(35));

    }
}