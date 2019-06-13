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
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Task numbers: \n1-One-dimension massives:");
        System.out.println("2-Massives of massives");
        System.out.println("3-Sortng");
        System.out.println("4-Decomposition");
        System.out.println("5- Enter task number you want:");
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
            case (15):
                OneDim_05.doTask();
                break;
            case (16):
                OneDim_06.doTask();
                break;
            case (17):
                OneDim_07.doTask();
                break;
            case (18):
                OneDim_08.doTask();
                break;
            case (19):
                OneDim_09.doTask();
                break;
            case (110):
                OneDim_10.doTask();
                break;
            case (21):
                MassiveOfMassives_01.doTask();
                break;
            case (22):
                MassiveOfMassives_02.doTask();
                break;
            case (23):
                MassiveOfMassives_03.doTask();
                break;
            case (24):
                MassiveOfMassives_04.doTask();
                break;
            case (25):
                MassiveOfMassives_05.doTask();
                break;
            case (26):
                MassiveOfMassives_06.doTask();
                break;
            case (27):
                MassiveOfMassives_07.doTask();
                break;
            case (28):
                MassiveOfMassives_08.doTask();
                break;
            default:
                System.out.println("No such task number.");
                break;
        }
    }
}
