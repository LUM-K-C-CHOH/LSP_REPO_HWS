package org.howard.edu.lsp.midterm.strategy;

/**
 * 15% holiday discount.
 */
public class HolidayCustomer implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.85;
    }
}