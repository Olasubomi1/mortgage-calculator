package com.olasubomi;

import java.text.NumberFormat;

public class MortgageReport {
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator){
        this.calculator = calculator;
    }

    public void printMortgage() {
        Double mortgage = calculator.calculateMortgage();
        String Mortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Your Mortgage is: " + Mortgage);
    }
    public void printPaymentSchedule() {
         calculator.calculatePaymentSchedule();
    }

}
