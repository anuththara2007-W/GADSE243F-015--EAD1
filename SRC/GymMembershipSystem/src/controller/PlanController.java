package controller;

import dao.PlanDAO;
import model.MembershipPlan;

import java.util.List;

public class PlanController {
    private PlanDAO dao = new PlanDAO();

    public boolean addPlan(MembershipPlan p) {
        return dao.addPlan(p);
    }

    public boolean updatePlan(MembershipPlan p) {
        return dao.updatePlan(p);
    }

    public boolean deletePlan(int id) {
        return dao.deletePlan(id);
    }

    public List<MembershipPlan> getAllPlans() {
        return dao.getAllPlans();
    }
}