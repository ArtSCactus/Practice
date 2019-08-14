/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Basics;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Task condition: 3. Вычислить значение выражения по формуле (все переменные
 * принимают действительные значения): ((sin x + cos Y)/(cos x - sin y))*tg xy
 *
 * @author ArtSCactus
 */
public class Task1_3 {

    public static double task1_3(int x, int y) {
        double result = ((sin(x) + cos(y)) / (cos(x) - sin(y))) * (sin(x * y) / cos(x * y));
        return result;
    }
}
