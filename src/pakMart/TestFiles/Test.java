package pakMart.TestFiles;

import pakMart.Color;

public class Test {
    public static void main(String[] args) {

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
        System.out.println(Color.Cyan() + "=".repeat(40)+Color.Reset());
        
    }
}
