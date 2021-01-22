package com.johanastrom.integration;

import com.johanastrom.company.Product;
import com.johanastrom.company.ProductCategory;
import com.johanastrom.company.Supplier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-relations");
    EntityManager em;

    @Override
    public void add(Product p) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    @Override
    public float incrementUnitPrice(int id, float incrementValue) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        float newPrice = product.getUnitPrice() + incrementValue;
        if (newPrice<0){
            return -1;
        }
        product.setUnitPrice(newPrice);
        em.getTransaction().commit();

        return newPrice;
    }

    @Override
    public List<Product> getAll() {
        em = emf.createEntityManager();
        List<Product> productList= em.createQuery("select Product from Product")
                .getResultList();
        return productList;
    }

    @Override
    public Supplier getSupplier(int id) {
        em = emf.createEntityManager();
        Product p = em.find(Product.class, id);

        return p.getSupplier();
    }

    @Override
    public List<Product> getByCategory(ProductCategory pc) {
        em = emf.createEntityManager();
        List<Product> productsInCategory =
                em.createQuery("select p from Product p where p.productCategory = :prodCategory")
                .setParameter("prodCategory", pc)
                .getResultList();
        return productsInCategory;
    }
}
