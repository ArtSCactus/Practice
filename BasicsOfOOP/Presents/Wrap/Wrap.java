/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.BasicsOfOOP.Presents.Wrap;

/**
 *
 * @author ArtSCactus
 */
public enum Wrap {
    BOX("Box"),
    PACKAGE("Package"),
    POUCH("Pouch"),
    SOFT_TOY("Soft toy");
    /**
     * Contains a wrap name or type.
     *
     */
    private String wrapName;

    /**
     * Constructs Wrap object.
     *
     * @param wrapName
     * @throws NullPointerException if wrapName are null
     */
    Wrap(String wrapName) {
        if (wrapName == null) {
            throw new NullPointerException("Wrap name cannot be null");
        }
        this.wrapName = wrapName;
    }

    /**
     * Returns Wrap name.
     *
     * @return wrapName
     */
    public String getWrapName() {
        return wrapName;
    }

    /**
     * Settings new value to wrapName variable.
     *
     * @param wrapName
     * @throws NullPointerException if wrapName are null
     */
    public void setWrapName(String wrapName) {
        if (wrapName == null) {
            throw new NullPointerException("Wrap name cannot be null");
        }
        this.wrapName = wrapName;
    }

    @Override
    public String toString() {
        return "Wrap: " + wrapName;
    }

    /**
     * Returns random Wrap object.
     *
     * @return
     */
    public static Wrap getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

    /**
     * Takes a wrap name from given object.
     *
     * @param wrap
     * @return String wrapName
     */
    public static String getWrapType(Wrap wrap) {
        return wrap.getWrapName();
    }

}
