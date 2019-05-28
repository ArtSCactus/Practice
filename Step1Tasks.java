/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package step1tasks.Practice;

import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Step1Tasks {
    public static void functionValidation(int correctAnswer, int function){
        if (correctAnswer==function) System.out.println("The answer is correct. ");
        else System.out.println("The answer is NOT correct. Expected: "+correctAnswer+ " Got: "+ function);
    }
        public static void functionValidation(double correctAnswer, double function){
        if (correctAnswer==function) System.out.println("The answer is correct. ");
        else System.out.println("The answer is NOT correct. Expected: "+correctAnswer+ " Got: "+ function);
    }
                public static void functionValidation(String correctAnswer, String function){
        if (correctAnswer.equals(function)) System.out.println("The answer is correct. ");
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

public static double task1_3(int x, int y){
    double result =((sin(x)+cos(y))/(cos(x)-sin(y)))*(sin(x*y)/cos(x*y));
    return result;
}
public static double task1_4(double number){
String fraction="";
String wholePart="";
boolean firstPartPassed=false;
       for (String buffer : Double.toString(number).split("\\.")) {
           if(firstPartPassed==false){ wholePart=buffer;
            firstPartPassed=true;}
            else fraction=buffer;
        }
      String result=fraction+"."+wholePart;
return Double.parseDouble(result);
}
public static String task1_5(int seconds){
  return new SimpleDateFormat("HHч:mmмин:ssс").format(new Date(TimeUnit.SECONDS.toMillis(seconds)));
}
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("--------Line programs--------");
        functionValidation(4, task1_1(2,4,6));
        functionValidation(0.25, task1_2(1,2,3,4));
        functionValidation(-7.1454455496388025, task1_3(1,1));
        functionValidation(456.123, task1_4(123.456));
        functionValidation("04ч:00мин:00с",task1_5(3600));
        
    }
    
}
