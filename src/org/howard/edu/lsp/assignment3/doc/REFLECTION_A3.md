# Assignment 3 Reflection – Object-Oriented Redesign

## Comparison Between Assignment 2 and Assignment 3

In Assignment 2, the ETL pipeline was implemented in a single class. All responsibilities—file reading, parsing, transformation logic, writing output, and printing summary—were handled within one procedural structure. Although the solution worked correctly, it mixed responsibilities and did not fully apply object-oriented principles.

In Assignment 3, I redesigned the program using object-oriented decomposition. The responsibilities were separated into multiple classes: ETLPipeline (orchestration), Product (domain model), ProductExtractor (extraction), ProductTransformer (transformation), and ProductLoader (loading). This redesign improves readability, maintainability, and separation of concerns.

## Object-Oriented Concepts Used

### Object and Class
Each product row is now represented as a Product object. The system is composed of multiple classes, each with a single responsibility.

### Encapsulation
The Product class encapsulates product data using private fields and public getter methods. Business logic such as transformation rules and price range determination is contained within the Product class.

### Separation of Concerns
Each class has one responsibility:
- Extractor reads and parses.
- Transformer applies business rules.
- Loader writes output.
- ETLPipeline coordinates workflow.

### Polymorphism and Extensibility
The design makes it easier to introduce new transformation rules or alternative loaders in the future without modifying unrelated classes.

## Testing Strategy

To verify correctness, I tested:
- The robust sample input from Assignment 2.
- Case B (header-only file).
- Case C (missing input file).

I compared the output of Assignment 3 to Assignment 2 to ensure the transformed CSV files were identical. The behavior and outputs match exactly.

## Conclusion

Assignment 3 improves the structural design while preserving functional correctness. The object-oriented decomposition makes the system more modular, maintainable, and extensible.