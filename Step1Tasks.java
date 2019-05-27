/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package step1tasks.Practice;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Step1Tasks {
    public static void functionValidation(int correctAnswer, int function){
        if (correctAnswer==function) System.out.println("The answer is correct. ");
        else System.out.println("The answer is NOT correct. Expected: "+correctAnswer+ " Got: "+ function);
    }
        public static void functionValidation(double correctAnswer, double function){
        if (correctAnswer==function) System.out.println("The answer is correct. ");
        else System.out.println("The answer is NOT correct. Expected: "+correctAnswer+ " Got: "+ function);
    }
public static int task1_1(int a, int b, int c){
    int z = ((a-3)*b/2)+c;
    return z;
}
public static double task1_2(double a, double b, double c, double z){
    double result =((b+sqrt(pow(b,2)+4*a*c))/(2*a))-pow(a,3)*c+pow(b,-2);
    return result;
}

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("--------Line programs--------");
        functionValidation(4, task1_1(2,4,6));
        functionValidation(0.25, task1_2(1,2,3,4));
    }
    
}
