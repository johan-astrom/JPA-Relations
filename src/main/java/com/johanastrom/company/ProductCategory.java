package com.johanastrom.company;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "everyloop.company.categories")
public class ProductCategory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "productCategory")
    private List<Product> productList;

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

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
