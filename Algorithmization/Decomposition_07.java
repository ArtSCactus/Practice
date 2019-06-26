/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Algorithmization;

/**
 * Task condition:
 * 7. Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.
 * @author ArtSCactus
 */
public class Decomposition_07 {
    /** Returns a factorial of given number.
     * 
     * @param givenNumber
     * @return 
     */
    static int factorial(int givenNumber){
        int result=1;
        for (int currentNumber=1; currentNumber<=givenNumber; currentNumber++)
            result*=currentNumber;
        return result;
    }
    /** Returns a factorials sum of number 1,3,6,9.
     * 
     * @return 
     */
    static int findOddFactorials(){
        int sum=0;
        for (int currentNumber=1; currentNumber<=9; currentNumber+=2)
            sum+=factorial(currentNumber);
        return sum;
    }
}
