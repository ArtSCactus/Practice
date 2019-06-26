/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Scanner;

/**
 * Task condition: 4. На плоскости заданы своими координатами n точек. Написать
 * метод(методы), определяющие, между какими из пар точек самое большое
 * расстояние. Указание. Координаты точек занести в массив.
 *
 * @author ArtSCactus
 */
public class Decomposition_04 {

    static void launcherForMethod() {
        // declaration of massives/variables and it's initialization
        Scanner in = new Scanner(System.in);
        System.out.println("Enter amount of points (enter 0 for random amount between 1 and 100): ");
        int amountOfCoordinates;
        while (true) {
            amountOfCoordinates = in.nextInt();
            if (amountOfCoordinates == 0) {
                amountOfCoordinates = 1 + (int) (Math.random() * (100 + 1));
                amountOfCoordinates *= 2;
                break;
            } else if (amountOfCoordinates < 0) {
                System.out.println("The massive size cannot be less then 0!");
            } else {
                amountOfCoordinates *= 2;
                break;
            }
        }
        double[] coordinates = new double[amountOfCoordinates];
        System.out.println("0 - Auto filling\n1 - Manual filling");
        int inputOption;
        while (true) {
            inputOption = in.nextInt();
            if (inputOption == 0 || inputOption == 1) {
                break;
            } else {
                System.out.println("Please, choose 0 or 1, that's important!");
            }
        }
        int pointCounter = 1;
        if (inputOption == 0) {
            for (int index = 0; index < coordinates.length; index++) {
                coordinates[index] = 0 + (int) (Math.random() * (100 + 1));
            }
        } else {
            System.out.println("Fill the coordinates:");
            for (int index = 0; index < coordinates.length; index += 2) {
                System.out.print("X[" + pointCounter + "]: ");
                coordinates[index] = in.nextInt();
                System.out.print("\nY[" + pointCounter + "]: ");
                coordinates[index + 1] = in.nextInt();
                pointCounter++;
            }
        }
        //  source massives output
        pointCounter = 1;
        System.out.println("Source coordinatese: ");
        for (int index = 0; index < amountOfCoordinates; index += 2) {
            System.out.print("X[" + pointCounter + "]: " + coordinates[index] + "; Y[" + pointCounter + "]: " + coordinates[(index + 1)] + "\n");
            pointCounter++;
        }
        System.out.println("\nMethods output: " + findMaxDistance(coordinates));
    }

    /**
     * Returns the maximal distance between two point from gived massive.
     *
     * @param coordinates
     * @return
     */
    static double findMaxDistance(double[] coordinates) {
        if (coordinates.length % 2 != 0) {
            System.out.println("Error. One of coordinates of point are missed");
            return 0;
        } else if (coordinates.length == 2) {
            System.out.println("There's only one point.");
            return 0;
        }

        double currentDistance = 0;
        double theBiggestDistance = Integer.MIN_VALUE;
        int pointCounterMain = 1;
        int pointCounterAdd = 1;
        int pointOneSaver = 0;
        int pointTwoSaver = 0;
        for (int mainPoint = 0; mainPoint < coordinates.length; mainPoint += 2) {
            for (int currentPoint = 0; currentPoint < coordinates.length; currentPoint += 2) {
                currentDistance = Math.sqrt(Math.pow((coordinates[mainPoint] - coordinates[currentPoint]), 2) + Math.pow((coordinates[mainPoint + 1] - coordinates[currentPoint + 1]), 2));
                if (currentDistance > theBiggestDistance) {
                    theBiggestDistance = currentDistance;
                    pointOneSaver = pointCounterMain;
                    pointTwoSaver = pointCounterAdd;
                }
                pointCounterAdd++;
            }
            pointCounterMain++;
            pointCounterAdd = 1;
        }
        System.out.println("The biggest distance between point " + pointOneSaver + " and point " + pointTwoSaver + ": " + theBiggestDistance);
        return theBiggestDistance;
    }
}
