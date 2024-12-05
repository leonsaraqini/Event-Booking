package mk.ukim.finki.mk.lab.model;

import lombok.Data;

@Data
public class Category {
    private Long id;
    private String name;

    public Category(String name) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
    }
}
