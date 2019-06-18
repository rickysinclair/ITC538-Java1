package Assignment1;

import java.util.Scanner;

/* The Task1 class calculates personal income tax
based upon filing status and taxable income.
*/

public class Task1 {

    // declare constant variables for tax rates
    final private static double TAX_RATE1 = 0.10;
    final private static double TAX_RATE2 = 0.15;
    final private static double TAX_RATE3 = 0.25;
    final private static double TAX_RATE4 = 0.28;
    final private static double TAX_RATE5 = 0.33;
    final private static double TAX_RATE6 = 0.35;

    private static int status; // declare status variable
    private static double income; // declare income variable
    private static double tax;  // declare tax variable

    // main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // create scanner object

        // prompt user for filing status
        System.out.print("Enter the filing status: ");

        // check if the user input is an int
        if (input.hasNextInt()) {
            status = input.nextInt();
        } else {
            System.out.println("Error: invalid status");  // display error if user input is not an int
            System.exit(1);
        }

        // prompt user for taxable income
        System.out.print("Enter the taxable income: ");

        // check if the user input is an int
        if (input.hasNextInt()) {
            income = input.nextInt();
        } else {
            System.out.println("Error: invalid income");  // display error if user input is not an int
            System.exit(1);
        }

        // call method based upon filing status
        if (status == 0) {
            singleFile();
        } else if (status == 1) {
            marriedFileJoint();
        } else if (status == 2) {
            marriedFileSeparate();
        } else if (status == 3) {
            headOfHouse();
        } else {
            System.out.println("Error: invalid status"); // display error if user input is not a valid value
            System.exit(1);
        }
    }

    // single filing method
    private static void singleFile() {

        // calculate tax
        if (income <= 8350) {
            tax = income * TAX_RATE1;
        } else if (income <= 33950) {
            tax = 8350 * TAX_RATE1 + (income - 8350) * TAX_RATE2;
        } else if (income <= 82250) {
            tax = 8350 * TAX_RATE1 + (33950 - 8350) * TAX_RATE2 +
                    (income - 33950) * TAX_RATE3;
        } else if (income <= 171550) {
            tax = 8350 * TAX_RATE1 + (33950 - 8350) * TAX_RATE2 +
                    (82250 - 33950) * TAX_RATE3 + (income - 82250) * TAX_RATE4;
        } else if (income <= 372950) {
            tax = 8350 * TAX_RATE1 + (33950 - 8350) * TAX_RATE2 +
                    (82250 - 33950) * TAX_RATE3 + (171550 - 82250) * TAX_RATE4 +
                    (income - 171550) * TAX_RATE5;
        } else if (income >= 372951) {
            tax = 8350 * TAX_RATE1 + (33950 - 8350) * TAX_RATE2 +
                    (82250 - 33950) * TAX_RATE3 + (171550 - 82250) * TAX_RATE4 +
                    (372951 - 171550) * TAX_RATE5 + (income - 372950) * TAX_RATE6;
        } else {
            System.out.println("Error: invalid income"); // display error if user input is not a valid value
            System.exit(1);
        }
        System.out.println("Tax is " + tax); // display results
    }

    // married filing jointly method
    private static void marriedFileJoint() {

        // calculate tax
        if (income <= 16700) {
            tax = income * TAX_RATE1;
        } else if (income <= 67900) {
            tax = 16700 * TAX_RATE1 + (income - 16700) * TAX_RATE2;
        } else if (income <= 137050) {
            tax = 16700 * TAX_RATE1 + (67900 - 16700) * TAX_RATE2 +
                    (income - 67900) * TAX_RATE3;
        } else if (income <= 208850) {
            tax = 16700 * TAX_RATE1 + (67900 - 16700) * TAX_RATE2 +
                    (137050 - 67900) * TAX_RATE3 + (income - 137050) * TAX_RATE4;
        } else if (income <= 372950) {
            tax = 16700 * TAX_RATE1 + (67900 - 16700) * TAX_RATE2 +
                    (137050 - 67900) * TAX_RATE3 + (208850 - 137050) * TAX_RATE4 +
                    (income - 208850) * TAX_RATE5;
        } else if (income >= 372951) {
            tax = 16700 * TAX_RATE1 + (67900 - 16700) * TAX_RATE2 +
                    (137050 - 67900) * TAX_RATE3 + (208850 - 137050) * TAX_RATE4 +
                    (372950 - 208850) * TAX_RATE5 + (income - 372951) * TAX_RATE6;
        } else {
            System.out.println("Error: invalid income");  // display error if user input is not a valid value
            System.exit(1);
        }
        System.out.println("Tax is " + tax); //display results
    }

    // married filing separately method
    private static void marriedFileSeparate() {

        //calculate tax
        if (income <= 8350) {
            tax = income * TAX_RATE1;
        } else if (income <= 33950) {
            tax = 8350 * TAX_RATE1 + (income - 8350) * TAX_RATE2;
        } else if (income <= 68525) {
            tax = 8350 * TAX_RATE1 + (33950 - 8350) * TAX_RATE2 +
                    (income - 33950) * TAX_RATE3;
        } else if (income <= 104425) {
            tax = 8350 * TAX_RATE1 + (33950 - 8350) * TAX_RATE2 +
                    (68525 - 33950) * TAX_RATE3 + (income - 68525) * TAX_RATE4;
        } else if (income <= 186475) {
            tax = 8350 * TAX_RATE1 + (33950 - 8350) * TAX_RATE2 +
                    (68525 - 33950) * TAX_RATE3 + (104425 - 68525) * TAX_RATE4 +
                    (income - 104425) * TAX_RATE5;
        } else if (income >= 186476) {
            tax = 8350 * TAX_RATE1 + (33950 - 8350) * TAX_RATE2 +
                    (68525 - 33950) * TAX_RATE3 + (104425 - 68525) * TAX_RATE4 +
                    (186475 - 104425) * TAX_RATE5 + (income - 186475) * TAX_RATE6;
        } else {
            System.out.println("Error: invalid income"); // display error if user input is not a valid value
            System.exit(1);
        }
        System.out.println("Tax is " + tax); // display results
    }

    // head of house method
    private static void headOfHouse() {

        // calculate tax
        if (income <= 11950) {
            tax = income * TAX_RATE1;
        } else if (income <= 45500) {
            tax = 11950 * TAX_RATE1 + (income - 11950) * TAX_RATE2;
        } else if (income <= 117450) {
            tax = 11950 * TAX_RATE1 + (45500 - 11950) * TAX_RATE2 +
                    (income - 45500) * TAX_RATE3;
        } else if (income <= 190200) {
            tax = 11950 * TAX_RATE1 + (45500 - 11950) * TAX_RATE2 +
                    (117450 - 45500) * TAX_RATE3 + (income - 117450) * TAX_RATE4;
        } else if (income <= 372950) {
            tax = 11950 * TAX_RATE1 + (45500 - 11950) * TAX_RATE2 +
                    (117450 - 45500) * TAX_RATE3 + (190200 - 117450) * TAX_RATE4 +
                    (income - 190200) * TAX_RATE5;
        } else if (income >= 372951) {
            tax = 11950 * TAX_RATE1 + (45500 - 11950) * TAX_RATE2 +
                    (117450 - 45500) * TAX_RATE3 + (190200 - 117450) * TAX_RATE4 +
                    (372950 - 190200) * TAX_RATE5 + (income - 372950) * TAX_RATE6;
        } else {
            System.out.println("Error: invalid income");  // display error if user input is not a valid value
            System.exit(1);
        }
        System.out.println("Tax is " + tax);  // display results
    }

}
