/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses;

/**
 * Task condition: 1. Создайте класс Test1 двумя переменными. Добавьте метод
 * вывода на экран и методы изменения этих переменных. Добавьте метод, который
 * находит сумму значений этих переменных, и метод, который находит наибольшее
 * значение из этих двух переменных.
 *
 * @author ArtSCactus
 */
public class Test1 {

    private int firstNumber;
    private int secondNumber;

    /**
     * Returns a first number value.
     *
     * @return
     */
    public int getFirstNumber() {
        return firstNumber;
    }

    /**
     * Returns a second number value.
     *
     * @return
     */
    public int getSecondNumber() {
        return secondNumber;
    }

    /**
     * Setting new value for first number.
     *
     * @param firstNumber number to be placed instead of old value
     */
    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    /**
     * Setting new value for second number.
     *
     * @param secondNumber number to be placed instead of old value
     */
    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    /**
     * Printing variables <code>firstNumber</code> and <code>secondNumber</code>
     * values to console.
     *
     */
    public void printVariablesToConsole() {
        System.out.println("First number: " + firstNumber + "\nSecondNumber: " + secondNumber);
    }

    /**
     * Returns a sum of <code>firstNumber</code> and <code>secondNumber</code>.
     *
     * @return
     */
    public int getSum() {
        return firstNumber + secondNumber;
    }

    /**
     * Returns the biggest number between <code>firstNumber</code> and
     * <code>secondNumber</code>. If they are equal, returns the first number
     * (<code>firstNumber</code>)
     *
     * @return
     */
    public int getTheBiggestOne() {
        if (firstNumber > secondNumber) {
            return firstNumber;
        } else {
            if (firstNumber < secondNumber) {
                return secondNumber;
            } else {
                return firstNumber;
            }
        }
    }
}
