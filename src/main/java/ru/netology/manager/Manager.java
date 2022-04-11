package ru.netology.manager;

import ru.netology.domaine.Proposition;
import ru.netology.repository.Repository;

import java.awt.print.Book;
import java.util.Arrays;

public class Manager {
    private Repository repo = new Repository();

    public Manager() {
    }

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public void add(Proposition product) {
        repo.save(product);
    }

    public boolean matches(Proposition product, String searchFrom, String searchTo) {
        if (product instanceof Proposition) { //Не совсем понимаю зачем тут Book или Smartphone, или T-Shirts, это задача с билетами по теме Generics
            Proposition proposition = (Proposition) product; 
            if (proposition.getFrom().contains(searchFrom) && proposition.getTo().contains(searchTo)) { 
                return true;
            }
        }
        return false;
    }

    public Proposition[] searchBy(String from, String to) {
        Proposition[] searchResult = new Proposition[0];
        for (Proposition product : repo.findAll()) {
            if (matches(product, from, to)) {
                Proposition[] tmp = new Proposition[searchResult.length + 1];
                System.arraycopy(searchResult, 0, tmp, 0, searchResult.length);
                tmp[tmp.length - 1] = product;
                searchResult = tmp;
                Arrays.sort(searchResult);
            }
        }
        return searchResult;
    }
}
