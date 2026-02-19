package org.howard.edu.lsp.assignment3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Writes transformed products to CSV output file.
 */
public class ProductLoader {

    /**
     * Writes products to output CSV file.
     */
    public void load(List<Product> products, String outputPath) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {

            writer.println("ProductID,Name,Price,Category,PriceRange");

            for (Product product : products) {
                writer.printf("%d,%s,%s,%s,%s%n",
                        product.getProductId(),
                        product.getName(),
                        product.getPrice().toPlainString(),
                        product.getCategory(),
                        product.getPriceRange());
            }

        } catch (IOException e) {
            System.out.println("ERROR: Unable to write output file.");
        }
    }
}