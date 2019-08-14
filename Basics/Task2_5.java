/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Basics;

/**
 * Task condition:5. Вычислить значение функции: 
 * f(x)= x^2-3x+9 если x меньше или равно 3 
 * f(x)=1/(x^3+6) если x>3
 *
 * @author ArtSCactus
 */
public class Task2_5 {

    public static int task2_5(int x) {
        int result = 0;
        if (x == 3) {
            result = x * x - 3 * x + 9;
        } else {
            result = 1 / (x * x * x + 6);
        }
        return result;
    }
}
