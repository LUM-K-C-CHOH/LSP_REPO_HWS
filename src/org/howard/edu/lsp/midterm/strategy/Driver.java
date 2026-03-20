package org.howard.edu.lsp.midterm.strategy;

/**
 * Driver to test Strategy Pattern implementation.
 */
public class Driver {
    public static void main(String[] args) {

        PriceCalculator calculator = new PriceCalculator();

        calculator.setStrategy(new RegularCustomer());
        System.out.println("REGULAR: " + calculator.calculatePrice(100.0));

        calculator.setStrategy(new MemberCustomer());
        System.out.println("MEMBER: " + calculator.calculatePrice(100.0));

        calculator.setStrategy(new VIPCustomer());
        System.out.println("VIP: " + calculator.calculatePrice(100.0));

        calculator.setStrategy(new HolidayCustomer());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(100.0));
    }
}