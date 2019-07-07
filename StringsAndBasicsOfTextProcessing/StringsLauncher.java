/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.StringsAndBasicsOfTextProcessing;

import Practice.Algorithmization.Decomposition_01;
import Practice.Algorithmization.Decomposition_02;
import Practice.Algorithmization.Decomposition_03;
import Practice.Algorithmization.Decomposition_04;
import Practice.Algorithmization.Decomposition_05;
import Practice.Algorithmization.Decomposition_06;
import Practice.Algorithmization.Decomposition_07;
import Practice.Algorithmization.Decomposition_08;
import Practice.Algorithmization.Decomposition_09;
import Practice.Algorithmization.Decomposition_10;
import Practice.Algorithmization.Decomposition_11;
import Practice.Algorithmization.Decomposition_12;
import Practice.Algorithmization.Decomposition_13;
import Practice.Algorithmization.Decomposition_14;
import Practice.Algorithmization.Decomposition_15;
import Practice.Algorithmization.Decomposition_16;
import Practice.Algorithmization.Decomposition_17;
import Practice.Algorithmization.MassiveOfMassives_01;
import Practice.Algorithmization.MassiveOfMassives_02;
import Practice.Algorithmization.MassiveOfMassives_03;
import Practice.Algorithmization.MassiveOfMassives_04;
import Practice.Algorithmization.MassiveOfMassives_05;
import Practice.Algorithmization.MassiveOfMassives_06;
import Practice.Algorithmization.MassiveOfMassives_07;
import Practice.Algorithmization.MassiveOfMassives_08;
import Practice.Algorithmization.MassiveOfMassives_09;
import Practice.Algorithmization.MassiveOfMassives_10;
import Practice.Algorithmization.MassiveOfMassives_11;
import Practice.Algorithmization.MassiveOfMassives_12;
import Practice.Algorithmization.MassiveOfMassives_13;
import Practice.Algorithmization.MassiveOfMassives_14;
import Practice.Algorithmization.MassiveOfMassives_15;
import Practice.Algorithmization.MassiveOfMassives_16;
import Practice.Algorithmization.OneDimSorting_01;
import Practice.Algorithmization.OneDimSorting_02;
import Practice.Algorithmization.OneDimSorting_03;
import Practice.Algorithmization.OneDimSorting_04;
import Practice.Algorithmization.OneDimSorting_05;
import Practice.Algorithmization.OneDimSorting_06;
import Practice.Algorithmization.OneDimSorting_07;
import Practice.Algorithmization.OneDimSorting_08;
import Practice.Algorithmization.OneDim_01;
import Practice.Algorithmization.OneDim_02;
import Practice.Algorithmization.OneDim_03;
import Practice.Algorithmization.OneDim_04;
import Practice.Algorithmization.OneDim_05;
import Practice.Algorithmization.OneDim_06;
import Practice.Algorithmization.OneDim_07;
import Practice.Algorithmization.OneDim_08;
import Practice.Algorithmization.OneDim_09;
import Practice.Algorithmization.OneDim_10;
import java.util.Scanner;

/**
 *
 * @author ArtSCactus
 */
public class StringsLauncher {
    
    public static void launchStringsUnit() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Task numbers:");
        System.out.println("1-Working with a string as an array of characters");
        System.out.println("2-Working with a string as with an object of type String or StringBuilder");
        System.out.println("3-Working with regular expressions (Pattern, Matcher)");
        System.out.println("P.s. for example, 11 means Working with a string as an array of characters, task №1");
        System.out.print("№");
        Scanner in = new Scanner(System.in);
        int taskNumber = in.nextInt();
        switch (taskNumber) {
            case (11):
                StringAsMassive_1.methodLauncher();
                break;
            case (12):
                StringAsMassive_2.methodLauncher();
                break;
            case (13):
                StringAsMassive_3.methodLauncher();
                break;
            case (14):
                StringAsMassive_4.methodLauncher();
                break;
            case (15):
                StringAsMassive_5.methodLauncher();
                break;
            default:
                System.out.println("No such task number.");
                break;
        }
    }
}
