# E-Commerce System Internship Task

## Project Overview
This project is a simple e-commerce system designed as part of an internship challenge. The system allows to define products (including expiring and shippable products), and enables customers to add products to a cart and perform checkout. The checkout process handles shipping, expiration, stock validation, and prints detailed receipts and shipment notices as required by the task.

   
## Project Structure
- `model/` — Contains all core data classes.
- `service/` — Contains service classes for business logic.
- `Main.java` — Entry point that demonstrates the main features and error cases.

## Design Decisions
- **Composition in Product:** I thought a lot about this case, I was stuck in how to handle the expiration and shippable products .
    - First i think about just use simple boolean flags but it was simple and not practical case , then think about inheretince but i think if we scaled the programm we will have -Class Explotion- so instead of using inheritance, I used composition for shipping and expiration features. Products that need shipping or expiration have `ShippingInfo` or `ExpirationInfo` objects; otherwise, these fields are null. This keeps the design flexible and avoids unnecessary fields for products that do not need them.

- **Static Service Methods:** Service methods are static because they are stateless and utilities ( which is a common pattern for this kind of business logic in Java).

## Example Usage
The `Main.java` file demonstrates:
- Creating various products (shippable, expiring, non-shippable, non-expiring)
- Creating customers and carts
- Adding products to the cart
- Performing successful and unsuccessful checkouts, showing all error cases and required outputs

## Acknowledgment
This project was completed as part of an internship application. Throughout the process, I focused on writing clean, maintainable code and making thoughtful design decisions. I tried to implement object-oriented design very well, validation, and thhink about corner cases and handle it with proper error handling. 
I am grateful for the opportunity to work on this challenge and for the feedback that will help me grow as a fresh-grad developer. 