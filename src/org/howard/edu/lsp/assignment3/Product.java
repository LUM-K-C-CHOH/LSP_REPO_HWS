package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents a product record in the ETL pipeline.
 */
public class Product {

    private final int productId;
    private String name;
    private BigDecimal price;
    private String category;
    private String priceRange;

    /**
     * Constructs a Product object.
     */
    public Product(int productId, String name, BigDecimal price, String category) {
        this.productId = productId;
        this.name = name.trim();
        this.price = price;
        this.category = category.trim();
    }

    /**
     * Applies required business transformations.
     */
    public void applyTransformations() {
        name = name.toUpperCase();

        boolean originalElectronics = category.equals("Electronics");

        if (originalElectronics) {
            price = price.multiply(new BigDecimal("0.90"));
        }

        price = price.setScale(2, RoundingMode.HALF_UP);

        if (originalElectronics && price.compareTo(new BigDecimal("500.00")) > 0) {
            category = "Premium Electronics";
        }

        determinePriceRange();
    }

    /**
     * Determines the price range based on final rounded price.
     */
    private void determinePriceRange() {
        if (price.compareTo(new BigDecimal("10.00")) <= 0) {
            priceRange = "Low";
        } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
            priceRange = "Medium";
        } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
            priceRange = "High";
        } else {
            priceRange = "Premium";
        }
    }

    public int getProductId() { return productId; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
    public String getCategory() { return category; }
    public String getPriceRange() { return priceRange; }
}