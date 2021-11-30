package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductManager manager = new ProductManager();

    private Book one = new Book(1, "one1", 321, "Petrov");
    private Book second = new Book(2, "second1", 654, "Ivanov");
    private Book third = new Book(3, "third1", 987, "Sergeev");
    private Book fourth = new Book(4, "fourth1", 458, "Olegov");
    private Smartphone nokia = new Smartphone(1, "nokia1", 1000, "nokia");
    private Smartphone samsung = new Smartphone(2, "samsung1", 2000, "samsung");
    private Smartphone philips = new Smartphone(3, "philips1", 3000, "philips");
    private Smartphone lg = new Smartphone(4, "lg1", 4000, "lg");
    private Book fifth = new Book(5, "fifth1", 578, "Sergeev");


    @Test
    public void shouldSearchOneProductByNameBook() {
        String textToSearch = "third";
        manager.add(third);
        manager.add(lg);
        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy(textToSearch);
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchOneProductByNameSmartphone() {
        String textToSearch = "nokia";
        manager.add(third);
        manager.add(lg);
        manager.add(nokia);
        Product[] expected = new Product[]{nokia};
        Product[] actual = manager.searchBy(textToSearch);
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchOneProductByAuthorBook() {
        String textToSearch = "Ivanov";
        manager.add(second);
        manager.add(lg);
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy(textToSearch);
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchOneProductByManufacturerSmartphone() {
        String textToSearch = "philips";
        manager.add(second);
        manager.add(philips);
        Product[] expected = new Product[]{philips};
        Product[] actual = manager.searchBy(textToSearch);
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchNothingNameBook() {
        String textToSearch = "one";
        manager.add(third);
        manager.add(lg);
        manager.add(nokia);
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy(textToSearch);
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchNothingNameSmartphone() {
        String textToSearch = "nokia";
        manager.add(third);
        manager.add(lg);
        manager.add(philips);
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy(textToSearch);
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchProductByAuthor() {
        String author = "Sergeev";
        manager.add(third);
        manager.add(one);
        manager.add(fifth);
        Product[] expected = new Product[]{third, fifth};
        Product[] actual = manager.searchBy(author);
        assertArrayEquals(expected, actual);

    }


}