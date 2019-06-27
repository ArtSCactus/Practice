/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Scanner;

/**
 * Task condition: 
 * 9. Даны числа X, Y, Z, Т — длины сторон четырехугольника.
 * Написать метод(методы) вычисления его площади, если угол между сторонами
 * длиной X и Y— прямой.
 *
 * @author ArtSCactus
 */
public class Decomposition_09 {

    static void methodLauncher(){
        Scanner  in = new Scanner(System.in);
        System.out.print("Enter side X: ");
        double sideX=in.nextDouble();
                System.out.print("Enter side Y: ");
        double sideY=in.nextDouble();
                System.out.print("Enter side Z: ");
        double sideZ=in.nextDouble();
                System.out.print("Enter side T: ");
        double sideT=in.nextDouble();
        System.out.println("Methods output: "+findSquare(sideX, sideY, sideZ, sideT));
    }
    /**
     * Returns a square of quadrangle, with conditions, that angle between side
     * x and side y are right.
     *
     * @param sideX
     * @param sideY
     * @param sideZ
     * @param sideT
     * @return
     */
    static double findSquare(double sideX, double sideY, double sideZ, double sideT) {
        if (sideX <= 0 || sideY <= 0 || sideZ <= 0 || sideT <= 0) {
            System.out.println("Error. Side cannot be less or equals 0.");
            return 0;
        }
        double squareOfRightTriangle = (sideX * sideY) / 2;
        double hypotenuse = Math.sqrt((sideX * sideX) + (sideY * sideY));
        double semiPerimeter = (hypotenuse + sideZ + sideT) / 2;
        double squareOfSecondTriangle = Math.sqrt(semiPerimeter * (semiPerimeter - hypotenuse) * (semiPerimeter - sideZ) * (semiPerimeter - sideT));
        return squareOfRightTriangle + squareOfSecondTriangle;
    }
}
