package com.johanastrom.company;

import javax.persistence.*;

@Entity
@Table(name="everyloop.company.products")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productName;

    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private ProductCategory productCategory;

    private String quantityPerUnit;
    private float unitPrice;

    public Product() {
    }

    public Product(int id, String productName, Supplier supplier, ProductCategory productCategory, String quantityPerUnit, float unitPrice) {
        this.id = id;
        this.productName = productName;
        this.supplier = supplier;
        this.productCategory = productCategory;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }



    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", supplier=" + supplier.getCompanyName() +
                ", productCategory=" + productCategory.getCategoryName() +
                ", quantityPerUnit='" + quantityPerUnit + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
