/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Basics;

/**
 *
 * @author ArtSCactus
 */
public class Task1_6 {
    public static boolean task1_6(double x, double y) {
double fourthIXBorder=2;
double fourthIYBorder=4;
double fourthIIXBorder=-2;
double fourthIIYBorder=4;
double fourthIIIXBorder=-4;
double fourthIIIYBorder=-3;
double fourthIVXBorder=4;
double fourthIVYBorder=-3;



    boolean consist;
    consist = x<=fourthIXBorder & x >=0 & y<=fourthIYBorder & y>=0 || x>=fourthIIXBorder & x <=0 & y<=fourthIIYBorder & y>=0 || x>=fourthIIIXBorder & x <=0 & y>=fourthIIIYBorder & y<=0 || x<=fourthIVXBorder & x >=0 & y>=fourthIVYBorder & y<=0  ? true:false;
    System.out.println(consist);
    return consist;
    }
}
