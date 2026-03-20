package org.howard.edu.lsp.midterm.strategy;

/**
 * No discount for regular customers.
 */
public class RegularCustomer implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price;
    }
}