package com.johanastrom.company;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "default.company.suppliers")
public class Supplier {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "supplier")
    private Set<Product> productList;

    private String companyName;
    private String contactName;
    private String address;
    private String city;
    private String country;

    public void addProduct(Product p){
        this.productList.add(p);
        p.setSupplier(this);
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

    public String getCompanyName() {
        return companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
