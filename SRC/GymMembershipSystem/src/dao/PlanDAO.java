package dao;

import db.DBConnection;
import model.MembershipPlan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlanDAO {

    public boolean addPlan(MembershipPlan p) {
        String sql = "INSERT INTO plans (plan_name, duration_months, price) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getPlanName());
            ps.setInt(2, p.getDurationMonths());
            ps.setDouble(3, p.getPrice());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePlan(MembershipPlan p) {
        String sql = "UPDATE plans SET plan_name=?, duration_months=?, price=? WHERE plan_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getPlanName());
            ps.setInt(2, p.getDurationMonths());
            ps.setDouble(3, p.getPrice());
            ps.setInt(4, p.getPlanId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePlan(int id) {
        String sql = "DELETE FROM plans WHERE plan_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<MembershipPlan> getAllPlans() {
        List<MembershipPlan> list = new ArrayList<>();
        String sql = "SELECT * FROM plans ORDER BY plan_id";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                MembershipPlan p = new MembershipPlan(
                        rs.getInt("plan_id"),
                        rs.getString("plan_name"),
                        rs.getInt("duration_months"),
                        rs.getDouble("price")
                );
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}