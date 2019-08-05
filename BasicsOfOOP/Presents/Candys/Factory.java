/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.BasicsOfOOP.Presents.Candys;

import Practice.BasicsOfOOP.Presents.Present;
import Practice.BasicsOfOOP.Presents.Wrap.Wrap;

/**
 *
 * @author ArtSCactus
 */
public class Factory {

    /**
     * Returns random candy by id. 0-Chocolate enum, 1-Caramel enum, 2-Souffle - enum.
     * Otherwise - null;
     *
     * @param id
     * @return Candy's realization
     */
    public Candy getCandy(int id) {
        switch (id) {
            case (0):
                return Chocolate.getRandom();
            case (1):
                return Caramel.getRandom();
            case (2):
                return Souffle.getRandom();
            default:
                return null;
        }
    }

    /**
     * Returns random Candy's realization.
     *
     * @return Candy's realization
     */
    public Candy getRandomCandy() {
        int index = (int) (1 + Math.random() * 3);
        switch (index) {
            case (1):
                return Chocolate.getRandom();
            case (2):
                return Caramel.getRandom();
            case (3):
                return Souffle.getRandom();
            default:
                return null;
        }
    }

    /**
     * Returns random object from Wrap enum.
     *
     * @return Wrap object
     */
    public Wrap getRandomWrap() {
        return Wrap.getRandom();
    }

    /**
     * Constructs and returns a present with random characteristics.
     *
     * @return Present object
     */
    public Present craftPresent() {
        Candy[] candys = new Candy[(int) (15 + Math.random() * 100)];
        for (int index = 0; index < candys.length; index++) {
            candys[index] = getRandomCandy();
        }
        return new Present(getRandomWrap(), candys);
    }

    /**
     * Contructs and returns a present with a certain characteristics.
     *
     * @param wrap
     * @param candy
     * @return Present object
     */
    public Present craftPresent(Wrap wrap, Candy... candy) {
        return new Present(wrap, candy);
    }
}
