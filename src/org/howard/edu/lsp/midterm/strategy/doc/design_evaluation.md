The original PriceCalculator class uses multiple if statements to determine pricing logic based on customer type. This design violates the Open/Closed Principle because adding new customer types requires modifying the existing code.

The class is tightly coupled to specific discount rules, making it difficult to extend and maintain. It also lacks flexibility and scalability.

Using the Strategy Pattern improves the design by separating each discount behavior into its own class. This allows new strategies to be added without modifying existing code, improving maintainability and extensibility.