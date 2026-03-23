package view;

import controller.AuthController;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JLabel lblTitle, lblUsername, lblPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    private AuthController controller = new AuthController();

    public LoginFrame() {

        setTitle("Gym Membership System - Login");
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Background Image
        ImageIcon icon = new ImageIcon("C:\\Users\\User\\Documents\\EAD CW\\SRC\\GymMembershipSystem\\src\\view\\images\\login.png");

        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(1100, 700, Image.SCALE_SMOOTH);

        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        JLabel background = new JLabel(scaledIcon);
        background.setBounds(0, 0, 1100, 700);
        background.setLayout(null);

        setContentPane(background);


        lblUsername = new JLabel("Username");
        lblUsername.setBounds(315, 224, 200, 175);
        lblUsername.setFont(new Font("Arial", Font.BOLD, 25));
        lblUsername.setForeground(Color.WHITE);
        background.add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(460, 295, 280, 35);
        txtUsername.setFont(new Font("Arial", Font.BOLD, 16));
        txtUsername.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        background.add(txtUsername);

        lblPassword = new JLabel("Password");
        lblPassword.setBounds(315, 290, 200, 175);
        lblPassword.setFont(new Font("Arial", Font.BOLD, 25));
        lblPassword.setForeground(Color.WHITE);
        background.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(460, 360, 280, 35);
        txtPassword.setFont(new Font("Arial", Font.BOLD, 16));
        txtPassword.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        background.add(txtPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(450, 520, 200, 30);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 25));
        btnLogin.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        btnLogin.setBackground(Color.white);
        background.add(btnLogin);

        btnLogin.addActionListener(e -> {
            try {
                login();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        setVisible(true);
    }

    private void login() throws Exception {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        if (controller.login(username, password)) {
            JOptionPane.showMessageDialog(this, "Login successful");
            new DashboardFrame();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password");
        }
    }
}