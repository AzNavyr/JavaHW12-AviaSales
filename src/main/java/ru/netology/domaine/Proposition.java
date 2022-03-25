package ru.netology.domaine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Proposition implements Comparable<Proposition>{
    private int id;
    private int price;
    private String from;
    private String to;
    private int flyTime;

    @Override
    public int compareTo(Proposition o) {
        return this.price - o.price;
    }
}

