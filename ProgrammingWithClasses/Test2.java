/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses;

/**
 * Task condition: 2. Создйте класс Test2 двумя переменными. Добавьте
 * конструктор с входными параметрами. Добавьте конструктор, инициализирующий
 * члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра
 * класса.
 *
 * @author ArtSCactus
 */
public class Test2 {

    private int variableOne;
    private int variableTwo;

    public Test2() {
        variableOne = 0;
        variableTwo = 0;
    }

    /**
     * Returns first variable value (<code>variavleOne</code>).
     *
     * @return
     */
    public int getVariableOne() {
        return variableOne;
    }

    /**
     * Setting new value to the first variable (<code>variableOne</code>).
     *
     * @param variableOne value that will replace the old value
     */
    public void setVariableOne(int variableOne) {
        this.variableOne = variableOne;
    }

    /**
     * Returns second variable value (<code>variavleTwo</code>).
     *
     * @return
     */
    public int getVariableTwo() {
        return variableTwo;
    }

    /**
     * Setting new value to the second variable (<code>variableTwo</code>).
     *
     * @param variableTwo value that will replace the old value
     */
    public void setVariableTwo(int variableTwo) {
        this.variableTwo = variableTwo;
    }

}
