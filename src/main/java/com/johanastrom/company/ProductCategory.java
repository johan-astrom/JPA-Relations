package com.johanastrom.company;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "default.company.categories")
public class ProductCategory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "productCategory")
    private Set<Product> productList;

    private String categoryName;
    private String description;

    public void addProduct(Product p){
        this.productList.add(p);
        p.setProductCategory(this);
    }

    public int getId() {
        return id;
    }

    public Set<Product> getProductList() {
        return productList;
    }

    public void setProductList(Set<Product> productList) {
        this.productList = productList;
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
