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
public enum Caramel implements Candy {
    ROSHEN_CARAMEL("Roshen caramel"),
    SPARTAK_CARAMEL("Spartak caramel"),
    KOMMUNARKA_KARAMEL("Kommunarka caramel");
    /**
     * Contains caramel's name.
     *
     */
    private String candysName;

    /**
     * Constructs Caramel object.
     *
     * @param candysName
     * @throws NullPointerException if candysName are null
     */
    Caramel(String candysName) {
        if (candysName == null) {
            throw new NullPointerException("Candy's name cannot be null");
        }
        this.candysName = candysName;
    }

    /**
     * Returns current caramel name.
     *
     * @return String candysName
     */
    @Override
    public String getName() {
        return candysName;
    }

    /**
     * Settings new value to current caramel name.
     *
     * @param candysName
     * @throws NullPointerException if candysName are null
     */
    @Override
    public void setName(String candysName) {
        if (candysName == null) {
            throw new NullPointerException("Caramel name cannot be null");
        }
        this.candysName = candysName;
    }

    /**
     * Returns a row type <code>"Caramel: "+candysName</code>.
     *
     * @return String "Caramel: "+candysName
     */
    @Override
    public String toString() {
        return "Caramel: " + candysName;
    }

    /**
     * Returns a random Caramel object.
     *
     * @return Caramel object
     */
    public static Caramel getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
