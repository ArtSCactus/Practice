/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

/**
 *Task condition: 
 * 3. Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади
треугольника.
 * @author ArtSCactus
 */
public class Decomposition_03 {
    /** Returns a square of equilateral hexagon, by triangle sum.
     * 
     * @param sideLength
     * @return 
     */
    static double findSquare(double sideLength){
     double triangleSquare=(sideLength*sideLength*Math.sqrt(3))/4; 
     return triangleSquare*6;
    }
}
