package ru.netology.domain;

import org.junit.jupiter.api.Test;

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

    @Test
    public void shouldAddAll() {
        manager.add(one);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(nokia);
        manager.add(samsung);
        manager.add(philips);
        manager.add(lg);
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{lg, philips, samsung, nokia, fourth, third, second, one};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldAddOne() {
        manager.add(samsung);
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{samsung};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldAddNothing() {
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldAddAllHowMuch() {
        manager.add(one);
        manager.add(lg);
        manager.add(third);
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{third, lg, one};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneProductByName() {
        String textToSearch = "third";
        manager.add(third);
        manager.add(lg);
        manager.searchBy(textToSearch);
        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy(textToSearch);
        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldSaveOneProduct() {
        String addSmartphone = "lg";
        manager.add(lg);
        Product[] expected = new Product[]{lg};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveAll() {
        manager.add(one);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(nokia);
        manager.add(samsung);
        manager.add(philips);
        manager.add(lg);
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{lg, philips, samsung, nokia, fourth, third, second, one};
        assertArrayEquals(expected, actual);


    }
}