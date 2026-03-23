package view;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {
    private JButton btnMembers, btnPlans, btnPayments, btnReports, btnLogout;

    public DashboardFrame() {
        setTitle("Dashboard");
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("C:\\Users\\User\\Documents\\EAD CW\\SRC\\GymMembershipSystem\\src\\view\\images\\dashboard.png");

        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(1100, 700, Image.SCALE_SMOOTH);

        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        JLabel background = new JLabel(scaledIcon);
        background.setBounds(0, 0, 1100, 700);
        background.setLayout(null);

        setContentPane(background);

        JLabel lblTitle = new JLabel("Gym Membership Dashboard");
        lblTitle.setBounds(150, 20, 250, 30);

        add(lblTitle);

        btnMembers = new JButton("Members");
        btnMembers.setBounds(205, 245, 260, 35);
        btnMembers.setFont(new Font("Arial", Font.PLAIN, 30));
        btnMembers.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        btnMembers.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnMembers.setForeground(Color.BLACK);
        btnMembers.setBackground(Color.white);


        add(btnMembers);

        btnPlans = new JButton("Plans");
        btnPlans.setBounds(710, 245, 160, 35);
        btnPlans.setFont(new Font("Arial", Font.PLAIN, 30));
        btnPlans.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        btnPlans.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnPlans.setForeground(Color.BLACK);
        btnPlans.setBackground(Color.white);
        add(btnPlans);

        btnPayments = new JButton("Payments");
        btnPayments.setBounds(200, 415, 260, 35);
        btnPayments.setFont(new Font("Arial", Font.PLAIN, 30));
        btnPayments.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        btnPayments.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnPayments.setForeground(Color.BLACK);
        btnPayments.setBackground(Color.white);
        add(btnPayments);

        btnReports = new JButton("Reports");
        btnReports.setBounds(665, 415, 260, 35);
        btnReports.setFont(new Font("Arial", Font.PLAIN, 30));
        btnReports.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        btnReports.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnReports.setForeground(Color.BLACK);
        btnReports.setBackground(Color.white);
        add(btnReports);

        btnLogout = new JButton("Logout");
        btnLogout.setBounds(480, 616, 160, 35);

        btnLogout.setFont(new Font("Arial", Font.PLAIN, 25));
        btnLogout.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogout.setForeground(Color.white);
        btnLogout.setBackground(Color.black);
        add(btnLogout);

        btnMembers.addActionListener(e ->{
            new MemberFrame();
            dispose();
        });
        btnPlans.addActionListener(e ->{
            new PlanFrame();
            dispose();
        });
        btnPayments.addActionListener(e ->{
            new PaymentFrame();
            dispose();
        });
        btnReports.addActionListener(e ->{
            new ReportFrame();
            dispose();
        });
        btnLogout.addActionListener(e -> {
            new LoginFrame();
            dispose();
        });

        setVisible(true);
    }
}