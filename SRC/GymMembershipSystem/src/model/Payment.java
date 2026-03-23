package model;

public class Payment {
    private int paymentId;
    private int memberId;
    private int planId;
    private double amount;
    private String paymentDate;

    public Payment() {
    }

    public Payment(int paymentId, int memberId, int planId, double amount, String paymentDate) {
        this.paymentId = paymentId;
        this.memberId = memberId;
        this.planId = planId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
}