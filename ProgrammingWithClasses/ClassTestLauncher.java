/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses;

import Practice.ProgrammingWithClasses.Accounts.Bank;
import Practice.ProgrammingWithClasses.Airline.Airlines;
import Practice.ProgrammingWithClasses.Book.Books;
import Practice.ProgrammingWithClasses.Car.Car;
import Practice.ProgrammingWithClasses.Customer.CustomerBase;
import Practice.ProgrammingWithClasses.State.State;
import Practice.ProgrammingWithClasses.Text.Text;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author ArtSCactus
 */
public class ClassTestLauncher {

    public static void launchClassUnit() throws IOException, ParseException {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Task numbers:");
        System.out.println("1-Class Student (Unit programming with classes, task 3)");
        System.out.println("2-Class Train (Unit programming with classes, task 4)");
        System.out.println("3-Class DecCounter (Unit programming with classes, task 5)");
        System.out.println("4-Class Time (Unit programming with classes, task 6)");
        System.out.println("5-Class CustomerBase (Unit programming with classes, task 8)");
        System.out.println("6-Class Books (Unit programming with classes, task 9)");
        System.out.println("7-Class Airlines (Unit programming with classes, task 10)");
        System.out.println("8-Class Text (Unit programming with classes, Aggregation and composition task 1)");
        System.out.println("9-Class Car (Unit programming with classes, Aggregation and composition task 2)");
                System.out.println("10-Class State (Unit programming with classes, Aggregation and composition task 3)");
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
            case (6):
                Books.testClass();
                break;
            case (7):
                Airlines.testClass();
                break;
            case (8):
                Text.testClass();
                break;
            case (9):
                Car.testClass();
                break;
            case (10):
                State.testClass();
                break;
            case (11):
                Bank.testClass();
                break;
            default:
                System.out.println("No such task number.");
                break;
        }
    }
}
