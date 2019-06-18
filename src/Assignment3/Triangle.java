package Assignment3;

public class Triangle extends GeometricObject {
    // declare side double values
    private double side1 = 1.0, side2 = 1.0, side3 = 1.0;

    /**
     * Default construct
     */
    public Triangle() {
    }

    /**
     * Construct a triangle object
     *
     * @param side1 double
     * @param side2 double
     * @param side3 double
     */
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /**
     * The getArea method returns the area of this triangle
     *
     * @return area double
     */
    public double getArea() {
        double p = getPerimeter(); // call perimeter function to set p value
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3)); // calculate area
    }

    /**
     * The getPerimeter method returns the perimeter of this triangle.
     *
     * @return perimeter double
     */
    public double getPerimeter() {
        return (side1 + side2 + side3) / 2; // calculate perimeter
    }

    /**
     * The toString method returns a string description for the triangle.
     *
     * @return sides String
     */
    public String toString() {
        return side1 + " " + side2 + " " + side3;
    }
}
