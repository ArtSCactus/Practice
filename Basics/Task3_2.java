/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Basics;

/**
 *Task condition:
 * 2. Вычислить значения функции на отрезке [а,b] c шагом h:
 * y=x if x>2
 * y=-x if x<=2
 * @author ArtSCactus
 */
public class Task3_2 {
    public static void task3_2(int downLimit, int upLimit, int step){
        for (int iterator=downLimit; iterator<=upLimit; iterator+=step)
            if (iterator>2) System.out.println("y["+iterator+"]: "+iterator);
            else System.out.println("y["+iterator+"]: "+(-iterator));
    }
}
