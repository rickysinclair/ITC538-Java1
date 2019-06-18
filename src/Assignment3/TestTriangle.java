package Assignment3;

public class TestTriangle {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);  // create triangle object and pass values
        triangle.setColor("yellow"); // set colour
        triangle.setFilled(true); // set filled

        // call toString method
        System.out.println("The 3 sides of the triangle are: " + triangle.toString());

        // call getArea method
        System.out.println("The area of the triangle is " + triangle.getArea());

        // call getPerimeter method
        System.out.println("The perimeter of the triangle is " + triangle.getPerimeter());

        // check if triangle if filled and call getColour function
        if (triangle.isFilled()) {
            System.out.println("The \"" + triangle.getColor() + "\" triangle is filled.");
        } else {
            System.out.println("The \"" + triangle.getColor() + "\" triangle is not filled.");
        }

    }
}
