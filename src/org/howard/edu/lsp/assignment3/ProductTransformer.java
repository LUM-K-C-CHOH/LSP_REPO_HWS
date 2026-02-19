package org.howard.edu.lsp.assignment3;

import java.util.List;

/**
 * Applies transformation logic to product list.
 */
public class ProductTransformer {

    /**
     * Applies transformations to each product.
     */
    public void transform(List<Product> products) {
        for (Product product : products) {
            product.applyTransformations();
        }
    }
}