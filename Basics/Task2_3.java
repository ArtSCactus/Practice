/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Basics;

/**
 * Task condition: 3. Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить,
 * будут ли они расположены на одной прямой.
 *
 * @author ArtSCactus
 */
public class Task2_3 {

    public static boolean task2_3(int x1, int y1, int x2, int y2, int x3, int y3) {
        if (x1 == x2 & x2 == x3) {
            return true;
        } else {
            if (y1 == y2 & y2 == y3) {
                return true;
            } else {
                return false;
            }
        }
    }
}
