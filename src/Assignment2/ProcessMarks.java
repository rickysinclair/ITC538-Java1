package Assignment2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProcessMarks {
    public static void main(String[] args) {
        System.out.println("Welcome to the Marks processing program.");
        System.out.println("The maximum mark is: " + max(Marks.getMarks()));
        System.out.println("The minimum mark is: " + min(Marks.getMarks()));
        System.out.println("The range of the marks is: " + range(Marks.getMarks()));
        System.out.printf("The mean of the marks is: %.2f", mean(Marks.getMarks()));
        System.out.println("\nThe median of the marks is: " + median(Marks.getMarks()));
        System.out.println("The mode of the marks is: " + mode(Marks.getMarks()));
        System.out.println("The corresponding grades for the marks are: ");
        char[] charGrades = grades(Marks.getMarks());
        System.out.println("The grade distribution for the marks are: ");
        gradeDistn(charGrades);

        // keep console open until user closes
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }

    /**
     * This method receives an array of integers and
     * returns the maximum value from the array
     *
     * @param getMarks int array
     * @return int maxNum
     */
    public static int max(int[] getMarks) {

        int maxNum = getMarks[0];

        for (int i : getMarks) {
            if (getMarks[i] > maxNum) {
                maxNum = getMarks[i];
            }
        }
        return maxNum;
    }

    /**
     * This method receives an array of integers and
     * returns the minimum value from the array
     *
     * @param getMarks int array
     * @return int minNum
     */
    public static int min(int[] getMarks) {

        int minNum = getMarks[0];

        for (int i : getMarks) {
            if (getMarks[i] < minNum) {
                minNum = getMarks[i];
            }
        }
        return minNum;
    }

    /**
     * This method receives an array of integers and
     * returns the range of the array
     *
     * @param getMarks int array
     * @return int range
     */
    public static int range(int[] getMarks) {
        return max(getMarks) - min(getMarks);
    }

    /**
     * This method receives an array of integers and
     * returns the mean of the array
     *
     * @param getMarks int array
     * @return double mean (sum / count)
     */
    public static double mean(int[] getMarks) {

        int sum = 0;
        double count = 0;

        for (int i = 0; i < getMarks.length; i++) {
            sum += getMarks[i];
            count = i;
        }
        return sum / count;
    }

    /**
     * This method receives an array of integers and
     * returns the median of the array
     *
     * @param getMarks int array
     * @return double median
     */
    public static double median(int[] getMarks) {

        double median;
        int[] marks = new int[getMarks.length];
        System.arraycopy(getMarks, 0, marks, 0, getMarks.length);
        Arrays.sort(marks);

        // check for even number of marks
        if (marks.length % 2 == 0) {
            median = ((double) marks[marks.length / 2] +
                    (double) marks[marks.length / 2 - 1]) / 2;
        } else {
            median = (double) marks[marks.length / 2];
        }
        return median;
    }

    /**
     * This method receives an array of integers and
     * returns the mode of the array
     *
     * @param getMarks int array
     * @return int maxValue
     */
    public static int mode(int[] getMarks) {

        int maxValue = 0;
        int maxCount = 0;

        for (int i : getMarks) {
            int count = 0;
            for (int j : getMarks) {
                if (getMarks[j] == getMarks[i]) ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = getMarks[i];
            }
        }
        return maxValue;
    }

    /**
     * This method receives an array of integers and
     * returns an array of characters based upon a grade scale
     *
     * @param getMarks int array
     * @return charGrade char array
     */
    public static char[] grades(int[] getMarks) {

        int[] gradeA = IntStream.rangeClosed(90, 100).toArray();
        int[] gradeB = IntStream.rangeClosed(75, 89).toArray();
        int[] gradeC = IntStream.rangeClosed(60, 74).toArray();
        int[] gradeD = IntStream.rangeClosed(51, 59).toArray();
        int[] gradeE = IntStream.rangeClosed(45, 50).toArray();
        //int[] gradeF = IntStream.rangeClosed(0, 44).toArray();

        char[] charGrade = new char[getMarks.length];
        int charCount = 0;
        int gradeCount = 1;

        for (int i : getMarks) {
            int key = getMarks[i];
            if (gradeCount == 11) {
                System.out.println();
                gradeCount = 1;
            }
            if (Arrays.stream(gradeA).anyMatch(j -> j == key)) {
                System.out.print("A - " + getMarks[i] + " ");
                charGrade[charCount] = 'A';
            } else if (Arrays.stream(gradeB).anyMatch(j -> j == key)) {
                System.out.print("B - " + getMarks[i] + " ");
                charGrade[charCount] = 'B';
            } else if (Arrays.stream(gradeC).anyMatch(j -> j == key)) {
                System.out.print("C - " + getMarks[i] + " ");
                charGrade[charCount] = 'C';
            } else if (Arrays.stream(gradeD).anyMatch(j -> j == key)) {
                System.out.print("D - " + getMarks[i] + " ");
                charGrade[charCount] = 'D';
            } else if (Arrays.stream(gradeE).anyMatch(j -> j == key)) {
                System.out.print("E - " + getMarks[i] + " ");
                charGrade[charCount] = 'E';
            } else {
                System.out.print("F - " + getMarks[i] + " ");
                charGrade[charCount] = 'F';
            }
            charCount++;
            gradeCount++;
        }
        System.out.println();
        return charGrade;
    }

    /**
     * This method receives an array of characters and
     * prints the count for each grade level A-F
     *
     * @param grade char array
     */
    public static void gradeDistn(char[] grade) {

        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int dCount = 0;
        int eCount = 0;
        int fCount = 0;

        for (int i = 0; i < grade.length; i++) {
            if (grade[i] == 'A') {
                aCount++;
            } else if (grade[i] == 'B') {
                bCount++;
            } else if (grade[i] == 'C') {
                cCount++;
            } else if (grade[i] == 'D') {
                dCount++;
            } else if (grade[i] == 'E') {
                eCount++;
            } else {
                fCount++;
            }
        }

        System.out.println("A: " + aCount);
        System.out.println("B: " + bCount);
        System.out.println("C: " + cCount);
        System.out.println("D: " + dCount);
        System.out.println("E: " + eCount);
        System.out.println("F: " + fCount);

    }
}
