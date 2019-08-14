/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Basics;

import static java.lang.Math.sqrt;

/**
 * Task condition: 2. Вычислить значение выражения по формуле (все переменные
 * принимают действительные значения): ((b+sqrt(b^2+4ac))/2a)-a^3c+b^-2
 *
 * @author ArtSCactus
 */
public class Task1_2 {

    /**
     * Returns the quad root from inputed number
     */
    public static double task1_2(double a, double b, double c, double z) {
        double result = ((b + sqrt(b * b + 4 * a * c)) / (2 * a)) - a * a * a * c + (1 / (b * b));
        return result;
    }
}
