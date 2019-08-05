/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.BasicsOfOOP.Presents.Candys;

/**
 *
 * @author ArtSCactus
 */
public enum Souffle implements Candy {
    SOUFFLE_CANDY("Souffle candy"),
    FRUIT_SOUFFLE("Fruit souffle"),
    MASHROOM_SOUFFLE("Mashroom souffle"),
    FISH_SOUFFLE("Fish souffle");

    /**
     * Contains name of current souffle.
     *
     */
    private String candysName;

    /**
     * Constructs new Souffle object.
     *
     * @param candysName
     * @throws NullPointerException if candysName are null
     */
    Souffle(String candysName) {
        if (candysName == null) {
            throw new NullPointerException("Candy's name cannot be null");
        }
        this.candysName = candysName;
    }

    /**
     * Returns current souffle name.
     *
     * @return
     */
    @Override
    public String getName() {
        return candysName;
    }

    /**
     * Settings new value to souffle name.
     *
     * @param candysName
     * @throws NullPointerException if candysName are null
     */
    @Override
    public void setName(String candysName) {
        this.candysName = candysName;
    }

    /**
     * Returns a row type <code>"Souffle: "+candysName</code>.
     *
     * @return String "Souffle: "+candysName
     */
    @Override
    public String toString() {
        return "Souffle: " + candysName;
    }

    /**
     * Returns random Souffle object.
     *
     * @return Souffle object
     */
    public static Souffle getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
