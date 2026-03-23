package view;

import controller.PlanController;
import model.MembershipPlan;
import util.ValidationUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PlanFrame extends JFrame {

    private JTextField txtId, txtPlanName, txtDuration, txtPrice;
    private JButton btnAdd, btnUpdate, btnDelete, btnLoad, btnClear, btnBack;
    private JTextArea area;

    private PlanController controller = new PlanController();

    public PlanFrame() {
        setTitle("Manage Plans");
        setSize(1100, 730);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("C:\\Users\\User\\Documents\\EAD CW\\SRC\\GymMembershipSystem\\src\\view\\images\\plan.png");
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(1100, 700, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(scaledImg));
        background.setLayout(null);
        setContentPane(background);

        addLabel(background, "Plan ID", 40, 150);
        addLabel(background, "Plan Name", 40, 200);
        addLabel(background, "Duration", 530, 140);
        addLabel(background, "Price", 530, 190);

        txtId = createStyledField(177, 145);
        txtPlanName = createStyledField(177, 195);
        txtDuration = createStyledField(665, 140);
        txtPrice = createStyledField(665, 190);

        background.add(txtId);
        background.add(txtPlanName);
        background.add(txtDuration);
        background.add(txtPrice);

        btnAdd = createButton("Add", 320, 267);
        btnUpdate = createButton("Update", 507, 267);
        btnDelete = createButton("Delete", 700, 267);
        btnLoad = createButton("Load", 320, 330);
        btnClear = createButton("Clear", 507, 330);
        btnBack = createButton("Back", 700, 330);

        background.add(btnAdd);
        background.add(btnUpdate);
        background.add(btnDelete);
        background.add(btnLoad);
        background.add(btnClear);
        background.add(btnBack);

        area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Consolas", Font.PLAIN, 16));
        area.setForeground(Color.WHITE);
        area.setBackground(new Color(0, 0, 0, 150));
        area.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane sp = new JScrollPane(area);
        sp.setBounds(40, 398, 1000, 260);
        sp.setBorder(BorderFactory.createEmptyBorder());
        sp.getViewport().setOpaque(false);
        sp.setOpaque(false);

        background.add(sp);

        btnAdd.addActionListener(e -> addPlan());
        btnUpdate.addActionListener(e -> updatePlan());
        btnDelete.addActionListener(e -> deletePlan());
        btnLoad.addActionListener(e -> loadPlans());
        btnClear.addActionListener(e -> clearFields());
        btnBack.addActionListener(e -> {
            new DashboardFrame();
            dispose();
        });

        loadPlans();
        setVisible(true);
    }


    private JTextField createStyledField(int x, int y) {
        JTextField field = new JTextField();
        field.setBounds(x, y, 260, 33);
        field.setFont(new Font("Arial", Font.BOLD, 18));
        field.setForeground(Color.WHITE);
        field.setBackground(new Color(0, 0, 0, 120));
        field.setCaretColor(Color.WHITE);

        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(255,255,255,80), 1),
                BorderFactory.createEmptyBorder(5,10,5,10)
        ));

        return field;
    }

    private JButton createButton(String text, int x, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 110, 33);
        btn.setFont(new Font("Arial", Font.BOLD, 16));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setFocusPainted(false);
        btn.setBackground(Color.WHITE);
        return btn;
    }

    private void addLabel(JLabel parent, String text, int x, int y) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x, y, 150, 25);
        lbl.setFont(new Font("Arial", Font.BOLD, 18));
        lbl.setForeground(Color.WHITE);
        parent.add(lbl);
    }


    private void addPlan() {
        try {
            if (ValidationUtil.isEmpty(txtPlanName.getText())) {
                showError("Plan name is required");
                return;
            }

            if (ValidationUtil.isEmpty(txtDuration.getText())) {
                showError("Duration is required");
                return;
            }

            if (ValidationUtil.isEmpty(txtPrice.getText())) {
                showError("Price is required");
                return;
            }

            int duration;
            double price;

            try {
                duration = Integer.parseInt(txtDuration.getText());
                if (duration <= 0) throw new Exception();
            } catch (Exception e) {
                showError("Duration must be a valid positive number");
                return;
            }

            try {
                price = Double.parseDouble(txtPrice.getText());
                if (price <= 0) throw new Exception();
            } catch (Exception e) {
                showError("Price must be a valid positive amount");
                return;
            }

            MembershipPlan p = new MembershipPlan();
            p.setPlanName(txtPlanName.getText());
            p.setDurationMonths(duration);
            p.setPrice(price);

            if (controller.addPlan(p)) {
                showSuccess("Plan added successfully");
                clearFields();
                loadPlans();
            } else {
                showError("Failed to add plan");
            }

        } catch (Exception ex) {
            showError(ex.getMessage());
        }
    }

    private void updatePlan() {
        try {
            if (ValidationUtil.isEmpty(txtId.getText())) {
                showError("Plan ID is required");
                return;
            }

            MembershipPlan p = new MembershipPlan();
            p.setPlanId(Integer.parseInt(txtId.getText()));
            p.setPlanName(txtPlanName.getText());
            p.setDurationMonths(Integer.parseInt(txtDuration.getText()));
            p.setPrice(Double.parseDouble(txtPrice.getText()));

            if (controller.updatePlan(p)) {
                showSuccess("Plan updated successfully");
                clearFields();
                loadPlans();
            } else {
                showError("Failed to update plan");
            }

        } catch (Exception ex) {
            showError("Invalid input values");
        }
    }

    private void deletePlan() {
        try {
            if (ValidationUtil.isEmpty(txtId.getText())) {
                showError("Plan ID is required");
                return;
            }

            int id = Integer.parseInt(txtId.getText());

            if (controller.deletePlan(id)) {
                showSuccess("Plan deleted successfully");
                clearFields();
                loadPlans();
            } else {
                showError("Failed to delete plan");
            }

        } catch (Exception ex) {
            showError("Invalid ID");
        }
    }

    private void loadPlans() {
        List<MembershipPlan> list = controller.getAllPlans();
        StringBuilder sb = new StringBuilder();

        String format = "%-5s %-20s %-15s %-10s\n";

        sb.append(String.format(format, "ID", "PLAN", "DURATION", "PRICE"));
        sb.append("------------------------------------------------------------\n");

        for (MembershipPlan p : list) {
            sb.append(String.format(format,
                    p.getPlanId(),
                    p.getPlanName(),
                    p.getDurationMonths() + " months",
                    p.getPrice()
            ));
        }

        area.setText(sb.toString());
    }

    private void clearFields() {
        txtId.setText("");
        txtPlanName.setText("");
        txtDuration.setText("");
        txtPrice.setText("");
    }



    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void showSuccess(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}