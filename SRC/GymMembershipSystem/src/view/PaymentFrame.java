package view;

import dao.PaymentDAO;
import model.Payment;
import util.ValidationUtil;
import view.DashboardFrame;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.List;

public class PaymentFrame extends JFrame {
    private JTextField txtMemberId, txtPlanId, txtAmount, txtPaymentDate;
    private JButton btnAdd, btnLoad, btnGo;
    private JTextPane area;
    private PaymentDAO dao = new PaymentDAO();

    public PaymentFrame() {
        setTitle("Manage Payments");
        setSize(1100, 730);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("C:\\Users\\User\\Documents\\EAD CW\\SRC\\GymMembershipSystem\\src\\view\\images\\payments.png");
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(1100, 700, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        JLabel background = new JLabel(scaledIcon);
        background.setLayout(null);
        setContentPane(background);

        addLabelAndField(background, "Member ID", 50, 140, 230, 140);
        addLabelAndField(background, "Plan ID", 50, 190, 230, 190);
        addLabelAndField(background, "Amount", 560, 140, 740, 140);
        addLabelAndField(background, "Payment Date", 560, 190, 740, 190);

        btnAdd = addButton(background, "Add", 305, 270);
        btnLoad = addButton(background, "Load", 515, 270);
        btnGo = addButton(background, "Go Back", 721, 270);

        area = new JTextPane();
        area.setEditable(false);
        area.setContentType("text/html"); // HTML for styling
        JScrollPane sp = new JScrollPane(area);
        sp.setBounds(50, 347, 987, 320);
        background.add(sp);

        btnAdd.addActionListener(e -> addPayment());
        btnLoad.addActionListener(e -> loadPayments());
        btnGo.addActionListener(e -> {
            new DashboardFrame();
            dispose();
        });

        loadPayments();
        setVisible(true);
    }

    private void addLabelAndField(JLabel background, String text, int lblX, int lblY, int txtX, int txtY) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(lblX, lblY, 150, 25);
        lbl.setFont(new Font("Arial", Font.BOLD, 19));
        lbl.setForeground(Color.white);
        background.add(lbl);

        JTextField txt = new JTextField();
        txt.setBounds(txtX, txtY, 260, 30);
        txt.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        txt.setFont(new Font("Arial", Font.BOLD, 19));
        txt.setForeground(Color.white);
        background.add(txt);

        switch (text) {
            case "Member ID" -> txtMemberId = txt;
            case "Plan ID" -> txtPlanId = txt;
            case "Amount" -> txtAmount = txt;
            case "Payment Date" -> txtPaymentDate = txt;
        }
    }

    private JButton addButton(JLabel background, String text, int x, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 105, 30);
        btn.setFont(new Font("Arial", Font.BOLD, 20));
        btn.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setBackground(Color.white);
        background.add(btn);
        return btn;
    }

    private void addPayment() {
        try {
            if (ValidationUtil.isEmpty(txtMemberId.getText()) ||
                    ValidationUtil.isEmpty(txtPlanId.getText()) ||
                    ValidationUtil.isEmpty(txtAmount.getText())) {

                JOptionPane.showMessageDialog(this, "Member ID, Plan ID and Amount are required");
                return;
            }

            if (!ValidationUtil.isNumber(txtAmount.getText())) {
                JOptionPane.showMessageDialog(this, "Amount must be a number");
                return;
            }

            Payment p = new Payment();
            p.setMemberId(Integer.parseInt(txtMemberId.getText()));
            p.setPlanId(Integer.parseInt(txtPlanId.getText()));
            p.setAmount(Double.parseDouble(txtAmount.getText()));
            p.setPaymentDate(txtPaymentDate.getText());

            if (dao.addPayment(p)) {
                JOptionPane.showMessageDialog(this, "Payment added");
                clearFields();
                loadPayments();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add payment");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void loadPayments() {
        List<PaymentDAO.PaymentInfo> list = dao.getAllPaymentsWithRemaining();
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body style='text-align:center; font-family:Arial; font-size:14px;'>");
        sb.append("<h2>PAYMENT & MEMBER SUMMARY</h2>");
        sb.append("<hr>");

        if (list.isEmpty()) {
            sb.append("<p>No payment records found.</p>");
        } else {
            for (PaymentDAO.PaymentInfo info : list) {
                sb.append("<div style='margin-bottom:15px;'>");
                sb.append("<b>Payment ID:</b> ").append(info.paymentId).append("<br>");
                sb.append("<b>Member Name:</b> ").append(info.memberName).append("<br>");
                sb.append("<b>Plan Name:</b> ").append(info.planName).append("<br>");
                sb.append("<b>Plan Price:</b> ").append(info.planPrice).append("<br>");
                sb.append("<b>Amount Paid:</b> ").append(info.amountPaid).append("<br>");
                sb.append("<b>Remaining:</b> ").append(info.remaining <= 0 ? "PAID" : info.remaining).append("<br>");
                sb.append("<b>Payment Date:</b> ").append(info.paymentDate).append("<br>");
                sb.append("<b>Status:</b> ").append(info.remaining <= 0 ? "FULLY PAID ✅" : "PENDING ⚠️").append("<br>");
                sb.append("</div><hr>");
            }
        }

        sb.append("</body></html>");
        area.setText(sb.toString());
    }

    private void clearFields() {
        txtMemberId.setText("");
        txtPlanId.setText("");
        txtAmount.setText("");
        txtPaymentDate.setText("");
    }
}