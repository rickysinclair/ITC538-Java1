package Assignment1;

import java.util.Scanner;

/* The Assignment1.Task2 class calculates Zoo entry prices
based upon age and ticket count
*/

public class Task2 {

    // declare constant variables for ticket prices
    private final static int ACC_CHILD_PRICE = 2;
    private final static int UNACC_CHILD_PRICE = 5;
    private final static int ADULT_PRICE = 10;
    private final static int SENIOR_PRICE = 8;

    // declare private static variable
    private static int numOfChildren = 0; // number of children
    private static int numOfAdults = 0; // number of adults
    private static int numOfSeniors = 0; // number of seniors
    private static int finalTotalCost = 0; // final total cost

    // main method
    public static void main(String[] args) {

        int entry = 0; // user entry for group

        Scanner input = new Scanner(System.in); // create scanner object

        // prompt user for input
        System.out.print("Enter a group?(Yes=1/No=0): ");

        // check if input is a valid entry
        if (input.hasNextInt()) {
            entry = input.nextInt();
        } else {
            System.out.print("Error: invalid entry");   // display error if user input is not a valid value
        }

        // create while loop for group entry
        while (entry == 1) {

            // prompt user for number of children
            System.out.print("Enter the number of children (age 6-15): ");

            // check for valid input
            if (input.hasNextInt()) {
                numOfChildren += input.nextInt();
            } else {
                System.out.print("Error: invalid entry");   // display error if user input is not a valid value
            }

            // prompt user for number of adults
            System.out.print("Enter the number of adults (age 16-59): ");

            // check for valid input
            if (input.hasNextInt()) {
                numOfAdults += input.nextInt();
            } else {
                System.out.print("Error: invalid entry");   // display error if user input is not a valid value
            }

            // prompt user for number of seniors
            System.out.print("Enter the number of seniors (age 60+): ");

            // check for valid input
            if (input.hasNextInt()) {
                numOfSeniors += input.nextInt();
            } else {
                System.out.print("Error: invalid entry");   // display error if user input is not a valid value
            }

            // call cost calculator method
            costCalculator();

            // reset ticket numbers to 0
            numOfChildren = numOfAdults = numOfSeniors = 0;

            // prompt for user input
            System.out.print("\nEnter a group?(Yes=1/No=0): ");

            // check for valid input
            if (input.hasNextInt()) {
                entry = input.nextInt();
            } else {
                System.out.print("Error: invalid entry");   // display error if user input is not a valid value
            }
        }

        // display total takings (final total cost)
        System.out.println("Total takings: $" + finalTotalCost);
    }

    // cost calculator method to calculate group and final total costs
    public static void costCalculator() {

        int totalGroupCost = 0;  // initialise/reset totalGroupCost
        int accompaniedChildren;  // initialise accompaniedChildren
        int unaccompaniedChildren; // initialise unaccompaniedChildren

        // calculate totalGroupCost if there are unaccompanied children
        if ((numOfAdults + numOfSeniors) < numOfChildren) {

            // calculate number of unaccompanied children
            unaccompaniedChildren = (numOfChildren - (numOfAdults + numOfSeniors));

            // calculate number of accompanied children
            accompaniedChildren = (numOfChildren - unaccompaniedChildren);

            // calculate total group cost
            totalGroupCost += numOfSeniors * SENIOR_PRICE + numOfAdults * ADULT_PRICE
                    + unaccompaniedChildren * UNACC_CHILD_PRICE +
                    accompaniedChildren * ACC_CHILD_PRICE;

        } else { // calculate totalGroupCost if there are no unaccompanied children

            totalGroupCost += numOfSeniors * SENIOR_PRICE +
                    numOfAdults * ADULT_PRICE +
                    numOfChildren * ACC_CHILD_PRICE;
        }

        // display result
        System.out.println("Total entry charge is $" + totalGroupCost);

        // add totalGroupCost to finalTotalCost
        finalTotalCost += totalGroupCost;
    }
}
