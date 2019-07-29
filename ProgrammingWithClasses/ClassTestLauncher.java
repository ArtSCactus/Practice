/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses;

import Practice.ProgrammingWithClasses.Customer.CustomerBase;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author ArtSCactus
 */
public class ClassTestLauncher {
       public static void launchStringsUnit() throws IOException, ParseException {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Task numbers:");
        System.out.println("1-Class Student (Unit programming with classes, task 3)");
        System.out.println("2-Class Train (Unit programming with classes, task 4)");
        System.out.println("3-Class DecCounter (Unit programming with classes, task 5)");
        System.out.println("4-Class Time (Unit programming with classes, task 6)");
        System.out.println("5-Class CustomerBase (Unit programming with classes, task 8)");
        System.out.print("№");
        Scanner in = new Scanner(System.in);
        int taskNumber = in.nextInt();
        switch (taskNumber) {
            case (1):
                Student.testClass();
                break;
            case (2):
                Train.testClass();
                break;
            case (3):
                DecCounter.testClass();
                break;
            case (4):
                Time.testClass();
                break;
            case (5):
                CustomerBase.testClass();
                break;
            default:
                System.out.println("No such task number.");
                break;
        }
    }
}
