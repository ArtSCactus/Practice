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
public enum Chocolate implements Candy {
    ROSHEN_DARK("Roshen dark"),
    ROSHEN_MILK("Roshen milk"),
    ROSHEN_WHITE("Roshen white"),
    ROSHEN_DIABETICK("Roshen diabetic"),
    ROSHEN_POROUS("Roshen porous"),
    SPARTAK_DARK("Spartak dark"),
    SPARTAK_MILK("Spartak milk"),
    SPARTAK_WHITE("Spartak white"),
    SPARTAK_DIABETICK("Spartak diabetick"),
    SPARTAK_POROUS("Spartak porous"),
    KOMMUNARKA_DARK("Kommunarka dark"),
    KOMMUNARKA_MILK("Kommunarka milk"),
    KOMMUNARKA_WHITE("Kommunarka white"),
    KOMMUNARKA_DIABETICK("Kommunarka diabetick"),
    KOMMUNARKA_POROUS("Kommunarka porous");
    /**
     * Consist current chocolate name.
     *
     */
    private String candysName;

    /**
     * Construcs new chocolate object.
     *
     * @param candysName
     * @throws NullPointerException if candysName are null
     */
    Chocolate(String candysName) {
        if (candysName == null) {
            throw new NullPointerException("Candy's name cannot be null");
        }
        this.candysName = candysName;
    }

    /**
     * Returns a name of current chocolate.
     *
     * @return String candysName
     */
    @Override
    public String getName() {
        return candysName;
    }

    /**
     * Settings new value to current chocolate object.
     *
     * @param candysName
     * @throws NullPointerException if candysName are null
     */
    @Override
    public void setName(String candysName) {
        if (candysName == null) {
            throw new NullPointerException("Chocolate name cannot be null");
        }
        this.candysName = candysName;
    }

    /**
     * Returns a row type <code>"Chocolate: "+candysName</code>.
     *
     * @return String "Chocolate: "+candysName
     */
    @Override
    public String toString() {
        return "Chocolate: " + candysName;
    }

    /**
     * Returns random Chocolate object.
     *
     * @return Chocolate object
     */
    public static Chocolate getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
