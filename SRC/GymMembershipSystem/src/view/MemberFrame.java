package view;

import controller.MemberController;
import model.Member;
import util.ValidationUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MemberFrame extends JFrame {
    private JTextField txtId, txtName, txtPhone, txtEmail, txtAddress, txtJoinDate, txtStatus;
    private JButton btnAdd, btnUpdate, btnDelete, btnLoad, btnClear, btnGoBack;
    private JTextArea area;

    private MemberController controller = new MemberController();

    public MemberFrame() {
        setTitle("Manage Members");
        setSize(1100, 730);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("C:\\Users\\User\\Documents\\EAD CW\\SRC\\GymMembershipSystem\\src\\view\\images\\users.png");

        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(1100, 700, Image.SCALE_SMOOTH);

        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        JLabel background = new JLabel(scaledIcon);
        background.setBounds(0, 0, 1100, 700);
        background.setLayout(null);

        setContentPane(background);

        JLabel lblId = new JLabel("Member ID");
        lblId.setBounds(60, 145, 100, 25);
        lblId.setFont(new Font("Arial", Font.BOLD, 19));
        lblId.setForeground(Color.WHITE);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(230, 140, 250, 30);
        txtId.setFont(new Font("Arial", Font.BOLD, 19));
        txtId.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        add(txtId);

        JLabel lblName = new JLabel("Full Name");
        lblName.setBounds(60, 191, 100, 25);
        lblName.setFont(new Font("Arial", Font.BOLD, 17));
        lblName.setForeground(Color.WHITE);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(230, 190, 250, 30);
        txtName.setFont(new Font("Arial", Font.BOLD, 19));
        txtName.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        add(txtName);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(60, 237, 100, 25);
        lblPhone.setFont(new Font("Arial", Font.BOLD, 17));
        lblPhone.setForeground(Color.WHITE);
        add(lblPhone);

        txtPhone = new JTextField();
        txtPhone.setBounds(230, 240, 250, 30);
        txtPhone.setFont(new Font("Arial", Font.BOLD, 19));
        txtPhone.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        add(txtPhone);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(60, 293, 100, 25);
        lblEmail.setFont(new Font("Arial", Font.BOLD, 17));
        lblEmail.setForeground(Color.WHITE);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(230, 288, 250, 30);
        txtEmail.setFont(new Font("Arial", Font.BOLD, 19));
        txtEmail.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        add(txtEmail);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(600, 140, 100, 25);
        lblAddress.setFont(new Font("Arial", Font.BOLD, 19));
        lblAddress.setForeground(Color.WHITE);
        add(lblAddress);

        txtAddress = new JTextField();
        txtAddress.setBounds(750, 140, 250, 30);
        txtAddress.setFont(new Font("Arial", Font.BOLD, 19));
        txtAddress.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        add(txtAddress);

        JLabel lblJoinDate = new JLabel("Join Date");
        lblJoinDate.setBounds(600, 190, 100, 25);
        lblJoinDate.setFont(new Font("Arial", Font.BOLD, 19));
        lblJoinDate.setForeground(Color.WHITE);
        add(lblJoinDate);

        txtJoinDate = new JTextField("2026-03-12");
        txtJoinDate.setBounds(750, 190, 250, 30);
        txtJoinDate.setFont(new Font("Arial", Font.BOLD, 19));
        txtJoinDate.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        add(txtJoinDate);

        JLabel lblStatus = new JLabel("Status");
        lblStatus.setBounds(600, 240, 100, 25);
        lblStatus.setFont(new Font("Arial", Font.BOLD, 19));
        lblStatus.setForeground(Color.WHITE);
        add(lblStatus);

        txtStatus = new JTextField("Active");
        txtStatus.setBounds(750, 240, 250, 30);
        txtStatus.setFont(new Font("Arial", Font.BOLD, 19));
        txtStatus.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        add(txtStatus);

        btnAdd = new JButton("Add");
        btnAdd.setBounds(590, 300, 80, 30);
        btnAdd.setFont(new Font("Arial", Font.BOLD, 20));
        btnAdd.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAdd.setBackground(Color.white);
        add(btnAdd);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(750, 300, 90, 30);
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 20));
        btnUpdate.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        btnUpdate.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnUpdate.setBackground(Color.white);
        add(btnUpdate);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(920, 300, 90, 30);
        btnDelete.setFont(new Font("Arial", Font.BOLD, 20));
        btnDelete.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDelete.setBackground(Color.white);
        add(btnDelete);

        btnLoad = new JButton("Load");
        btnLoad.setBounds(590, 355, 90, 30);
        btnLoad.setFont(new Font("Arial", Font.BOLD, 20));
        btnLoad.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        btnLoad.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLoad.setBackground(Color.white);
        add(btnLoad);

        btnClear = new JButton("Clear");
        btnClear.setBounds(750, 355, 90, 30);
        btnClear.setFont(new Font("Arial", Font.BOLD, 20));
        btnClear.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnClear.setBackground(Color.white);
        add(btnClear);

        btnGoBack = new JButton("Return");
        btnGoBack.setBounds(916, 355, 95, 30);
        btnGoBack.setFont(new Font("Arial", Font.BOLD, 20));
        btnGoBack.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        btnGoBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnGoBack.setBackground(Color.white);
        add(btnGoBack);

        area = new JTextArea();
        area.setEditable(false);
        area.setCursor(new Cursor(Cursor.HAND_CURSOR));
        area.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));

        JScrollPane sp = new JScrollPane(area);
        sp.setBounds(50, 410, 990, 250);
        add(sp);

        loadMembers();

        btnGoBack.addActionListener(e -> {
            new DashboardFrame();
            dispose();
        });
        btnAdd.addActionListener(e -> addMember());
        btnUpdate.addActionListener(e -> updateMember());
        btnDelete.addActionListener(e -> deleteMember());
        btnLoad.addActionListener(e -> loadMembers());
        btnClear.addActionListener(e -> clearFields());

        setVisible(true);
    }

    private void addMember() {
        try {
            if (ValidationUtil.isEmpty(txtName.getText()) || ValidationUtil.isEmpty(txtPhone.getText())) {
                JOptionPane.showMessageDialog(this, "Name and phone are required");
                return;
            }

            if (!ValidationUtil.isEmpty(txtEmail.getText()) && !ValidationUtil.isEmailValid(txtEmail.getText())) {
                JOptionPane.showMessageDialog(this, "Invalid email");
                return;
            }

            Member m = new Member();
            m.setFullName(txtName.getText());
            m.setPhone(txtPhone.getText());
            m.setEmail(txtEmail.getText());
            m.setAddress(txtAddress.getText());
            m.setJoinDate(txtJoinDate.getText());
            m.setStatus(txtStatus.getText());

            if (controller.addMember(m)) {
                JOptionPane.showMessageDialog(this, "Member added");
                clearFields();
                loadMembers();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add member");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void updateMember() {
        try {
            if (ValidationUtil.isEmpty(txtId.getText())) {
                JOptionPane.showMessageDialog(this, "Enter member ID");
                return;
            }

            Member m = new Member();
            m.setMemberId(Integer.parseInt(txtId.getText()));
            m.setFullName(txtName.getText());
            m.setPhone(txtPhone.getText());
            m.setEmail(txtEmail.getText());
            m.setAddress(txtAddress.getText());
            m.setJoinDate(txtJoinDate.getText());
            m.setStatus(txtStatus.getText());

            if (controller.updateMember(m)) {
                JOptionPane.showMessageDialog(this, "Member updated");
                clearFields();
                loadMembers();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update member");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void deleteMember() {
        try {
            if (ValidationUtil.isEmpty(txtId.getText())) {
                JOptionPane.showMessageDialog(this, "Enter member ID");
                return;
            }

            int id = Integer.parseInt(txtId.getText());

            if (controller.deleteMember(id)) {
                JOptionPane.showMessageDialog(this, "Member deleted");
                clearFields();
                loadMembers();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete member");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void loadMembers() {
        List<Member> list = controller.getAllMembers();
        StringBuilder sb = new StringBuilder();

        for (Member m : list) {
            sb.append("ID: ").append(m.getMemberId())
                    .append(" | Name: ").append(m.getFullName())
                    .append(" | Phone: ").append(m.getPhone())
                    .append(" | Email: ").append(m.getEmail())
                    .append(" | Address: ").append(m.getAddress())
                    .append(" | Join Date: ").append(m.getJoinDate())
                    .append(" | Status: ").append(m.getStatus())
                    .append("\n");
        }

        area.setText(sb.toString());
    }

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        txtJoinDate.setText("2026-03-12");
        txtStatus.setText("Active");
    }
}