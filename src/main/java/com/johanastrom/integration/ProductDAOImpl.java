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
    public float incrementUnitPrice(int id, float value) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        float newPrice = product.getUnitPrice() + value;
        if (newPrice<0){
            em.getTransaction().commit();
            System.out.println("The entered value is too big, price was not updated.");
            return -1;
        }
        product.setUnitPrice(newPrice);
        em.getTransaction().commit();

        return newPrice;
    }

    @Override
    public List<Product> getAll() {
        em = emf.createEntityManager();
        List<Product> productList= em.createQuery("select p from Product p")
                .getResultList();
        return productList;
    }

    @Override
    public Supplier getSupplier(int id) {
        em = emf.createEntityManager();
        Product p = em.find(Product.class, id);
        System.out.println("Supplier is: " + p.getSupplier().getCompanyName());
        return p.getSupplier();
    }

    @Override
    public List<Product> getByCategory(ProductCategory pc) {
        em = emf.createEntityManager();
        List<Product> productsInCategory =
                em.createQuery("select p from Product p where p.productCategory.categoryName = :prodCategory")
                .setParameter("prodCategory", pc.getCategoryName())
                .getResultList();
        return productsInCategory;
    }
}
