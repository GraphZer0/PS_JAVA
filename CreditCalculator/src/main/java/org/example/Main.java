package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите вид платежа (1 - аннуитетный, 2 - дифференцированный):");
        int paymentType = scanner.nextInt();

        ICalculator calculator;

        if (paymentType == 1) {
            double principal = InputValidator.validatePositiveDouble(scanner, "Введите сумму долга: ");
            double downPayment =  InputValidator.validatePositiveDouble(scanner, "Введите первоначальный взнос:");
            int years = InputValidator.validatePositiveInt(scanner, "Введите срок кредита в годах: ");
            double annualInterestRate = InputValidator.validatePositiveDouble(scanner, "Введите процентную ставку: ");

            if (downPayment > 0) {
                AnnuityCalculatorWithDownPayment calc = new AnnuityCalculatorWithDownPayment();
                calc.setPrincipal(principal);
                calc.setDownPayment(downPayment);
                calc.setAnnualInterestRate(annualInterestRate);
                calc.setYears(years);
                calculator = calc;
            } else {
                calculator = new AnnuityCalculator();
                calculator.setPrincipal(principal);
                calculator.setAnnualInterestRate(annualInterestRate);
                calculator.setYears(years);
            }
        } else if (paymentType == 2) {
            double principal = InputValidator.validatePositiveDouble(scanner, "Введите сумму долга: ");
            int years = InputValidator.validatePositiveInt(scanner, "Введите срок кредита в годах: ");
            double annualInterestRate = InputValidator.validatePositiveDouble(scanner, "Введите процентную ставку: ");

            calculator = new DifferentiatedCalculator();
            calculator.setPrincipal(principal);
            calculator.setAnnualInterestRate(annualInterestRate);
            calculator.setYears(years);
        } else {
            System.out.println("Неверный тип платежа. Выбран стандартный аннуитетный.");
            System.out.println("Введите сумму кредита:");
            double principal = InputValidator.validatePositiveDouble(scanner, "");

            System.out.println("Введите первоначальный взнос (если нет, введите 0):");
            double downPayment = InputValidator.validateNonNegativeDouble(scanner, "");

            System.out.println("Введите срок кредита в годах:");
            int years = InputValidator.validatePositiveInt(scanner, "");

            System.out.println("Введите процентную ставку:");
            double annualInterestRate = InputValidator.validatePositiveDouble(scanner, "");

            if (downPayment > 0) {
                AnnuityCalculatorWithDownPayment calc = new AnnuityCalculatorWithDownPayment();
                calc.setPrincipal(principal);
                calc.setDownPayment(downPayment);
                calc.setAnnualInterestRate(annualInterestRate);
                calc.setYears(years);
                calculator = calc;
            } else {
                calculator = new AnnuityCalculator();
                calculator.setPrincipal(principal);
                calculator.setAnnualInterestRate(annualInterestRate);
                calculator.setYears(years);
            }
        }

        calculator.calculatePayments();

        printSchedule(calculator);
    }

    private static void printSchedule(ICalculator calculator) {
        System.out.println("График платежей:");
        for (Payment payment : calculator.getPaymentsSchedule()) {
            System.out.printf("Месяц: %d, Платеж по основному долгу: %.2f, Процентный платеж: %.2f, Общий платеж: %.2f%n",
                    payment.getMonth(), payment.getPrincipalPayment(), payment.getInterestPayment(), payment.getTotalPayment());
        }

        System.out.printf("Общая сумма выплат: %.2f%n", calculator.getTotalPayment());
        System.out.printf("Общая сумма процентов: %.2f%n", calculator.getTotalInterest());
        System.out.printf("Переплата по кредиту: %.2f%n", calculator.getOverpayment());

        if (calculator instanceof AnnuityCalculatorWithDownPayment) {
            AnnuityCalculatorWithDownPayment calc = (AnnuityCalculatorWithDownPayment) calculator;
            System.out.printf("Первоначальный взнос: %.2f%n", calc.getDownPayment());
        }
    }
}