package pakMart.frontEnd;

import java.awt.*;
import javax.swing.*;

// For Displaying the Main menu buttons , display format is in grid  layout

public class MainMenu extends JFrame {

    JPanel mainPanel;
    JButton adminLoginBtn;
    JButton customerLoginBtn;
    JButton adminSignupBtn;
    JButton customerSignupBtn;
    JButton exitBtn;

    public MainMenu() {

        // main panel border consants.
        final int MP_TOP_SPACE = 10;
        final int MP_BOTTOM_SPACE = 10;
        final int MP_LEFT_SPACE = 10;
        final int MP_RIGHT_SPACE = 10;

        mainPanel = new JPanel(new GridLayout(3, 2, 3, 3));
        adminLoginBtn = new JButton("Login as Admin");
        customerLoginBtn = new JButton("Login as Customer");
        adminSignupBtn = new JButton("SignUp as Admin");
        customerSignupBtn = new JButton("SignUp as Customer");
        exitBtn = new JButton("Exit");

        // Setting the properties of the buttons
        adminLoginBtn.setBackground(CustomColors.SILVER);
        adminLoginBtn.setForeground(CustomColors.BLACK);
        adminLoginBtn.setFont(new Font("Arial", Font.BOLD, 16));
        adminLoginBtn.setPreferredSize(new Dimension(200, 50));

        customerLoginBtn.setBackground(CustomColors.SILVER);
        customerLoginBtn.setForeground(CustomColors.BLACK);
        customerLoginBtn.setFont(new Font("Arial", Font.BOLD, 16));
        customerLoginBtn.setPreferredSize(new Dimension(200, 50));

        adminSignupBtn.setBackground(CustomColors.SILVER);
        adminSignupBtn.setForeground(CustomColors.BLACK);
        adminSignupBtn.setFont(new Font("Arial", Font.BOLD, 16));
        adminSignupBtn.setPreferredSize(new Dimension(200, 50));

        customerSignupBtn.setBackground(CustomColors.SILVER);
        customerSignupBtn.setForeground(CustomColors.BLACK);
        customerSignupBtn.setFont(new Font("Arial", Font.BOLD, 16));
        customerSignupBtn.setPreferredSize(new Dimension(200, 50));

        exitBtn.setBackground(CustomColors.SILVER);
        exitBtn.setForeground(CustomColors.BLACK);
        exitBtn.setFont(new Font("Arial", Font.BOLD, 16));
        exitBtn.setPreferredSize(new Dimension(200, 50));

        // Adding the buttons to the main panel
        mainPanel.add(adminLoginBtn);
        mainPanel.add(customerLoginBtn);
        mainPanel.add(adminSignupBtn);
        mainPanel.add(customerSignupBtn);

        // Setting the properties of the main panel
        mainPanel.setBackground(CustomColors.NAVY_BLUE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(
                MP_TOP_SPACE, MP_LEFT_SPACE,
                MP_BOTTOM_SPACE, MP_RIGHT_SPACE));
        // Adding the main panel to the frame
        this.add(mainPanel);

        // Setting the properties of the frame
        this.setTitle("PakMart Main Menu");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width / 2, screenSize.height / 2); // Half-screen size

    }

    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setLocationRelativeTo(null); // Center the frame on the screen
        mainMenu.setVisible(true);
    }
}
