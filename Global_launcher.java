/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import Practice.Algorithmization.Algorithmization_launcher;
import Practice.Basics.Basics_launcher;
import Practice.BasicsOfOOP.OOPTestLauncher;
import Practice.Module_6.Harbor.Harbor;
import Practice.Module_6.Home_library.Menu;
import Practice.Module_6.Notepad.Notepad;
import Practice.ProgrammingWithClasses.ClassTestLauncher;
import Practice.StringsAndBasicsOfTextProcessing.StringsLauncher;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author ArtSCactus
 */
public class Global_launcher {

    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        System.out.println("1-Basics of code development"
                + "\n2-Algorithmization"
                + "\n3-Strings and basics of text processing"
                + "\n4-Programming with classes"
                + "\n5-Basics of OOP"
                + "\n6-Home library project"
                + "\n7-Notepad project"
                + "\n8-Harbor project");
        System.out.println("Please, choose the unit: ");
        Scanner in = new Scanner(System.in);
        int unitNumber = in.nextInt();
        switch (unitNumber) {
            case (1):
                Basics_launcher.launchBasicsUnit();
                break;
            case (2):
                Algorithmization_launcher.launchAlgUnit();
                break;
            case (3):
                StringsLauncher.launchStringsUnit();
                break;
            case (4):
                ClassTestLauncher.launchClassUnit();
                break;
            case (5):
                OOPTestLauncher.launchOOPTests();
                break;
            case (6):
                String bookStoragePath="src\\Practice\\Module_6\\Home_library\\Data";
                String emailStoragePath="src\\Practice\\Module_6\\Home_library\\EmailSystem";
                String accountStoragePath="src\\Practice\\Module_6\\Home_library\\Utill\\AccountManager";
                Menu menu = new Menu();
                menu.run(bookStoragePath,emailStoragePath,accountStoragePath);
                break;
            case (7):
                Notepad notepad = new Notepad(new File("src\\Practice\\Module_6\\Notepad\\Notepad.txt"));
                notepad.run();
                break;
            case (8):
                        Harbor harbor = new Harbor(1000, 1);
                harbor.testClass();
                break;
            default:
                System.out.println("Sorry, but no such unit number.");
                break;
        }
    }
}
