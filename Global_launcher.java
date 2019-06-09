/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import Practice.Algorithmization.Algorithmization_launcher;
import Practice.Basics.Basics_launcher;
import java.util.Scanner;

/**
 *
 * @author ArtSCactus
 */
public class Global_launcher {
    public static void main(String[] args){
        System.out.println("1-Basics of code development\n2-Algorithmization(work in progress)");
                System.out.println("Please, choose the unit: ");
        Scanner in = new Scanner(System.in);
        int unitNumber=in.nextInt();
        switch(unitNumber){
            case (1):
                Basics_launcher.launchBasicsUnit();
                break;
            case (2):
                Algorithmization_launcher.launchAlgUnit();
                break;
            default:
                System.out.println("Sorry, but no such unit number.");
                break;
        }
    }
}
