/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ArtSCactus
 */
public class OneDimSorting_08 {

    public void doTask() {
        // declaration of massives/variables and it's initialization
        Scanner in = new Scanner(System.in);
        System.out.println("Enter amount fractions (enter 0 for random size between 1 and 100): ");
        int amount;
        while (true) {
           amount = in.nextInt();
            if (amount == 0) {
                amount = 1 + (int) (Math.random() * (10 + 1));
                break;
            } else if (amount < 0) {
                System.out.println("The amount of fractions cannot be less then 0!");
            } else break;
        }
        int[] numerator = new int[amount];
        int[] denominator = new int[amount];
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
        if (inputOption == 0) {
            for (int index = 0; index < numerator.length; index++) {
                numerator[index] = 1 + (int) (Math.random() * (10 + 1));
            }
            for (int index = 0; index < denominator.length; index++) {
                denominator[index] = 1 + (int) (Math.random() * (10 + 1));
            }
        } else {
            System.out.println("Fill the element:");
            for (int index = 0; index < numerator.length; index++) {
                System.out.print("Element [" + index + "]: ");
                numerator[index] = in.nextInt();
                System.out.print("/");
                denominator[index] = in.nextInt();
                System.out.println();
            }
        }
        Arrays.sort(numerator);
        Arrays.sort(denominator);

        //  source massives output
        System.out.println("Source fractions: ");
        for (int index = 0; index < amount; index++) {
            System.out.print(numerator[index] + "/" + denominator[index] + " ");
        }
        System.out.println();

        //output by task condition
        int commonDenominator = findCommonDenominator(denominator);
        System.out.println("Common denominator: " + commonDenominator);
        for (int index = 0; index < denominator.length; index++) {
            numerator[index] *= commonDenominator / denominator[index];
            denominator[index] *= commonDenominator / denominator[index];
        }

        //  source massives output
        System.out.println("New fractions: ");
        for (int index = 0; index < amount; index++) {
            System.out.print(numerator[index] + "/" + denominator[index] + " ");
        }
        System.out.println();
    }

    /**
     * Returns the smallest common multiple among array elements.
     *
     * @param array
     * @return
     */
    public static int findCommonDenominator(int[] array) {
         int lcm = 1;
        int divider = 2;
        while (true) {
            int counter = 0;
            boolean divisible = false;

            for (int index = 0; index < array.length; index++) {

                // lcm (n1, n2, ... 0) = 0. 
                if (array[index] == 0) {
                    return 0;
                }
                if (array[index] == 1) {
                    counter++;
                }

                // Divide array by divider if complete 
                // division index without remainder then replace 
                // number with quotient; used for find next divider 
                if (array[index] % divider == 0) {
                    divisible = true;
                    array[index] = array[index] / divider;
                }
            }

            // If divider able to completely divide any number 
            // from array multiply with lcm 
            // and store into lcm and continue 
            // to same divider for next divider finding. 
            // else increment divider 
            if (divisible) {
                lcm = lcm * divider;
            } else {
                divider++;
            }

            // Check if all array is 1 indicate  
            // we found all factors and terminate while loop. 
            if (counter == array.length) {
                return lcm;
            }
        }
    }
}
