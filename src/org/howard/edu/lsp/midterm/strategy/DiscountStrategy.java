package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy interface for discount calculation.
 * @author Lum Choh
 */
public interface DiscountStrategy {
    /**
     * Applies discount to the given price.
     * @param price original price
     * @return discounted price
     */
    double applyDiscount(double price);
}