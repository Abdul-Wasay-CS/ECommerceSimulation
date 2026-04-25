package pakMart;

import java.io.*;
import java.util.Scanner;

public class CustomerFileManager extends FileManager {

    private static final String CUSTOMER_FILE = "Customer.txt";

    static Customer load(String userName, String password) {
        try {
            File customerDetails = new File(CUSTOMER_FILE);
            Scanner reader = new Scanner(customerDetails);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] details = line.split(",");

                if (details.length < 11) {
                    continue;
                }

                if (details[1].equals(userName) && details[2].equals(password)) {
                    Address address = new Address(details[3], details[4], details[5],
                            Integer.parseInt(details[6]), Integer.parseInt(details[7]));
                    Customer customer = new Customer(details[0], details[1], address,
                            Integer.parseInt(details[8]), details[9], Integer.parseInt(details[10]));
                    customer.password = details[2];
                    reader.close();
                    return customer;
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(Color.Red() + """
                    ╔══════════════════════════════════════════════════════════════╗
                    ║ An error occurred while reading the login file.              ║
                    ║ Please try again later.                                      ║
                    ╚══════════════════════════════════════════════════════════════╝
                    """ + Color.Reset());
        }
        return null;
    }

    static boolean find(String userName, String password) {
        return load(userName, password) != null;
    }

    static boolean saveData(Object o) {
        if (!(o instanceof Customer customer)) {
            return false;
        }

        try {
            File customerDetails = new File(CUSTOMER_FILE);
            PrintWriter writer = new PrintWriter(new FileWriter(customerDetails, true));
            writer.println(customer.getFullName() + "," + customer.getUserName() + "," + customer.getPassword()
                    + "," + customer.getAddress().getCountry() + "," + customer.getAddress().getCity() + ","
                    + customer.getAddress().getSociety() + "," + customer.getAddress().getStreetNo() + ","
                    + customer.getAddress().getHouseNo() + "," + customer.getSsn() + "," + customer.phoneNumber
                    + "," + customer.history);
            writer.close();
            return true;
        } catch (Exception e) {
            System.out.println(Color.Red() + """
                    ╔══════════════════════════════════════════════════════════════╗
                    ║ An error occurred while writing to the signup file.          ║
                    ║ Please try again later.                                      ║
                    ╚══════════════════════════════════════════════════════════════╝
                    """ + Color.Reset());
            return false;
        }
    }
}
