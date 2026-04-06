package pakMart;

import java.util.InputMismatchException;
import java.util.Scanner;

abstract public class SafeInputs {
    // Abstract class so no objects are created
    private static final Scanner input = new Scanner(System.in);

    public static int getInt() {
        while (true) {
            try {
                int input.nextInt();    // breaks the loop if there is no exception in line 10
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer only");
                input.nextLine();
            }
        }
    }

    public static double getDouble() {
        while (true) {
            try {
                return input.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a real number only.");
            }
        }
    }

    public static String getString() {
        while (true) {
            try {
                return input.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Please enter a string.");
            }
        }
    }

    public static boolean getBoolean(){
        while(true){
            try{
                return input.nextBoolean();
            }catch (InputMismatchException e){
                System.out.println("Enter only an boolean.");
            }
        }
    }
}
