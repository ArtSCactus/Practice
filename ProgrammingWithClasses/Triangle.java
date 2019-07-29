/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses;

/**
 * Task condition: 7. Описать класс, представляющий треугольник. Предусмотреть
 * методы для создания объектов, вычисления площади, периметра и точки
 * пересечения медиан.
 *
 * @author ArtSCactus
 */
public class Triangle {

    private double firstSide;
    private double secondSide;
    private double thirdSide;
    private double semiPerimeter;

    /**
     * Constructs new triangle with given sides, and automaticly calculating its
     * semiPerimeter.
     *
     * @param firstSide
     * @param secondSide
     * @param thirdSide
     */
    public Triangle(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
        semiPerimeter = (firstSide + secondSide + thirdSide) / 3;
    }

    /**
     * Calling constructor of Triangle class and returning its object.
     *
     * @param firstSide
     * @param secondSide
     * @param thirdSide
     * @return
     */
    public Triangle createTriangle(double firstSide, double secondSide, double thirdSide) {
        return new Triangle(firstSide, secondSide, thirdSide);
    }

    /**
     * Calculating square of current object.
     *
     * @return
     */
    public double getSquare() {
        return Math.sqrt(semiPerimeter * (semiPerimeter - firstSide) * (semiPerimeter - secondSide) * (semiPerimeter - thirdSide));
    }

    /**
     * Calculating square of triangle with given sides.
     *
     * @param sideOne
     * @param sideTwo
     * @param sideThree
     * @return
     */
    public static double getSquare(double sideOne, double sideTwo, double sideThree) {
        double semiPer = getPerimeter(sideOne, sideTwo, sideThree) / 2;
        return Math.sqrt(semiPer * (semiPer - sideOne) * (semiPer - sideTwo) * (semiPer - sideThree));
    }

    /**
     * Calculating perimeter with given sides.
     *
     * @param firstSide
     * @param secondSide
     * @param thirdSide
     * @return
     */
    public static double getPerimeter(double firstSide, double secondSide, double thirdSide) {
        return firstSide + secondSide + thirdSide;
    }

    /**
     * Returns primeter of current Triangle object.
     *
     * @return
     */
    public double getPerimeter() {
        return firstSide + secondSide + thirdSide;
    }

    /**
     * Printing to console point of median cross with given vertex coordinates.
     * For example A(x1,y1), B(x2,y2), C(x3,y3).
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     */
    public static void findMedianCrossPoint(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Yes, i know that var. name like x1 y1 is not correct, but I see no reason to call the full name. 
        //Ideally, transfer 3 Point class objects, where each object consist 2 point (x and y). 
        //Рowever, the task to describe the class Point in front of me is not worth it
        double xPoint = (x1 + x2 + x3) / 3;
        double yPoint = (y1 + y2 + y3) / 3;
        System.out.print("Point on X: " + xPoint + "\nPoint on y: " + yPoint);
    }
}
