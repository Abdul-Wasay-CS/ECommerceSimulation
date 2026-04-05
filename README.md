# PakMart — E-Commerce Store Simulation

## Project Overview

PakMart is a command-line e-commerce store simulation built in Java that demonstrates core Object-Oriented Programming principles. The system supports dual user roles (Admin and Customer) with distinct functionality, enabling administrators to manage product inventory and customers to browse, select, and purchase items.

---

## Key Features

- **User Authentication**: Secure login and sign-up functionality for both Admin and Customer roles
- **Product Catalog Management**: View all available products with detailed information
- **Dynamic Inventory System**: Real-time stock tracking and updates
- **Shopping Cart Operations**: Add, remove, and manage items in cart
- **Order Management**: View order history and process checkouts
- **Admin Controls**: Add, remove, and edit products in the inventory
- **Customer Management**: Admin access to view all registered customers
- **Specialized Product Types**: Support for clothing items with extended attributes (size, brand, material, color)

---

## OOP Implementation

### Encapsulation

Encapsulation is implemented through private fields and controlled access via getter/setter methods:

- **Product Class**: Private fields `productId`, `name`, `price`, and `stock` encapsulate product data. Methods like `updatePrice()`, `reduceStock()`, and `addStock()` provide controlled access and enforce business logic (e.g., price must be positive, stock cannot exceed available quantity).
- **Address Class**: Private fields for address components (`country`, `city`, `society`, `streetNo`, `houseNo`) with public getters/setters ensure data integrity during user registration and profile management.
- **User Class**: Protected fields (`fullName`, `userName`, `password`, `address`, `ssn`) restrict direct access to sensitive user information; subclasses inherit controlled access mechanisms.

### Inheritance

Inheritance establishes a hierarchical structure for code reuse and specialized behavior:

- **User Base Class**: Abstract class defining common user attributes and abstract methods (`login()`, `menu()`). All user types inherit core properties like name, username, password, and address.
- **Admin Subclass**: Extends User with admin-specific properties (`adminId`, `post`, `salary`) and implements admin-only menu operations (add product, remove product, manage inventory).
- **Customer Subclass**: Extends User with customer-specific properties (`phoneNumber`, `history`) and implements customer-specific menu operations (view products, cart management, checkout).
- **Clothes Subclass**: Extends Product to represent specialized clothing items with additional attributes (`size`, `brand`, `stuff`, `color`), demonstrating inheritance for domain-specific product types.

### Polymorphism

Polymorphism enables different user types and product types to execute operations through a common interface:

- **Method Overriding**: Both `Admin` and `Customer` override abstract methods `login()` and `menu()` from the User base class, implementing role-specific authentication and menu workflows.
- **Display Polymorphism**: The `display()` method is overridden in the `Clothes` class to provide formatted output specific to clothing attributes, while the base `Product` class defines the default behavior.
- **Processing Variations**: Different user types process authentication and menu operations differently despite being called through the same interface, allowing the system to treat Admin and Customer objects uniformly during runtime.

### Abstraction

Abstraction simplifies complex operations and hides implementation details behind simple interfaces:

- **User Abstract Base Class**: Abstracts the concept of system users and defines a contract for all user types without specifying implementation details. Concrete implementations (Admin, Customer) handle role-specific logic.
- **FileManager Utility**: Encapsulates all file I/O operations (reading/writing CSV data for admins and customers) behind static methods, hiding file handling complexity from other classes.
- **Color Utility Class**: Provides an abstraction layer for terminal color codes, allowing consistent formatting throughout the application without exposing ANSI escape sequences directly.
- **SafeInputs Utility**: Abstracts user input validation, providing safe methods for retrieving integers and strings with built-in error handling.

---

## Technologies Used

- **Language**: Java 11+
- **Paradigm**: Object-Oriented Programming (OOP)
- **Data Persistence**: File-based storage (CSV format)
- **Terminal UI**: ANSI color codes for enhanced CLI presentation

---

## Setup & Usage

### Prerequisites
- Java 11 or higher installed on your system
- A terminal or command prompt

### Running the Application

1. **Navigate to the project directory**:
   ```bash
   cd ECommerceSimulation
   ```

2. **Compile the Java files**:
   ```bash
   javac -d bin src/pakMart/*.java
   ```

3. **Run the application**:
   ```bash
   java -cp bin pakMart.Main
   ```

### Menu Navigation

**Main Menu Options**:
1. **Login as Admin** — Access admin console (default: username `admin`, password `admin123`)
2. **Login as Customer** — Access customer shopping interface
3. **Sign Up as Customer** — Create a new customer account
4. **Sign Up as Admin** — Register a new administrator account

**Admin Functions**:
- Add new products to inventory
- Remove products from catalog
- Edit product details and pricing
- View all products
- View all registered customers

**Customer Functions**:
- Browse product catalog
- Add/remove items to/from shopping cart
- View current cart contents
- Review order history
- Proceed to checkout and complete purchase

---

## Project Structure

```
ECommerceSimulation/
├── src/pakMart/
│   ├── Main.java              # Application entry point
│   ├── User.java              # Abstract base class for users
│   ├── Admin.java             # Admin role implementation
│   ├── Customer.java          # Customer role implementation
│   ├── Product.java           # Product base class
│   ├── Clothes.java           # Specialized clothing product
│   ├── Address.java           # Address model
│   ├── Cart.java              # Shopping cart functionality
│   ├── FileManager.java       # File I/O operations
│   ├── SafeInputs.java        # Input validation utility
│   ├── Color.java             # Terminal color formatting
│   └── TestFiles/
├── data/                       # CSV data storage
├── README.md
└── ECommerceSimulation.iml
```

---

## Notes

- User data (admins and customers) is persisted in CSV format within the `data/` directory
- The system initializes with a default admin account for initial access
- All passwords are stored in plain text; implement encryption for production use
- Cart operations are session-based (non-persistent across application restarts)
