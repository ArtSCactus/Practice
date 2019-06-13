/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Scanner;

/**
 *
 * @author ArtSCactus
 */
public class OneDim_06 {

    public static void doTask() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter massive size: ");
        double[] numbers = new double[in.nextInt()];
        double result = 0;
        System.out.println("Input massive elements: ");
        boolean onlyTwoDividers = true;
        for (int index = 0; index < numbers.length; index++) {
            System.out.print("Element [" + index + "](double): ");
            numbers[index] = in.nextDouble();
            for (int divider = 1; divider < index + 1; divider++) {              // 
                onlyTwoDividers = true;                                                //
                if (index % divider == 0 & divider > 1 & divider < index)    //
                {                                                                                  //
                    onlyTwoDividers = false;                                           // Check for compliance with the condition
                    break;                                                                    //
                }                                                                                 //
            }                                                                                     //
            if (onlyTwoDividers == true) {                                            // if  all compliance the conditions, it's summs current 
                result += numbers[index];                                             // number to final result
            }                                                                                     //
        }
        System.out.println("Result: " + result);
    }
}
