package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first date in the format MM-DD-YYYY:");
        String date1 = sc.next();
        System.out.println("Enter second date in the format MM-DD-YYYY:");
        String date2 = sc.next();


        int month1 = Integer.parseInt(date1.substring(0,2));
        int day1 = Integer.parseInt(date1.substring(3,5));
        int year1 = Integer.parseInt(date1.substring(6));

        int month2 = Integer.parseInt(date2.substring(0,2));
        int day2 = Integer.parseInt(date2.substring(3,5));
        int year2 = Integer.parseInt(date2.substring(6));

        int yearDiff;
        int monthDiff;
        int dayDiff;

        //differences
        boolean date1Later;
        if (year1 < year2){
            yearDiff = year2-year1;
            monthDiff = month2-month1;
            dayDiff = day2-day1;
            date1Later = false;
        }
        else if (year1 > year2) {
            yearDiff = year1-year2;
            monthDiff = month1-month2;
            dayDiff = day1-day2;
            date1Later = true;
        }
        else if (month1 < month2) {
            yearDiff = 0;
            monthDiff = month2 - month1;
            dayDiff = day2 - day1;
            date1Later = false;
        }
        else if (month1 > month2) {
            yearDiff = 0;
            monthDiff = month1 - month2;
            dayDiff = day1 - day2;
            date1Later = true;
        }
        else if (day1 < day2) {
            yearDiff = 0;
            monthDiff = 0;
            dayDiff = day2 - day1;
            date1Later = false;
        }
        else {
            yearDiff = 0;
            monthDiff = 0;
            dayDiff = day1 - day2;
            date1Later = true;
        }

        //fix remainders
        if (dayDiff < 0){
            int monthToUse;
            monthDiff = monthDiff - 1;
            if (date1Later) {
                monthToUse = month1 - 1;
            }
            else {
                monthToUse = month2 - 1;
            }

            if (monthToUse == 1 || monthToUse == 3 || monthToUse == 5 || monthToUse == 7
                || monthToUse == 8 || monthToUse == 10 || monthToUse == 0) {
                dayDiff = dayDiff + 31;
            }
            else if (monthToUse == 4 || monthToUse == 6 || monthToUse == 9 || monthToUse == 11) {
                dayDiff = dayDiff + 30;
            }
            else {
                dayDiff = dayDiff + 28;
            }
        }

        if (monthDiff < 0){
            yearDiff = yearDiff - 1;
            monthDiff = monthDiff + 12;
        }

        System.out.println("The difference is " + dayDiff + " days, " + monthDiff + " months, and " + yearDiff + " years.");
    }
}
