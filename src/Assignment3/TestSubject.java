package Assignment3;

import java.util.Scanner;

public class TestSubject {
    /**
     * The main method is the starting point for the program Subject List program.
     * This program allows the user to add one or more new subjects to a list array.
     * If the user wishes to add new subjects, the discipline areas of existing subjects
     * are be displayed in alphabetically order.
     * The user then enters a discipline code to which the program will respond by displaying
     * any existing subject codes in that discipline.
     * Each subject code entered by the user should is checked for structural validity.
     * The user can enter any new subjects in existing disciplines or in other disciplines.
     * The user is then given the choice of repeating the processing for other disciplines.
     * When the user has finished adding subjects, the program will overwrite the data file
     * with the updated data.
     *
     * @param args String
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Subject subject = new Subject();  // create subject object
        Scanner input = new Scanner(System.in); // create scanner
        String str = "_____"; // String of characters for formatting
        String underline; // String of characters for formatting

        while (true) {

            subject.createArrays();  // create initial array lists for use
            underline = str.repeat(subject.disciplineList.size()); // underline for formatting
            System.out.print("Do you wish to enter a new subject? y/n: ");
            String ans = input.nextLine();

            if (ans.equals("y")) {

                System.out.println(underline);
                System.out.println("The list of current disciplines.");
                System.out.println(subject.getAllDisciplines()); // display discipline codes
                System.out.println(underline);

                System.out.print("Enter the 3 digit discipline code for the the subject you are creating: ");
                String code = input.nextLine();
                System.out.println("The following subject codes have already been assigned to that discipline \n" +
                        subject.codesPerDiscipline(code)); // display matching discipline codes

                while (true) {
                    subject.setSubCode();  // call subject code setter
                    if (subject.codeMatches(subject.getSubCode())) {  // check for matching code error
                        System.out.println("This subject code is already in use.");
                    } else if (!subject.isValidCode(subject.getSubCode())) {  // check for invalid code error
                        System.out.println("This is not a valid subject code.");
                    } else {
                        subject.setSubName();  // call subject name setter
                        subject.list.add(subject.getString()); // add subject string to array list
                        break;
                    }
                }
            } else if (ans.equals("n")) {
                System.out.println("Thank you, goodbye!");
                input.nextLine();  // leave console open until user closes
                break;
            } else {
                System.out.println("That is not a valid selection.");
            }
            subject.updateList();  // update txt file and save data
        }
        //System.out.println(subject.list);  // display all subject in list
    }
}
