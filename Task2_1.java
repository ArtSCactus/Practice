/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package step1tasks.Practice;

/**
 *
 * @author ArtSCactus
 */
public class Task2_1 {
    public static void task2_1(double angleOne, double angleTwo){
        if (angleOne+angleTwo>=180) {System.out.println("Such triangle not exist."); return;}
         double angleThree=180-angleOne-angleTwo;
         if ((angleThree+angleTwo+angleOne)==180 || angleThree<=0) {
             if (angleOne==90||angleTwo==90||angleThree==90)
         {
             System.out.println("Such triangle are exist. It's right triangle.");
             return;
         }
             else {System.out.println("Such triangle are exist."); return;}
         }
    }
}
