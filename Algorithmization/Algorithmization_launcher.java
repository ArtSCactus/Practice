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
public class Algorithmization_launcher {

    public static void launchAlgUnit() {
        System.out.println("Task numbers: \nOne-dimension massives(1):");
        System.out.println("Massives of massives(2)");
        System.out.println("Sortng(3)");
        System.out.println("Decomposition(4)");
        System.out.println("Enter task number you want:");
        System.out.println("P.s. for example, 11 means One-dimension massive, task №1");
        /* for (int index = 1; index < 11; index++) {
            System.out.println("1" + index + "-№" + index);
        }
        System.out.println("Massives of massives(2):");
        for (int index = 2; index < 12; index++) {
            System.out.println("2" + index + "-№" + index);
        }
        System.out.println("Sortng(3):");
        for (int index = 1; index < 9; index++) {
            System.out.println("3" + index + "-№" + index);
        }
        System.out.println("Decomposition(4):");
        for (int index = 1; index < 18; index++) {
            System.out.println("4" + index + "-№" + index);
        }*/
        Scanner in = new Scanner(System.in);
        int taskNumber = in.nextInt();
        switch (taskNumber) {
            case (11):
                OneDim_01.doTask();
                break;
            case (12):
                OneDim_02.doTask();
                break;
            case (13):
                OneDim_03.doTask();
                break;
            case (14):
                OneDim_04.doTask();
                break;
        }
    }
}
