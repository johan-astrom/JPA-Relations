package com.johanastrom.main;

import com.johanastrom.company.Product;
import com.johanastrom.company.ProductCategory;
import com.johanastrom.company.Supplier;
import com.johanastrom.integration.ProductDAOImpl;
import com.johanastrom.integration.UserDAOImpl;
import com.johanastrom.users.User;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {

        //Product Code

        ProductDAOImpl productDAO = new ProductDAOImpl();

        Product p = productDAO.get(1);
        Supplier s = p.getSupplier();
        ProductCategory pc = p.getProductCategory();


        productDAO.add( new Product(100, "JohansProdukt", s, pc, "sdf", 0.345f));

        System.out.println(productDAO.get(100));

        System.out.println(productDAO.getSupplier(100));

        System.out.println("Old price : " + productDAO.get(100).getUnitPrice());
        float newPrice = productDAO.incrementUnitPrice(200, 13.00F);
        System.out.println("New price : " +newPrice);

        for (Product product : productDAO.getByCategory(2)){
            System.out.println(product);
        }

        for (Object product : productDAO.getAll()){
            System.out.println(product);
        }

        boolean deleted = productDAO.delete(100);
        System.out.println("Product deleted was " + deleted);

        //User code

        UserDAOImpl userDAO = new UserDAOImpl();

        boolean persist = userDAO.create(new User("890607-1234", "johast", "myPwd123", "Johan", "Åström", "johan@johansmail.com", "098765432"));
        System.out.println(persist);

        User u = userDAO.getOne("890607-1234");
        System.out.println(u);

        List<User> userList = userDAO.get("firstName", "an");
        for (User user : userList){
            System.out.println(user);
        }

        userList = userDAO.getAll();
        for (User user : userList){
            System.out.println(user);
        }

        String valueBeforeUpdate = userDAO.update("890607-1234", "firstName", "JohansNyaNamn");
        System.out.println("Value before update: " + valueBeforeUpdate);
        System.out.println("Values after update: " + userDAO.getOne("890607-1234"));

        deleted = (userDAO.delete("890607-1234"));
        System.out.println(deleted);


    }
}
