package org.example;

import org.example.ICalculator;
import org.example.Payment;

import java.util.ArrayList;
import java.util.List;

public class AnnuityCalculatorWithDownPayment implements ICalculator {
    private double originalPrincipal;
    private double downPayment;
    private double annualInterestRate;
    private int years;
    private List<Payment> payments;

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    public double getDownPayment() {
        return downPayment;
    }

    @Override
    public void setPrincipal(double principal) {
        this.originalPrincipal = principal - downPayment;
    }

    @Override
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    @Override
    public void setYears(int years) {
        this.years = years;
    }

    @Override
    public void calculatePayments() {
        double monthlyRate = annualInterestRate / 12 / 100;
        double monthlyPayment = originalPrincipal * (monthlyRate * Math.pow(1 + monthlyRate, years * 12))
                / (Math.pow(1 + monthlyRate, years * 12) - 1);
        payments = new ArrayList<>();
        double currentPrincipal = originalPrincipal;

        for (int month = 1; month <= years * 12; month++) {
            double interestPayment = currentPrincipal * monthlyRate;
            double principalPayment = monthlyPayment - interestPayment;
            currentPrincipal -= principalPayment;

            payments.add(new Payment(month, principalPayment, interestPayment));
        }
    }

    @Override
    public double getTotalPayment() {
        return payments.stream().mapToDouble(Payment::getTotalPayment).sum();
    }

    @Override
    public double getTotalInterest() {
        return payments.stream().mapToDouble(Payment::getInterestPayment).sum();
    }

    @Override
    public List<Payment> getPaymentsSchedule() {
        return payments;
    }

    @Override
    public double getOverpayment() {
        return getTotalPayment() - originalPrincipal;
    }
}