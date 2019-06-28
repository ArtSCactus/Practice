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
            case (29):
                MassiveOfMassives_09.doTask();
                break;
            case (210):
                MassiveOfMassives_10.doTask();
                break;
            case (211):
                MassiveOfMassives_11.doTask();
                break;
            case (212):
                MassiveOfMassives_12.doTask();
                break;
            case (213):
                MassiveOfMassives_13.doTask();
                break;
            case (214):
                MassiveOfMassives_14.doTask();
                break;
            case (215):
                MassiveOfMassives_15.doTask();
                break;
            case (216):
                MassiveOfMassives_16.doTask();
                break;
            case (31):
                OneDimSorting_01.doTask();
                break;
            case (32):
                OneDimSorting_02.doTask();
                break;
            case (33):
                OneDimSorting_03.doTask();
                break;
            case (34):
                OneDimSorting_04.doTask();
                break;
            case (35):
                OneDimSorting_05.doTask();
                break;
            case (36):
                OneDimSorting_06.doTask();
                break;
            case (37):
                OneDimSorting_07.doTask();
                break;
            case (38):
                OneDimSorting_08 task = new OneDimSorting_08();
                task.doTask();
                break;
            case (41):
                System.out.print("Enter number A: ");
                int a = in.nextInt();
                System.out.print("\n Enter number B: ");
                int b = in.nextInt();
                System.out.println("\nMethod output: " + Decomposition_01.doTask(a, b));
                break;
            case (42):
                System.out.print("Enter number A: ");
                a = in.nextInt();
                System.out.print("\n Enter number B: ");
                b = in.nextInt();
                System.out.print("Enter number C: ");
                int c = in.nextInt();
                System.out.print("\n Enter number D: ");
                int d = in.nextInt();
                System.out.println("\nMethod output: " + Decomposition_02.gcd(a, b, c, d));
            case (43):
                System.out.print("Enter side length of figure: ");
                double sideLength = in.nextDouble();
                System.out.println("\nMethod output: " + Decomposition_03.findSquare(sideLength));
                break;
            case (44):
                Decomposition_04.launcherForMethod();
                break;
            case (45):
                Decomposition_05.launcherForMethod();
                break;
            case (46):
                Decomposition_06.methodLauncher();
                break;
            case (47):
                System.out.println("Method output: "+Decomposition_07.findOddFactorials());
                break;
            case (48):
                Decomposition_08.launcherForMethod();
                break;
            case (49):
                Decomposition_09.methodLauncher();
                break;
            case (410):
                Decomposition_10.methodLauncher();
                break;
            default:
                System.out.println("No such task number.");
                break;
        }
    }
}
