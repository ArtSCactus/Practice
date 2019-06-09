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
public class OneDim_02 {
   public static void  doTask(){
               Scanner in = new Scanner(System.in);
       System.out.println("Enter number Z: ");
       int numberZ = in.nextInt();
        System.out.println("Enter the row size: ");
        int[] row = new int[in.nextInt()];
        for (int index =0; index<row.length; index++)
        {
            System.out.println("Enter element ["+index+"]:");
            row[index]=in.nextInt();
        }
     for (int index=0; index<row.length; index++)
            if (row[index]>numberZ) row[index] =numberZ;
        System.out.print("New row:");
                    System.out.println(Arrays.toString(row));

    }
}
