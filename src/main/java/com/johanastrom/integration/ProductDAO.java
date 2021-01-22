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
     * Increments the unitPrice field by the specified value. Returns the new price.
     * @param incrementValue
     *        The value to add to the existing price.
     * @return The new price total.
     */
    float incrementUnitPrice(float incrementValue);

    /**
     * Returns the Supplier object for the specified product.
     * @param p
     *        The product to query for the associated supplier.
     * @return The associated Supplier object.
     */
    Supplier getSupplier(Product p);

    /**
     * Retrieves a list with all the Product objects in a specific ProductCategory.
     * @param pc
     *        The ProductCategory to query.
     * @return A List<Product> of all Product objects in the ProductCategory.
     */
    List<Product> getByCategory(ProductCategory pc);

}
