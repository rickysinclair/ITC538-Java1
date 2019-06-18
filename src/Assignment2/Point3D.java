package Assignment2;

public class Point3D {

    // constant variable for the base point’s coordinates Point 0
    public static final double x1 = 0;
    public static final double y1 = 0;
    public static final double z1 = 0;

    // String variables to represent the colour of text
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_BLUE = "\u001B[34m";

    // array of 10 random 3D coordinates created using the getCoord method
    public static final double[][] matrix = {
            {1, getCoord(), getCoord(), getCoord()},
            {2, getCoord(), getCoord(), getCoord()},
            {3, getCoord(), getCoord(), getCoord()},
            {4, getCoord(), getCoord(), getCoord()},
            {5, getCoord(), getCoord(), getCoord()},
            {6, getCoord(), getCoord(), getCoord()},
            {7, getCoord(), getCoord(), getCoord()},
            {8, getCoord(), getCoord(), getCoord()},
            {9, getCoord(), getCoord(), getCoord()},
            {10, getCoord(), getCoord(), getCoord()},
    };


    /**
     * This method creates a point at position (0, 0, 0) and "Red" in colour
     */
    public static void pointZero() {
        System.out.println(ANSI_RED + "Point 0: " + x1 + ", " + y1 + ", " + z1 + ANSI_RESET);
    }

    /**
     * This Method creates a test point with random coordinates
     *
     * @param coord1 random coordinate
     * @param coord2 random coordinate
     * @param coord3 random coordinate
     * @return array testPoint
     */
    public static double[] pointOne(double coord1, double coord2, double coord3) {
        double[] testPoint = {coord1, coord2, coord3}; // create array using 3 parameters
        return testPoint;
    }

    /**
     * This method creates a random double used for creating coordinates
     *
     * @return double x
     */
    public static double getCoord() {
        double x = (Math.random() - 0.5) * 20.0; // generate random double
        return (double) Math.round(x * 100) / 100; // round to 2 decimal places
    }

    /**
     * This method returns the distance between the current
     * point and another point passed as an argument.
     *
     * @param x1        random coordinate
     * @param y1        random coordinate
     * @param z1        random coordinate
     * @param testPoint 2D array
     * @return double d
     */
    public static double distance(double x1, double y1, double z1, double[] testPoint) {
        pointZero();  // print Point 0
        System.out.println(ANSI_BLUE + "Test Point: " + testPoint[0] + ", "
                + testPoint[1] + ", " + testPoint[2] + ANSI_RESET);

        // compute distance between points
        double d = Math.pow((Math.pow(testPoint[0] - x1, 2) +
                Math.pow(testPoint[1] - y1, 2) +
                Math.pow(testPoint[2] - z1, 2) * 1.0), 0.5);

        return (d);
    }

    /**
     * This method calculates the distance between point 0 and an array of points
     *
     * @param x1     random coordinate
     * @param y1     random coordinate
     * @param z1     random coordinate
     * @param matrix 2D array
     * @return array distanceArray
     */
    public static double[] distance(double x1, double y1, double z1, double[][] matrix) {
        double d = 0;
        double[] distanceArray = new double[10];

        for (int i = 0; i < matrix.length; i++) {

            double x2 = matrix[i][1]; // assign array values to x,y,z variables
            double y2 = matrix[i][2];
            double z2 = matrix[i][3];

            // compute distance between points
            d = Math.pow((Math.pow(x2 - x1, 2) +
                    Math.pow(y2 - y1, 2) +
                    Math.pow(z2 - z1, 2) * 1.0), 0.5);

            // display results with assigned colours
            pointZero();
            System.out.println(ANSI_BLUE + "Point " + (int) Math.round(matrix[i][0]) +
                    ":" + " x" + x2 + " y" + y2 + " z" + z2 + ANSI_RESET);
            System.out.println("Distance between points = " + d);
            distanceArray[i] = d;
        }
        return distanceArray;
    }

    /**
     * This method calculates the maximum distance between point 0 and an array of points
     *
     * @param x1     random coordinate
     * @param y1     random coordinate
     * @param z1     random coordinate
     * @param matrix 2D array
     * @return maxD
     */
    public static double[] maxDistance(double x1, double y1, double z1, double[][] matrix) {
        double d;
        double[] maxD = new double[2];

        for (int i = 0; i < matrix.length; i++) {

            double x2 = matrix[i][1];  // assign array values to x,y,z variables
            double y2 = matrix[i][2];
            double z2 = matrix[i][3];

            // compute distance between points
            d = Math.pow((Math.pow(x2 - x1, 2) +
                    Math.pow(y2 - y1, 2) +
                    Math.pow(z2 - z1, 2) * 1.0), 0.5);

            // check to see if result is the maximum value
            if (d > maxD[1]) {
                maxD[1] = d;
                maxD[0] = matrix[i][0];
            }
        }
        return maxD;
    }

    /**
     * This method calculates the minimum distance between point 0 and an array of points
     *
     * @param x1     random coordinate
     * @param y1     random coordinate
     * @param z1     random coordinate
     * @param matrix 2D array
     * @return minD
     */
    public static double[] minDistance(double x1, double y1, double z1, double[][] matrix) {
        double d = 0;
        double[] minD = new double[2];
        minD[1] = 100;

        for (int i = 0; i < matrix.length; i++) {

            double x2 = matrix[i][1];// assign array values to x,y,z variables
            double y2 = matrix[i][2];
            double z2 = matrix[i][3];

            // compute distance between points
            d = Math.pow((Math.pow(x2 - x1, 2) +
                    Math.pow(y2 - y1, 2) +
                    Math.pow(z2 - z1, 2) * 1.0), 0.5);

            // check to see if result is the minimum value
            if (d < minD[1]) {
                minD[1] = d;
                minD[0] = matrix[i][0];
            }
        }
        return minD;
    }

}