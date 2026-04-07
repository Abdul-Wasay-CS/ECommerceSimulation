package pakMart;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print(Color.Blue() + """
                    ╔══════════════════════════════════════════════════════════════╗
                    ║    Menu :                                                    ║
                    ║    1. Login as Admin                                         ║
                    ║    2. Login as Customer                                      ║
                    ║    3. SignUp as Customer                                     ║
                    ║    4. SignUp as Admin                                        ║
                    ║    5. Exit                                                   ║
                    ╚══════════════════════════════════════════════════════════════╝
                    """ + Color.Reset());
            System.out.print("Enter Your Choice : ");
            int choice = input.nextInt();
            switch (choice) {
                case (1): {
                    System.out.println("Enter your username: ");
                    String username = SafeInputs.getString();
                    System.out.println("Enter your password: ");
                    String password = SafeInputs.getString();

                    if (Admin.exists(username, password)) {
                        System.out.println(Color.Green() + """
                                ╔══════════════════════════════════════════════════════════════╗
                                ║                      Login Successful!                       ║
                                ╚══════════════════════════════════════════════════════════════╝
                                """ + Color.Reset());
                        Admin currAdmin = new Admin();
                        currAdmin.login(username, password);
                        currAdmin.menu();
                    } else {
                        System.out.println(Color.Red() + """
                                ╔══════════════════════════════════════════════════════════════╗
                                ║                    Admin not found!                          ║
                                ║     Please check your username and password and try again.   ║
                                ╚══════════════════════════════════════════════════════════════╝
                                """ + Color.Reset());
                    }
                    break;
                }
                case (2): {
                    System.out.println("Enter your username: ");
                    SafeInputs.getString();
                    System.out.print("Enter your Username : ");
                    String userName = SafeInputs.getString();
                    System.out.print("Enter your password : ");
                    String password = SafeInputs.getString();
                    System.out.println("Logging in...");
                    break;
                }
                case (3): {
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
                case (5): {
                    System.out.println(Color.Green() + """
                            ╔══════════════════════════════════════════════════════════════╗
                            ║                      Thank You! Goodbye!                     ║
                            ╚══════════════════════════════════════════════════════════════╝
                            """ + Color.Reset());
                    input.close();
                    return;
                }
                default: {
                    System.out.println(Color.Red() + """
                            ╔════════════════════════════════════════════════════╗
                            ║                 Invalid Choice!                    ║
                            ║     Please enter a valid option from the menu.     ║
                            ╚════════════════════════════════════════════════════╝
                            """ + Color.Reset());
                    break;
                }
            }
        }
    }
}
