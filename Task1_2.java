/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package step1tasks.Practice;

/**
 *
 * @author Asusq
 */
public class Task1_2 {
    /** Returns the quad root from inputed number*/
        public static double findRoot(double number){ 
        double result =0.000000000000000000000000001;
        while(true)
        {
          if (result*result!=number) result++;
          else break;
        }
        return result;
    }
    public static double task1_2(double a, double b, double c, double z){
    double result =((b+findRoot(b*b+4*a*c))/(2*a))-a*a*a*c+(1/(b*b));
    return result;
}
}
