package com.foldrent.services;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

import com.foldrent.models.Payment;
import com.foldrent.models.Tenants;
import com.foldrent.database.JsonDatabase;

public class PaymentService {
    private List<Payment> payments;
    private JsonDatabase database;
    private int nextPaymentId;
    private TenantService tenantService;
    private final double LATE_FEE_AMOUNT = 50.0;

    public PaymentService(TenantService tenantService) {
        this.database = new JsonDatabase();
        this.payments = database.loadPayments();
        this.tenantService = tenantService;

        if (payments.isEmpty()) {
            this.nextPaymentId = 1;
        } else {
            int maxId = 0;
            for (int i = 0; i < payments.size(); i++) {
                Payment payment = payments.get(i);
                if (payment.getPaymentID() > maxId) {
                    maxId = payment.getPaymentID();
                }
            }
            this.nextPaymentId = maxId + 1;
        }
    }

    public double calculateLateFee(Tenants tenant, LocalDate paymentDate) {
        LocalDate dueDate = tenant.getMoveInDate().plusMonths(tenant.getRentMissed() + 1);
        if (paymentDate.isAfter(dueDate)) {
            return LATE_FEE_AMOUNT; // Return the fee
        }
        return 0.0; // Return 0 if not late
    }

    public void RecordPayment(int tenantID,
            double paymentAmount, LocalDate paymentDate,
            String paymentMethod, String paymentDescription) {

        Tenants tenant = tenantService.findTenantById(tenantID);

        if (tenant != null) {

            double lateFee = calculateLateFee(tenant, paymentDate);

            Payment newPayment = new Payment(nextPaymentId, tenantID,
                    paymentAmount, paymentDate,
                    paymentMethod, paymentDescription,
                    tenant.getRentBalance() > 0 ? (int) LATE_FEE_AMOUNT : 0);

            payments.add(newPayment);
            nextPaymentId++;

            double newBalance = tenant.getRentBalance() - paymentAmount;
            tenant.setRentBalance(newBalance < 0 ? 0 : newBalance);

            tenantService.saveData();
            saveData();
        }

    }

    private boolean saveData() {
        try {
            database.savePayments(payments);
            return true;
        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
            return false;
        }
    }

}
