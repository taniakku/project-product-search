package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;
import domain.Book;
import domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private ProductRepository repository = new ProductRepository();
    Manager manager = new Manager(repository);
    Product first = new Book(1, "Harry Potter and the Chamber of Secrets", 500, "J. K. Rowling");
    Product second = new Book(2, "Silmarillion", 600, "J. R. Tolkien");
    Product third = new Smartphone(31, "Super Mega Zoom 2000", 900, "Noname");
    Product fourth = new Smartphone(32, "The Best Pokemon Catcher", 950, "Noname");
    Product fifth = new Smartphone (33, "Brick", 300, "Klokia");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
    }

    @Test
    void shouldSearchBookByName() {

        Product[] expected = {first};
        Product[] actual = manager.searchBy("Harry Potter");

        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldSearchBookByAuthor() {

        Product[] expected = {second};
        Product[] actual = manager.searchBy("Tolkien");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByName() {

        Product[] expected = {fourth};
        Product[] actual = manager.searchBy("Pokemon");

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchSmartphoneByOtherName() {

        Product[] expected = {third};
        Product[] actual = manager.searchBy("Mega Zoom");

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchSmartphoneByBrand() {

        Product[] expected = {third, fourth};
        Product[] actual = manager.searchBy("Noname");

        assertArrayEquals(expected, actual);

    }



    @Test
    void shouldSearchSmartphoneByOtherBrand() {

        Product[] expected = {fifth};
        Product[] actual = manager.searchBy("Klokia");

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchSmartphoneByOtherOtherName() {

        Product[] expected = {fifth};
        Product[] actual = manager.searchBy("Brick");

        assertArrayEquals(expected, actual);

    }

}