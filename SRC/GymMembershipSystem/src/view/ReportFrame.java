package view;

import controller.ReportController;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PrinterException;

public class ReportFrame extends JFrame {
    private JLabel lblTotalMembers, lblActiveMembers, lblRevenue;
    private JButton btnRefresh, btnPrint, btnGoBack;

    private ReportController controller = new ReportController();

    public ReportFrame() {
        setTitle("Report Summary");
        setSize(1100, 730);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("C:\\Users\\User\\Documents\\EAD CW\\SRC\\GymMembershipSystem\\src\\view\\images\\report.png");
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(1100, 700, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        JLabel background = new JLabel(scaledIcon);
        background.setLayout(null);
        setContentPane(background);

        JLabel lblTitle = new JLabel("Gym Report Summary");
        lblTitle.setBounds(130, 240, 300, 25);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
        background.add(lblTitle);

        lblTotalMembers = new JLabel();
        lblTotalMembers.setBounds(270, 300, 300, 25);
        lblTotalMembers.setFont(new Font("Arial", Font.BOLD, 25));
        background.add(lblTotalMembers);

        lblActiveMembers = new JLabel();
        lblActiveMembers.setBounds(270, 370, 300, 25);
        lblActiveMembers.setFont(new Font("Arial", Font.BOLD, 25));
        background.add(lblActiveMembers);

        lblRevenue = new JLabel();
        lblRevenue.setBounds(270, 440, 300, 25);
        lblRevenue.setFont(new Font("Arial", Font.BOLD, 25));
        background.add(lblRevenue);

        btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(680, 147, 100, 33);
        btnRefresh.setFont(new Font("Arial", Font.BOLD, 19));
        btnRefresh.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        btnRefresh.setBackground(Color.white);
        btnRefresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
        background.add(btnRefresh);

        btnPrint = new JButton("Print");
        btnPrint.setBounds(305, 147, 100, 33);
        btnPrint.setFont(new Font("Arial", Font.BOLD, 19));
        btnPrint.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        btnPrint.setBackground(Color.white);
        btnPrint.setCursor(new Cursor(Cursor.HAND_CURSOR));
        background.add(btnPrint);

        btnGoBack = new JButton("Back");
        btnGoBack.setBounds(505, 610, 100, 33);
        btnGoBack.setFont(new Font("Arial", Font.BOLD, 19));
        btnGoBack.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        btnGoBack.setBackground(Color.white);
        btnGoBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        background.add(btnGoBack);

        btnRefresh.addActionListener(e -> loadReport());
        btnPrint.addActionListener(e -> printReport());

        btnGoBack.addActionListener(e -> {
            new DashboardFrame();
            dispose();
        });

        loadReport();
        setVisible(true);
    }

    private void loadReport() {
        lblTotalMembers.setText("Total Members: " + controller.getTotalMembers());
        lblActiveMembers.setText("Active Members: " + controller.getActiveMembers());
        lblRevenue.setText("Total Revenue: Rs. " + controller.getTotalRevenue());
    }

    private void printReport() {
        JTextArea area = new JTextArea();
        area.setText(
                "Gym Membership Report\n\n" +
                        "Total Members: " + controller.getTotalMembers() + "\n" +
                        "Active Members: " + controller.getActiveMembers() + "\n" +
                        "Total Revenue: Rs. " + controller.getTotalRevenue()
        );

        try {
            area.print();
            JOptionPane.showMessageDialog(this, "Printed successfully");
        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}