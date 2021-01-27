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

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-relations");
    private EntityManager em;

    @Override
    public void add(Product p) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        //p.setProductCategory(em.find(ProductCategory.class, 1));
        //p.setSupplier(em.find(Supplier.class, 1));
        em.persist(p);
        em.getTransaction().commit();
    }

    @Override
    public boolean delete(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Product p = em.find(Product.class, id);
        if (p==null){
            return false;
        }
        em.remove(p);
        em.getTransaction().commit();

        return em.find(Product.class, p.getId())==null;
    }

    @Override
    public float incrementUnitPrice(int id, float value) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        if (product==null){
            System.out.println("Product not found.");
            return -1;
        }
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
    public Product get(int id) {
        em = emf.createEntityManager();
        Product p = em.find(Product.class, id);
        return p;
    }

    @Override
    public List<Product> getAll() {
        em = emf.createEntityManager();
        List<Product> productList= em.createQuery("select p.id, p.productName from Product p")
                .getResultList();
        return productList;
    }

    @Override
    public Supplier getSupplier(int productId) {
        em = emf.createEntityManager();
        Product p = em.find(Product.class, productId);
        System.out.println("Supplier is: " + p.getSupplier().getCompanyName());
        return p.getSupplier();
    }

    @Override
    public List<Product> getByCategory(int id) {
        em = emf.createEntityManager();
        ProductCategory pc = em.find(ProductCategory.class, id);
        List<Product> productsInCategory =
                em.createQuery("select p from Product p where p.productCategory.categoryName = :prodCategory")
                .setParameter("prodCategory", pc.getCategoryName())
                .getResultList();
        return productsInCategory;
    }
}
