package ru.netology.repository;

import ru.netology.domaine.Proposition;

public class Repository {
    private Proposition[] items = new Proposition[0];

    public void save(Proposition item) {
        int length = items.length + 1;
        Proposition[] tmp = new Proposition[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Proposition[] findAll() {
        return items;
    }

    public Proposition findById(int id) {
        for (Proposition item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Proposition[] removeById(int id) {
        int length = items.length - 1;
        Proposition[] tmp = new Proposition[length];
        int index = 0;
        for (Proposition item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return tmp;
    }
}
