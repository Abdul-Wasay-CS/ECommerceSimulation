package pakMart;

import pakMart.Admin;
import pakMart.Color;
import pakMart.SafeInputs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("""
                Menu :
                1. Login as Admin
                2. Login as Customer
                3. SignUp as Customer
                4. SignUp as Admin
                Enter Your Choice : """);
        int choice = input.nextInt();
        switch (choice) {
            case (1): {
                System.out.println("Enter your username: ");
                String username = SafeInputs.getString();
                System.out.println("Enter your password: ");
                String password = SafeInputs.getString();

                if (Admin.exists(username, password)) {
                    System.out.println(Color.Green() + "Admin found!\n Logging you in" + Color.Reset());
                    Admin currAdmin = new Admin();
                    currAdmin.login(username, password);
                    currAdmin.menu();   // the rest of actions are performed inside admin
                } else {
                    System.out.println(Color.Red() + "Admin not found" + Color.Reset());
                }
                break;
            }
            case (2): {
//                // Customer.login();
//                input.nextLine();
//                System.out.print("Enter your Username : ");
//                String userName = input.nextLine();
//                System.out.print("Enter your password : ");
//                String password = input.nextLine();
//                Customer.login(userName, password);
                System.out.println("Logging in as Customer");
                break;
            }
            case (3): {
                // Customer.signUp();
                input.nextLine();
                System.out.print("Enter your Full Name : ");
                String fullName = input.nextLine();
                System.out.print("Enter your Username : ");
                String newUserName = input.nextLine();
                System.out.print("Enter your password : ");
                String newPassword = input.nextLine();
                System.out.print("Enter Your Country : ");
                String country = input.nextLine();
                System.out.print("Enter Your City : ");
                String city = input.nextLine();
                System.out.print("Enter Your Society : ");
                String society = input.nextLine();
                System.out.print("Enter Your Street No : ");
                int streetNo = input.nextInt();
                System.out.print("Enter Your House No : ");
                int houseNo = input.nextInt();
                input.nextLine();
                System.out.print("Enter your Phone Number : ");
                String phoneNumber = input.nextLine();
                Customer.signUp(fullName, newUserName, newPassword, country, city, society, streetNo, houseNo,
                        phoneNumber);
                break;
            }
            case (4): {
                Admin newAdmin = new Admin();
                newAdmin.signUp();
                break;
            }
            default: {
<<<<<<< HEAD
		System.out.pringt(Color.Red()+"Invalid Choice"+Color.Reset());
=======
		System.out.print(Color.Red()+"Invalid Choice"+Color.Reset());
>>>>>>> Making-Main-Class
                break;
            }
        }
        input.close();
    }
}
