package com.johanastrom.integration;

import com.johanastrom.company.Product;
import com.johanastrom.company.ProductCategory;
import com.johanastrom.company.Supplier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-relations");
    EntityManager em;

    @Override
    public void add(Product p) {

    }

    @Override
    public float incrementUnitPrice(float incrementValue) {
        return 0;
    }

    @Override
    public Supplier getSupplier(Product p) {
        return null;
    }

    @Override
    public List<Product> getByCategory(ProductCategory pc) {
        return null;
    }
}
