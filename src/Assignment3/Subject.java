package Assignment3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Subject {

    // initialise Array Lists
    public ArrayList<String> disciplineList = new ArrayList<>();
    private ArrayList<String> subCodeList = new ArrayList<>();
    private ArrayList<String> subNameList = new ArrayList<>();
    private ArrayList<String> subCodeArr = new ArrayList<>();
    private ArrayList<String> subNameArr = new ArrayList<>();
    public List<String> list = new ArrayList<>();

    // initialise String variable
    private String subName;
    private String subCode;


    /**
     * This setSubName method sets the Subject Name
     */
    public void setSubName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a subject name: ");
        subName = input.nextLine();
    }

    /**
     * This setSubCode method sets the Subject Code
     */
    public void setSubCode() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a subject code. 3 letters " +
                "followed by 3 integers e.g ABC123: ");
        subCode = input.nextLine();
    }

    /**
     * This getSubName method returns the Subject Name
     * @return subName String
     */
    public String getSubName() {
        return subName;
    }

    /**
     * This getSubCode method returns the Subject Code
     * @return subCode String
     */
    public String getSubCode() {
        return subCode;
    }

    /**
     * This getDiscipline method returns the Discipline Code extracted
     * from the first 3 characters of the Subject Code
     * @return subCode String
     */
    public String getDiscipline() {
        return subCode.substring(0, 3); // extract first 3 characters
    }

    /**
     * This getString method concatenates the Discipline Code,
     * Subject Code and Subject Name into a single String
     * @return String
     */
    public String getString() {
        return getDiscipline() + ":" + getSubCode() + ":" + getSubName();
    }

    /**
     * This createArrays method reads the txt file and creates
     * several ArrayLists from the data in the txt file
     * @throws Exception
     */
    public void createArrays() throws Exception {
        disciplineList.clear(); // clear all current list arrays
        subCodeList.clear();
        subNameList.clear();
        list.clear();

        // create a file reader object from the txt file
        BufferedReader br = new BufferedReader(new FileReader("src/myInput.txt"));
        String currentLine;

        // add data from txt file to list array
        while ((currentLine = br.readLine()) != null) {
            list.add(currentLine);
        }

        Collections.sort(list);  // sort the list

        // split the list array and add items to their respective lists
        for (int i = 0; i < list.size(); i++) {
            String[] lineSplitArray = list.get(i).split(":");
            disciplineList.add(i, lineSplitArray[0]);
            subCodeList.add(i, lineSplitArray[1]);
            subNameList.add(i, lineSplitArray[2]);
        }
        br.close();  // free the resource
    }

    /**
     * This codeMatches method checks if the target value
     * is contained in the subCodeList
     * @param targetValue String
     * @return result boolean
     */
    public boolean codeMatches(String targetValue) {
        boolean result = false;
        // check if subCodeList contains the targetValue
        if (subCodeList.contains(targetValue)) {
            result = true;
        }
        return result;
    }

    /**
     * This getAllDisciplines method checks for duplicate discipline
     * codes and returns an ArrayList with no duplicates
     * @return sortedDisciplineCodes ArrayList
     */
    public ArrayList<String> getAllDisciplines() {
        // create new list array
        ArrayList<String> sortedDisciplineCodes = new ArrayList<>();

        // loop through the discipline code list
        for (String i : disciplineList) {
            // add it to the new list
            if (!sortedDisciplineCodes.contains(i)) {
                sortedDisciplineCodes.add(i);
            }
        }
        return sortedDisciplineCodes;
    }

    /**
     * This codesPerDiscipline method searches the disciplineList
     * based upon user input and returns an ArrayList of Subject Codes
     * that match the user input
     * @param search String
     * @return disciplineCodeMatches ArrayList
     */
    public ArrayList<String> codesPerDiscipline(String search) {
        // create new ArrayList
        ArrayList<String> disciplineCodeMatches = new ArrayList<>();

        // loop through discipline code list
        for (int i = 0; i < disciplineList.size(); i++) {
            if (disciplineList.get(i).equals(search)) {
                // add matching values to new list
                disciplineCodeMatches.add(subCodeList.get(i));
            }
        }
        return disciplineCodeMatches;
    }

    /**
     * This isValidCode method checks if the user entered code is valid
     * @param code String
     * @return result boolean
     */
    public boolean isValidCode(String code) {
        boolean result;

        try {
            // check if code matches alphanumeric "ABC123" structure
            if (!code.matches("[a-zA-Z]{3}.*[0-9]{3}")) {
                throw new NumberFormatException();
            }
            // check if code matches length limit
            if (code.length() != 6) {
                throw new NullPointerException();
            }
            result = true;
        } catch (NumberFormatException | NullPointerException ex) {
            result = false;
        }

        // if code is valid add it to the subCodeArr ArrayList
        subCodeArr.add(code);
        return result;
    }

    /**
     * This updateList method writes the data to the txt file
     * @throws IOException
     */
    public void updateList() throws IOException {

        new PrintWriter("src/myInput.txt").close();

        // creates a txt file object
        File file = new File("src/myInput.txt");

        // create a file writer object with txt file
        FileWriter fileWriter = new FileWriter(file);

        // create a file object of the file writer
        BufferedWriter writer = new BufferedWriter(fileWriter);

        // write data to file
        for (String line : list) {
            writer.write(line + "\n");
        }
        writer.close(); // free the resource
    }
}
