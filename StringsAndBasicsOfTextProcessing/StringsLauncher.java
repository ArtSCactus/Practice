/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.StringsAndBasicsOfTextProcessing;

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
            case (21):
                StringAsObject_1.methodLauncher();
                break;
            case (22):
                StringAsObject_2.methodLauncher();
                break;
            case (23):
                StringAsObject_3.methodLauncher();
                break;
            case (24):
                StringAsObject_4.methodLauncher();
                break;
            case (25):
                StringAsObject_5.methodLauncher();
                break;
            case (26):
                StringAsObject_6.methodLauncher();
                break;
            case (27):
                StringAsObject_7.methodLauncher();
                break;
            case (28):
                StringAsObject_8.methodLauncher();
                break;
            case (29):
                StringAsObject_9.methodLauncher();
                break;
            case (210):
                StringAsObject_10.methodLauncher();
                break;
            default:
                System.out.println("No such task number.");
                break;
        }
    }
}
