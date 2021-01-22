package com.johanastrom.company;

import javax.persistence.*;

@Entity
@Table(name = "everyloop.company.suppliers")
public class Supplier {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String companyName;
    private String contactName;
    private String address;
    private String city;
    private String country;

    public int getId() {
        return id;
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
