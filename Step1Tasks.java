/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package step1tasks.Practice;

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
                                public static void functionValidation(boolean correctAnswer, boolean function){
        if (correctAnswer==function) System.out.println("The answer is correct. ");
        else System.out.println("The answer is NOT correct. Expected: "+correctAnswer+ " Got: "+ function);
    }




    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("--------Line programs--------");
        functionValidation(4, Task1_1.task1_1(2,4,6));
        functionValidation(0.25, Task1_2.task1_2(1,2,3,4));
        functionValidation(-7.1454455496388025, Task1_3.task1_3(1,1));
        functionValidation(456.123, Task1_4.task1_4(123.456));
        functionValidation("04ч:01мин:01с",Task1_5.task1_5(14461));
        functionValidation(true, Task1_6.task1_6(0, 0));
    }
}
