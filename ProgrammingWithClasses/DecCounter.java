/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses;

/**
 * Task condition: 5. Опишите класс, реализующий десятичный счетчик, который
 * может увеличивать или уменьшать свое значение на единицу в заданном
 * диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
 * произвольными значениями. Счетчик имеет методы увеличения и уменьшения
 * состояния, и метод позволяющее получить его текущее состояние. Написать код,
 * демонстрирующий все возможности класса.
 *
 * @author ArtSCactus
 */
public class DecCounter {

    private int counter;
    private final int upperBorder;
    private final int downBorder;

    /**
     * Constructs given numbers to the decimal counter. Order of
     * upper(<code>int upperBorder</code>) and down
     * border(<code>int downBorder</code>) are doesn't matter. In case of
     * counter(<code>int counter</code>) out of given borders throws
     * IllegalArgumentException.
     *
     * @param downBorder
     * @param upperBorder
     * @param counter
     * @throws IllegalArgumentException
     */
    public DecCounter(int downBorder, int upperBorder, int counter) throws IllegalArgumentException {
        if (downBorder > upperBorder) {
            this.upperBorder = downBorder;
            this.downBorder = upperBorder;
        } else {
            this.downBorder = downBorder;
            this.upperBorder = upperBorder;
        }
        if (counter > this.upperBorder | counter < this.downBorder) {
            throw new IllegalArgumentException("Counter is out of border: " + counter + ". Upper border: " + upperBorder + ". Down border: " + downBorder);
        }
        this.counter = counter;
    }

    /**
     * Constructs given numbers to the decimal counter. Order of
     * upper(<code>int upperBorder</code>) and down
     * border(<code>int downBorder</code>) are doesn't matter.
     * Counter(<code>int counter</code>) are getting default value 0. In case of
     * counter(<code>int counter</code>) out of given borders throws
     * IllegalArgumentException.
     *
     * @param downBorder
     * @param upperBorder
     */
    public DecCounter(int downBorder, int upperBorder) {
        if (downBorder > upperBorder) {
            this.upperBorder = downBorder;
            this.downBorder = upperBorder;
        } else {
            this.downBorder = downBorder;
            this.upperBorder = upperBorder;
        }
        if (counter > this.upperBorder | counter < this.downBorder) {
            throw new IllegalArgumentException("Counter is out of border: " + counter + ". Upper border: " + upperBorder + ". Down border: " + downBorder);
        }
    }

    /**
     * Constructs decimal counter with default values
     * (<code>upperBorder Integer.MAX_VALUE, downBorder Integer.MIN_VALUE</code>).
     *
     */
    public DecCounter() {
        downBorder = Integer.MIN_VALUE;
        upperBorder = Integer.MAX_VALUE;
    }

    /**
     * Plussing 1 to counter, if counter+1 standing in borders.
     *
     */
    public void plus() {
        if (counter + 1 <= upperBorder & counter + 1 >= downBorder) {
            counter++;
        }
    }

    /**
     * Plussing <code>number</code> to the counter, if counter+number standing
     * in borders.
     *
     * @param number
     */
    public void plus(int number) {
        if (counter == upperBorder & number > 0 | counter == downBorder & number < 0) {
        } else {
            if (counter + number > upperBorder) {
                counter += upperBorder - counter;
            } else if (counter + number < downBorder) {
                counter += downBorder - counter;
            } else {
                counter += number;
            }
        }
    }

    /**
     * Taking 1 from counter, if counter-1 standing in borders.
     *
     */
    public void minus() {
        if (counter - 1 <= upperBorder & counter - 1 >= downBorder) {
            counter--;
        }
    }

    /**
     * Taking number from counter, if counter-number standing in border.
     *
     * @param number
     */
    public void minus(int number) {
        if (counter == upperBorder & number < 0 | counter == downBorder & number > 0) {
        } else {
            if (counter - number > upperBorder) {
                counter += upperBorder - counter;
            } else if (counter - number < downBorder) {
                counter -= downBorder - counter;
            } else {
                counter -= number;
            }
        }
    }

    /**
     * Returns counter value.
     *
     * @return
     */
    public int getCounter() {
        return counter;
    }

    public static void testClass() {
        DecCounter counter = new DecCounter(10, 0, 5);
        counter.minus(); //4
        System.out.println(counter.getCounter());
        counter.plus();//5
        System.out.println(counter.getCounter());
        counter.minus(-6); //10
        System.out.println(counter.getCounter());
        counter.minus(10);//0
        System.out.println(counter.getCounter());
        counter.plus(11);//10
        System.out.println(counter.getCounter());
    }
}
