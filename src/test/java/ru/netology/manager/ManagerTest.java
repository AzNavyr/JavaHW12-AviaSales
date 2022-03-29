package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.netology.domaine.Proposition;
import ru.netology.repository.Repository;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Repository repo = new Repository();
    Manager manager = new Manager(repo);


    Proposition number1 = new Proposition(1, 100, "AAA", "AAB", 125);
    Proposition number2 = new Proposition(2, 50, "AAA", "BAK", 130);
    Proposition number3 = new Proposition(3, 250, "BAK", "CCH", 155);
    Proposition number4 = new Proposition(4, 510, "DAL", "AAB", 221);
    Proposition number5 = new Proposition(5, 100, "BAK", "FCO", 130);

    @BeforeEach
    public void setUp() {
        manager.add(number1);
        manager.add(number2);
        manager.add(number3);
        manager.add(number4);
        manager.add(number5);
    }

    @Test
    void shouldArraysSort() {
        Proposition[] expected = new Proposition[]{number2, number1, number3};
        Proposition[] actual = new Proposition[]{number1, number2, number3};

        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTheSameIATA() {
        Proposition[] expected = new Proposition[]{number3};
        Proposition[] actual = manager.searchBy("BAK", "CCH");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindNull() {
        Proposition[] excepted = new Proposition[]{};
        Proposition[] actual = manager.searchBy("AAA", "FCO");

        assertArrayEquals(excepted, actual);
    }

    @Test
    void shouldRemoveById() {
        Proposition[] expected = new Proposition[]{number2, number3, number4, number5};
        Proposition[] actual = repo.removeById(1);

        assertArrayEquals(expected, actual);
    }
}