package pakMart.frontEnd;

import java.awt.*;
import javax.swing.*;

public class AdminLoginWindow extends JFrame {

    // Components of the Admin Login Window
    // Main Panel to format the components in the window
    // The main panel will use BorderLayout
    // The username and password labels and text fields will be placed in the center
    // The login and back buttons will be placed in the south
    private JPanel mainPanel;

    // Labels for username and password
    private JLabel usernameLabel;
    private JLabel passwordLabel;

    // Text fields for username and password input
    private JTextField usernameField;
    private JPasswordField passwordField;

    // Buttons for attemping the login with current inputs
    // and going back to the main menu
    private JButton loginButton;
    private JButton backButton;

    public AdminLoginWindow() {
        this.setTitle("Admin Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Initializing the components
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        mainPanel.setLayout(new BorderLayout(0, 10));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        usernameLabel = new JLabel("Username:");
        usernameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        usernameField = new JTextField(18);
        usernameField.setAlignmentX(Component.LEFT_ALIGNMENT);
        usernameField.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, usernameField.getPreferredSize().height));

        passwordLabel = new JLabel("Password:");
        passwordLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        passwordField = new JPasswordField(18); // to hide the password input from the user
        passwordField.setAlignmentX(Component.LEFT_ALIGNMENT);
        passwordField.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, passwordField.getPreferredSize().height));

        loginButton = new JButton("Login");
        backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        // GridBagConstraints to align the buttons in the button panel
        GridBagConstraints gbc = new GridBagConstraints();
        // gridy is the row index for the button placement in the grid bag layout
        gbc.gridy = 0; // Set the row to 0 for both buttons,
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // gridx is the column index for the button placement in the grid bag layout
        // weightx is the horizantol space distribution between buttons button panel
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        buttonPanel.add(Box.createHorizontalStrut(0), gbc);

        // login aligned to the center of the button panel
        gbc.gridx = 1;
        gbc.weightx = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        buttonPanel.add(loginButton, gbc);

        // back button is aligned to the right of the button panel
        gbc.gridx = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.EAST;
        buttonPanel.add(backButton, gbc);

        // Adding the components to the main panel
        formPanel.add(usernameLabel);
        formPanel.add(Box.createVerticalStrut(4)); // strut refers to just space here between the components
        formPanel.add(usernameField);
        formPanel.add(Box.createVerticalStrut(8));
        formPanel.add(passwordLabel);
        formPanel.add(Box.createVerticalStrut(4));
        formPanel.add(passwordField);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Adding the main panel to the frame
        this.add(mainPanel);
        this.pack(); // Adjust the frame size to fit the components
    }

    public static void main(String[] args) {
        AdminLoginWindow adminLoginWindow = new AdminLoginWindow();
        adminLoginWindow.setLocationRelativeTo(null); // Center the frame on the screen
        adminLoginWindow.setVisible(true);
    }
}
