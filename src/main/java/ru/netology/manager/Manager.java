package ru.netology.manager;

import ru.netology.domaine.Proposition;
import ru.netology.repository.Repository;

import java.awt.print.Book;

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

    public boolean matches(Proposition product, String search) {
        if (product instanceof Proposition) { // если в параметре product лежит объект класса Book
            Proposition proposition = (Proposition) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (proposition.getFrom().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            if (proposition.getTo().contains(search)) {
                return true;
            }
        }
        return false;
    }

    public Proposition[] searchBy(String text) {
        Proposition[] searchResult = new Proposition[0];
        for (Proposition product : repo.findAll()) {
            if (matches(product, text)) {
                Proposition[] tmp = new Proposition[searchResult.length + 1];
                tmp[tmp.length - 1] = product;
                searchResult = tmp;
            }
        }
        return searchResult;
    }
}
