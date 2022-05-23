package com.olasubomi;

import java.text.NumberFormat;

public class MortgageCalculator {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;
    private  long principal;
    private float annualInterest;
    private byte years;
    private int numberOfPayments;

    public MortgageCalculator(long principal,float annualInterest,byte years) {
     this.principal = principal;
     this.annualInterest = annualInterest;
     this.years = years;
     this.numberOfPayments = years * MONTHS_IN_YEAR;
    }

    public double calculateMortgage(){
        float monthlyInterestRate = getMonthlyInterestRate(annualInterest);
        float x = 1 + monthlyInterestRate;

        System.out.println("Your principal is: " + principal +
                ",Your monthlyInterestRate is: " + monthlyInterestRate + ",Your years is: " + years +
                ".");

        Double numerator = principal * (monthlyInterestRate *
                (Math.pow( x, numberOfPayments)));
        Double denominator = Math.pow( x, numberOfPayments) - 1;
        return numerator / denominator;
    }

    public void calculatePaymentSchedule() {
        int numberOfPayments = (int)getNumberOfPayment() * (int) MONTHS_IN_YEAR;
        float monthlyInterestRate = getMonthlyInterestRate(getAnnualInterest());
        float x = 1 + monthlyInterestRate;

        double balance;
        for (int i = 1; i <= numberOfPayments; i++) {
            balance = (getPrincipal()
                    * (Math.pow(x, numberOfPayments) - Math.pow(x, i)))
                    / (Math.pow(x, numberOfPayments) - 1);
            if (balance < 0)
                break;
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    private float getMonthlyInterestRate(float annualInterest) {
        return (annualInterest / PERCENT) / MONTHS_IN_YEAR;
    }

    private float getAnnualInterest() {return annualInterest;}
    private float getPrincipal() {
        return principal;
    }
    private float getNumberOfPayment() {return numberOfPayments;}
}
