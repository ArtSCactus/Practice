/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Basics;

import java.util.ArrayList;

/**
 *
 * @author ArtSCactus
 */
public class Task3_8 {
    public static void task3_8(int firstNumber, int secondNumber){
        System.out.print("Numerals, that both numbers consist: ");
        ArrayList<Integer> numerals = new ArrayList();
        int buffer=0;
        int currentNumeral=0;
        int currentNumeral2=0;
        while (firstNumber>1){
          currentNumeral= firstNumber%10;
          buffer=secondNumber;
            while(buffer>1)
            {
               currentNumeral2=buffer%10;
                if (currentNumeral==currentNumeral2) 
                if (!numerals.contains(currentNumeral)) numerals.add(currentNumeral);
                  buffer/=10;
            }
            firstNumber/=10;
        }
        for (Integer item : numerals)
            System.out.print(item+" ");
        System.out.println();
    }
}
