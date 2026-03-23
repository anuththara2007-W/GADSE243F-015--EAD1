package controller;

import dao.PaymentDAO;
import dao.PaymentDAO.PaymentInfo;
import model.Payment;

import java.util.List;

public class PaymentController {
    private PaymentDAO dao = new PaymentDAO();

    public boolean addPayment(Payment p) {
        return dao.addPayment(p);
    }

    public List<PaymentInfo> getAllPayments() {
        return dao.getAllPaymentsWithRemaining();
    }
}