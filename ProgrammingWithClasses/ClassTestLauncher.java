/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ArtSCactus
 */
public class ClassTestLauncher {
       public static void launchStringsUnit() throws IOException {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Task numbers:");
        System.out.println("1-Class Student (Unit programming with classes, task 3)");
        System.out.print("№");
        Scanner in = new Scanner(System.in);
        int taskNumber = in.nextInt();
        switch (taskNumber) {
            case (1):
                Student.testClass();
                break;
            default:
                System.out.println("No such task number.");
                break;
        }
    }
}
