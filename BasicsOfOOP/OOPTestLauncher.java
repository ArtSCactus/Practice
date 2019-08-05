/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.BasicsOfOOP;

import Practice.BasicsOfOOP.Dragon_and_his_treasures.Menu;
import Practice.BasicsOfOOP.Presents.Present;
import Practice.BasicsOfOOP.Task_1.Directory;
import Practice.BasicsOfOOP.Task_2.Payment;
import Practice.BasicsOfOOP.Task_2.Payment.Purchase;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ArtSCactus
 */
public class OOPTestLauncher {
    public static void launchOOPTests() throws IOException{
           System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Task numbers:");
        System.out.println("1-Class TextFile and Directory (Unit Basics of OOP, task 1)");
        System.out.print("№");
        Scanner in = new Scanner(System.in);
        int taskNumber = in.nextInt();
        switch (taskNumber) {
            case (1):
                Directory.testClass();
                break;
            case (2):
                Menu.mainMenu();
                break;
            case (3):
                Present.testClass();
                break;
            default:
                System.out.println("No such task number.");
                break;
        }
    }
}
