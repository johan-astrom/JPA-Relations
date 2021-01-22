package com.johanastrom.company;

import javax.persistence.*;

@Entity
@Table(name = "everyloop.company.categories")
public class ProductCategory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String categoryName;
    private String description;

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
    }

}
