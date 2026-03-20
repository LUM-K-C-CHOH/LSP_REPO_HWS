package org.howard.edu.lsp.midterm.strategy;

/**
 * 20% discount for VIP customers.
 */
public class VIPCustomer implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.80;
    }
}