package com.olasubomi;
import com.olasubomi.Console;
import com.olasubomi.MortgageReport;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        long principal;
        float annualInterest;
        byte years;

//        principal = (long) Console.readNumber("principal: ");
        principal =  (long) Console.readNumber("principal: ", 1000, 1000000  );
        annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 0, 30);
        years = (byte) Console.readNumber("Period (Years): ", 0, 30);

        var calculator = new MortgageCalculator(principal,annualInterest,years);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }
}
