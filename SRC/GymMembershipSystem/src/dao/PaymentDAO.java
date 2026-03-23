package dao;

import db.DBConnection;
import model.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

    public boolean addPayment(Payment p) {
        String sql = "INSERT INTO payments (member_id, plan_id, amount, payment_date) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, p.getMemberId());
            ps.setInt(2, p.getPlanId());
            ps.setDouble(3, p.getAmount());
            ps.setString(4, p.getPaymentDate());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<PaymentInfo> getAllPaymentsWithRemaining() {
        List<PaymentInfo> list = new ArrayList<>();

        String sql = "SELECT p.payment_id, m.full_name, pl.plan_name, pl.price AS plan_price, p.amount, p.payment_date " +
                "FROM payments p " +
                "INNER JOIN members m ON p.member_id = m.member_id " +
                "INNER JOIN plans pl ON p.plan_id = pl.plan_id " +
                "ORDER BY p.payment_id";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                PaymentInfo info = new PaymentInfo();
                info.paymentId = rs.getInt("payment_id");
                info.memberName = rs.getString("full_name");
                info.planName = rs.getString("plan_name");
                info.planPrice = rs.getDouble("plan_price");
                info.amountPaid = rs.getDouble("amount");
                info.paymentDate = rs.getDate("payment_date").toString();
                info.remaining = info.planPrice - info.amountPaid;

                list.add(info);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // Inner class to carry enhanced payment info
    public static class PaymentInfo {
        public int paymentId;
        public String memberName;
        public String planName;
        public double planPrice;
        public double amountPaid;
        public double remaining;
        public String paymentDate;
    }
}