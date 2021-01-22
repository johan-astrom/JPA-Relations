package com.johanastrom.integration;

import com.johanastrom.company.Product;
import com.johanastrom.company.ProductCategory;
import com.johanastrom.company.Supplier;

import java.util.List;

public interface ProductDAO {

    /**
     * Persists the specified product.
     * @param p
     */
    void add(Product p);

    /**
     * Changes the unitPrice field by the specified value. Returns the new price.
     * @param id
     *        Id of the Product object to update.
     * @param value
     *        The value to add to or deduct from the existing price.
     * @return The new price total.
     */
    float incrementUnitPrice(int id, float value);

    /**
     * Retrieves all Product objects stored in the database.
     * @return A List of all persisted Product objects.
     */
    List<Product> getAll();

    /**
     * Returns the Supplier object for the specified product.
     * @param id
     *        The id of the product to query for the associated supplier.
     * @return The associated Supplier object.
     */
    Supplier getSupplier(int id);

    /**
     * Retrieves a list with all the Product objects in a specific ProductCategory.
     * @param pc
     *        The ProductCategory to query.
     * @return A List<Product> of all Product objects in the ProductCategory.
     */
    List<Product> getByCategory(ProductCategory pc);

}
