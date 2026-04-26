package pakMart.frontEnd;

import java.awt.*;
import javax.swing.*;

public class AdminLoginWindow extends BasicLoginScreen {

    public AdminLoginWindow(){
        super();
        super.setTitle("Admin Login");
    }

    public static void main(String[] args) {
        AdminLoginWindow adminLoginWindow = new AdminLoginWindow();
        adminLoginWindow.setLocationRelativeTo(null); // Center the frame on the screen
        adminLoginWindow.setVisible(true);
    }
}
