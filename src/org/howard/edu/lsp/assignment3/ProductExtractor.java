package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for extracting product data from CSV.
 */
public class ProductExtractor {

    private int rowsRead = 0;
    private int rowsSkipped = 0;

    /**
     * Extracts products from input CSV.
     */
    public List<Product> extract(String inputPath) {

        List<Product> products = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {

            String line = reader.readLine(); // header
            if (line == null) {
                return products;
            }

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    rowsRead++;
                    rowsSkipped++;
                    continue;
                }

                rowsRead++;

                String[] fields = line.split(",");
                if (fields.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                try {
                    int id = Integer.parseInt(fields[0].trim());
                    String name = fields[1].trim();
                    BigDecimal price = new BigDecimal(fields[2].trim());
                    String category = fields[3].trim();

                    products.add(new Product(id, name, price, category));

                } catch (NumberFormatException |  ArrayIndexOutOfBoundsException e) {
                    rowsSkipped++;
                }
            }

        } catch (IOException e) {
            System.out.println("ERROR: Unable to process files.");
        }

        return products;
    }

    public int getRowsRead() { return rowsRead; }
    public int getRowsSkipped() { return rowsSkipped; }
}