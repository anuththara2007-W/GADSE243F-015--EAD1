package controller;

import dao.ReportDAO;

public class ReportController {
    private ReportDAO dao = new ReportDAO();

    public int getTotalMembers() {
        return dao.getTotalMembers();
    }

    public int getActiveMembers() {
        return dao.getActiveMembers();
    }

    public double getTotalRevenue() {
        return dao.getTotalRevenue();
    }
}