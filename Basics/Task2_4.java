/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basics;

/**
 *
 * @author ArtSCactus
 */
public class Task2_4 {
    public static boolean task2_4(double A, double B, double x, double y, double z){
        if (y>A & z>B || z>A & y>B) return false;
        else return true;
    }
}
