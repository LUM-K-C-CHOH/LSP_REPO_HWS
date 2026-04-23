package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract base class that defines the Template Method workflow for reports.
 */
public abstract class Report {

    /**
     * Template Method that defines the fixed report generation workflow.
     */
    public final void generateReport() {
        loadData();

        System.out.println("=== HEADER ===");
        formatHeader();

        System.out.println("\n=== BODY ===");
        formatBody();

        System.out.println("\n=== FOOTER ===");
        formatFooter();

        System.out.println();
    }

    /**
     * Loads the report-specific data.
     */
    protected abstract void loadData();

    /**
     * Formats and prints the report-specific header.
     */
    protected abstract void formatHeader();

    /**
     * Formats and prints the report-specific body.
     */
    protected abstract void formatBody();

    /**
     * Formats and prints the report-specific footer.
     */
    protected abstract void formatFooter();
}
