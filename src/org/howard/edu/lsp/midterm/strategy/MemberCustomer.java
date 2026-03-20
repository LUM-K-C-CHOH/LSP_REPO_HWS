package org.howard.edu.lsp.midterm.strategy;

/**
 * 10% discount for members.
 */
public class MemberCustomer implements DiscountStrategy {
    public double applyDiscount(double price) {
        return price * 0.90;
    }
}