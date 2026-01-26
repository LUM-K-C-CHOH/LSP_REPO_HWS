
package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

    /**
     * Name: Lum Kelly Chelsie Choh
     **/

    public static void main(String[] args) {
        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        int rowsRead = 0;
        int rowsWritten = 0;
        int rowsSkipped = 0;

        File inputFile = new File(inputPath);

        if (!inputFile.exists()) {
            System.out.println("ERROR: Input file not found at " + inputPath);
            return;
        }

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                PrintWriter writer = new PrintWriter(new FileWriter(outputPath))
        ) {
            // Always write header
            writer.println("ProductID,Name,Price,Category,PriceRange");

            String line = reader.readLine(); // header
            if (line == null) {
                printSummary(rowsRead, rowsWritten, rowsSkipped, outputPath);
                return;
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
                    int productId = Integer.parseInt(fields[0].trim());
                    String name = fields[1].trim().toUpperCase();
                    BigDecimal price = new BigDecimal(fields[2].trim());
                    String category = fields[3].trim();

                    boolean originalElectronics = category.equals("Electronics");

                    // 10% discount
                    if (originalElectronics) {
                        price = price.multiply(new BigDecimal("0.90"));
                    }

                    // round HALF_UP to 2 decimals
                    price = price.setScale(2, RoundingMode.HALF_UP);

                    // Premium Electronics rule
                    if (originalElectronics && price.compareTo(new BigDecimal("500.00")) > 0) {
                        category = "Premium Electronics";
                    }

                    // Price range
                    String priceRange;
                    if (price.compareTo(new BigDecimal("10.00")) <= 0) {
                        priceRange = "Low";
                    } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
                        priceRange = "Medium";
                    } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
                        priceRange = "High";
                    } else {
                        priceRange = "Premium";
                    }

                    writer.printf(
                            "%d,%s,%.2f,%s,%s%n",
                            productId,
                            name,
                            price,
                            category,
                            priceRange
                    );

                    rowsWritten++;

                } catch (Exception e) {
                    rowsSkipped++;
                }
            }

            printSummary(rowsRead, rowsWritten, rowsSkipped, outputPath);

        } catch (IOException e) {
            System.out.println("ERROR: Unable to process files.");
        }
    }

    private static void printSummary(int read, int written, int skipped, String outputPath) {
        System.out.println("Rows read: " + read);
        System.out.println("Rows transformed: " + written);
        System.out.println("Rows skipped: " + skipped);
        System.out.println("Output written to: " + outputPath);
    }
}