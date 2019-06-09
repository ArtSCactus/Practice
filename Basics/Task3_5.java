/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Basics;

import static java.lang.Math.pow;

/**
 *
 * @author ArtSCactus
 */
public class Task3_5 {
    public static double task3_5(double e, int rowStart, int rowEnd){
        double result=0;
        double aN=0;
        for (int index=rowStart; index<rowEnd; index++){
                       aN=(1/pow(2,index))+(1/pow(3,index));
                       if (aN<0) 
                       {
                           if (-1*aN>=e) result+=aN;
                       }
                       else if (aN>=e) result+=aN;
        }
        return result;
    }
}
