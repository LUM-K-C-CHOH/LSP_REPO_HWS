package org.howard.edu.lsp.assignment3;

import java.io.File;
import java.util.List;

/**
 * Entry point for Assignment 3 ETL Pipeline.
 * Coordinates extraction, transformation, and loading.
 */
public class ETLPipeline {

    public static void main(String[] args) {

        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        File inputFile = new File(inputPath);

        if (!inputFile.exists()) {
            System.out.println("ERROR: Input file not found at " + inputPath);
            return;
        }

        ProductExtractor extractor = new ProductExtractor();
        ProductTransformer transformer = new ProductTransformer();
        ProductLoader loader = new ProductLoader();

        List<Product> products = extractor.extract(inputPath);

        transformer.transform(products);

        loader.load(products, outputPath);

        System.out.println("Rows read: " + extractor.getRowsRead());
        System.out.println("Rows transformed: " + products.size());
        System.out.println("Rows skipped: " + extractor.getRowsSkipped());
        System.out.println("Output written to: " + outputPath);
    }
}