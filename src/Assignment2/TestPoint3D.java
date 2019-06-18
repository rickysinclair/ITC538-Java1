package Assignment2;

import java.util.Scanner;

public class TestPoint3D {

    // String variable to represent the colour of text
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";


    /**
     * This is the main method which makes use of the distance, pointOne, getCoord,
     * maxDistance and minDistance methods from the Point3D class.
     *
     * @param args not used
     */
    public static void main(String[] args) {

        // calculates the distance between the two test points
        System.out.println(ANSI_YELLOW + "Calculate the distance between two test points" + ANSI_RESET);
        System.out.println("Distance between points = " +
                Point3D.distance(Point3D.x1, Point3D.y1, Point3D.z1,
                        Point3D.pointOne(Point3D.getCoord(), Point3D.getCoord(), Point3D.getCoord())) + "\n");

        // calculates the distance between the 10 different points and point zero
        System.out.println(ANSI_YELLOW + "Calculate the distance between 10 different points" + ANSI_RESET);
        Point3D.distance(Point3D.x1, Point3D.y1, Point3D.z1, Point3D.matrix);

        // calculates the maximum distance from point zero is to the 10 different points
        double[] maxResult = Point3D.maxDistance(Point3D.x1, Point3D.y1, Point3D.z1, Point3D.matrix);
        System.out.print("\nThe Maximum distance is from Point 0 to Point " +
                Math.round(maxResult[0]) + ": " + maxResult[1]);

        // calculates the minimum distance from point zero is to the 10 different points
        double[] minResult = Point3D.minDistance(Point3D.x1, Point3D.y1, Point3D.z1, Point3D.matrix);
        System.out.println("\n\nThe Minimum distance is from Point 0 to Point " +
                Math.round(minResult[0]) + ": " + minResult[1]);

        // keep console open until user closes
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }
}
