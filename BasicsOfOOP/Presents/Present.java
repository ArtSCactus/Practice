/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.BasicsOfOOP.Presents;

import Practice.BasicsOfOOP.Presents.Candys.Candy;
import Practice.BasicsOfOOP.Presents.Candys.Factory;
import Practice.BasicsOfOOP.Presents.Wrap.Wrap;

/**
 * Task condition: Вариант B. Подарки. Реализовать приложение, позволяющее
 * создавать подарки (объект, представляющий собой подарок). Составляющими
 * целого подарка являются сладости и упаковка.
 *
 * @author ArtSCactus
 */
public class Present {

    /**
     * Contains wrap of current present.
     *
     */
    private Wrap wrap;
    /**
     * Contains candys, that consist current present.
     *
     */
    private Candy[] candys;

    /**
     * Cunstracts new Present object.
     *
     * @param wrap
     * @param candys
     */
    public Present(Wrap wrap, Candy... candys) {
        if (wrap == null | candys == null) {
            throw new NullPointerException("Wrap or candy cannot be null");
        }
        if (candys.length == 0) {
            throw new IllegalArgumentException("Candy's amount cannot be 0");
        }
        this.wrap = wrap;
        this.candys = candys;
    }

    /**
     * Returns wrap of current present.
     *
     * @return Wrap object
     */
    public Wrap getWrap() {
        return wrap;
    }

    /**
     * Settings new Wrap object to a current present.
     *
     * @param wrap
     */
    public void setWrap(Wrap wrap) {
        if (wrap == null) {
            throw new NullPointerException("Wrap cannot be null");
        }
        this.wrap = wrap;
    }

    /**
     * Returns candys array of current present.
     *
     * @return
     */
    public Candy[] getCandys() {
        return candys;
    }

    /**
     * Settings new candys value.
     *
     * @param candy
     * @throws IllegalArgumentException if candy array length are 0
     * @throws NullPointerException if candy are null
     */
    public void setCandys(Candy... candy) {
        if (candy.length == 0) {
            throw new IllegalArgumentException("Candys array cannot be null");
        }
        if (candy == null) {
            throw new NullPointerException("Candy cannot be null");
        }
        this.candys = candys;
    }

    /**
     * Returns current present as String row. First row are Wrap desription.
     * Each next row are candy's description(each candy on new row).
     *
     * @return String information
     */
    @Override
    public String toString() {
        String information = "Wrap type: " + Wrap.getWrapType(wrap);
        for (Candy candy : candys) {
            information += "\n" + candy.toString();
        }
        return information;
    }

    /**
     * Temporary method to test class functional.
     *
     */
    public static void testClass() {
        Factory factory = new Factory();
        Present present = factory.craftPresent();
        System.out.println(present.toString());
    }
}
