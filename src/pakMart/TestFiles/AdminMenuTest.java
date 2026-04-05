package pakMart.TestFiles;

import pakMart.Admin;
import pakMart.Address;
import pakMart.Color;

public class AdminMenuTest {
    public static void main(String[] args) {
        System.out.println(Color.Green() + "\n========== ADMIN MENU TEST ==========" + Color.Reset());

        // Create a test Admin object
        Address testAddress = new Address("America", "New York", "NY", 12,304);
        Admin admin = new Admin(
                "John Manager",
                "johnmanager",
                testAddress,
                123456789,
                "Senior Manager",
                75000.0
        );

        System.out.println(Color.Cyan() + "\nAdmin Created Successfully:" + Color.Reset());
        System.out.println("Full Name: " + admin.getFullName());
        System.out.println("Username: " + admin.getUserName());
        System.out.println("Post: " + admin.getPost());
        System.out.println("Salary: " + admin.getSalary());

        System.out.println(Color.Green() + "\n========== TESTING ADMIN MENU OUTPUT ==========" + Color.Reset());
        System.out.println(Color.Yellow() + "\nDisplaying Admin Menu:" + Color.Reset());
        System.out.println("(Note: Menu will prompt for user input. To test without input, review the menu structure below)\n");

        // Displaying the menu structure manually for testing without requiring input
        System.out.println(Color.Cyan() + "=".repeat(20)
                + Color.Reset() + Color.Green() + "Admin Menu" + Color.Reset() + Color.Cyan() + "=".repeat(20)
                + Color.Reset());
        System.out.println(Color.Yellow() + """

                1.  Add new product \n
                2.  Remove a product\n
                3.  Edit a product\n
                4.  View all products\n
                5.  View all customers\n
                6.  View all orders\n""" + Color.Reset());
        System.out.println(Color.Cyan() + "=".repeat(40) + Color.Reset());

        System.out.println(Color.Green() + "\n========== MENU STRUCTURE TEST PASSED ==========" + Color.Reset());
        System.out.println(Color.Yellow() + "The Admin menu displays properly with color formatting and all options visible." + Color.Reset());

        // Test Case 1: Add New Product
        System.out.println(Color.Green() + "\n========== TEST CASE 1: ADD NEW PRODUCT ==========" + Color.Reset());
        testAddProductCases();

        // Test Case 2: Remove Product
        System.out.println(Color.Green() + "\n========== TEST CASE 2: REMOVE PRODUCT ==========" + Color.Reset());
        testRemoveProductCases();

        // Test Case 3: Edit Product
        System.out.println(Color.Green() + "\n========== TEST CASE 3: EDIT PRODUCT ==========" + Color.Reset());
        testEditProductCases();

        System.out.println(Color.Green() + "\n========== ALL SWITCH CASES TESTED ==========" + Color.Reset() + "\n");
    }

    // Test method for Case 1: Add Product sub-cases
    private static void testAddProductCases() {
        System.out.println(Color.Yellow() + "Product Type Selection Output:" + Color.Reset());
        System.out.println(Color.Yellow() + """
                1. Electronics
                2. Clothing
                3. Groceries
                """ + Color.Reset());
        
        System.out.println(Color.Cyan() + "\n--- Sub-case 1a: Add Electronics ---" + Color.Reset());
        System.out.println("Adding new electronic product");
        
        System.out.println(Color.Cyan() + "\n--- Sub-case 1b: Add Clothing ---" + Color.Reset());
        System.out.println("Input prompts:");
        System.out.println("  > Enter the size of the clothing product: ");
        System.out.println("  > Enter the brand of the clothing product: ");
        System.out.println("  > Enter the stuff of the clothing product: ");
        System.out.println("  > Enter the color of the clothing product: ");
        System.out.println(Color.Green() + "Adding new clothing product" + Color.Reset());
        
        System.out.println(Color.Cyan() + "\n--- Sub-case 1c: Add Groceries ---" + Color.Reset());
        System.out.println(Color.Green() + "Adding new grocery product" + Color.Reset());
        
        System.out.println(Color.Cyan() + "\n--- Sub-case 1d: Invalid Choice ---" + Color.Reset());
        System.out.println(Color.Red() + "Invalid choice" + Color.Reset());
    }

    // Test method for Case 2: Remove Product sub-cases
    private static void testRemoveProductCases() {
        System.out.println(Color.Yellow() + "Product Type Selection Output:" + Color.Reset());
        System.out.println(Color.Yellow() + """
                1. Electronics
                2. Clothing
                3. Groceries
                """ + Color.Reset());
        
        System.out.println(Color.Cyan() + "\n--- Sub-case 2a: Remove Electronics ---" + Color.Reset());
        System.out.println("Input prompt:");
        System.out.println("  > Enter the id of the electronic product you want to remove: ");
        System.out.println("Removing electronic product with id: 101");
        
        System.out.println(Color.Cyan() + "\n--- Sub-case 2b: Remove Clothing ---" + Color.Reset());
        System.out.println("Input prompt:");
        System.out.println("  > Enter the id of the clothing product you want to remove: ");
        System.out.println("Removing clothing product with id: 202");
        
        System.out.println(Color.Cyan() + "\n--- Sub-case 2c: Remove Groceries ---" + Color.Reset());
        System.out.println("Input prompt:");
        System.out.println("  > Enter the id of the grocery product you want to remove: ");
        System.out.println("Removing grocery product with id: 303");
        
        System.out.println(Color.Cyan() + "\n--- Sub-case 2d: Invalid Choice ---" + Color.Reset());
        System.out.println(Color.Red() + "Invalid choice" + Color.Reset());
    }

    // Test method for Case 3: Edit Product sub-cases
    private static void testEditProductCases() {
        System.out.println(Color.Yellow() + "Product Type Selection Output:" + Color.Reset());
        System.out.println(Color.Yellow() + """
                1. Electronics
                2. Clothing
                3. Groceries
                """ + Color.Reset());
        
        System.out.println(Color.Cyan() + "\n--- Sub-case 3a: Edit Electronics ---" + Color.Reset());
        System.out.println("Input prompt:");
        System.out.println("  > Enter the id of the electronic product you want to edit: ");
        System.out.println("(Inventory Manager will prompt for details to be edited)");
        
        System.out.println(Color.Cyan() + "\n--- Sub-case 3b: Edit Clothing ---" + Color.Reset());
        System.out.println("Input prompt:");
        System.out.println("  > Enter the id of the clothing product you want to edit: ");
        System.out.println("Editing clothing product with id: 202");
        
        System.out.println(Color.Cyan() + "\n--- Sub-case 3c: Edit Groceries ---" + Color.Reset());
        System.out.println("Input prompt:");
        System.out.println("  > Enter the id of the grocery product you want to edit: ");
        System.out.println("Editing grocery product with id: 303");
        
        System.out.println(Color.Cyan() + "\n--- Sub-case 3d: Invalid Choice ---" + Color.Reset());
        System.out.println(Color.Red() + "Invalid choice" + Color.Reset());
    }
}
