package org.launchcode.java.studios.areaofcircle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Area {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double radius = 0.0;
        boolean validRadius;
        do {
            validRadius = true;
            try {
                System.out.print("Enter a radius: ");
                radius = Double.parseDouble(in.nextLine());
                if (radius < 0) throw new InputMismatchException("Value cannot be negative");
            } catch (Exception exception) {
                System.out.println("The radius must be a positive double value.");
                validRadius = false;
            }
        } while(!validRadius);

        System.out.println("The area of a circle of radius" + radius + " is: " + Circle.getArea(radius));
    }
}
