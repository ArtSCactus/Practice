/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.BasicsOfOOP.Dragon_and_his_treasures.TreasureTypes;

/**
 *
 * @author ArtSCactus
 */
public enum Weapons {
    CLASSIC_SWORD("Classic sword", 100),
    PERSIAN_SCIMITAR("Persian scimitar", 200),
    JAPANESE_KATANA("Japanese katana", 500),
    TWOHANDLED_AXE("Two-handled axe", 150),
    SPEAR("Spear", 100),
    TEARDROP_SHIELD("Teardrop shield", 185),
    ROUND_SHIELD("Round shield", 100),
    BOW("Bow", 100),
    CROSSBOW("Crossbow", 200),
    GOLDEN_SWORD("Golden sword", 340),
    VIKINGS_AXE("Viking's axe", 200),
    NAGINATA("Naginata", 400),
    GUANGZHOU("Guangzhou", 350),
    SIRIAN_BROADSWORD("Sirian broadsword", 280),
    ENGLISH_LONG_BOW("English long bow", 130),
    KUNAI("KUNAI", 200);
    /**
     * Name of curent weapon type. Cannot be null.
     *
     */
    private String weaponType;
    /**
     * Cost of current weapon type (price by which this item can be sold).
     * Cannot be less than 0.
     */
    private int weaponCost;

    Weapons(String weaponType, int weaponCost) {
        if (weaponType == null) {
            throw new NullPointerException("Weapon type cannot be null");
        }
        if (weaponCost < 0) {
            throw new IllegalArgumentException("Treasure value cannot be less than 0");
        }
        this.weaponType = weaponType;
        this.weaponCost = weaponCost;
    }

    /**
     * Returns weapon cost.
     *
     * @return
     */
    public int getWeaponCost() {
        return weaponCost;
    }

    /**
     * Settings new value to weapon cost ()
     *
     * @param weaponCost
     * @throws IllegalArgumentException if weaponCost are less than 0;
     */
    public void setWeaponCost(int weaponCost) {
        if (weaponCost < 0) {
            throw new IllegalArgumentException("Treasure value cannot be less than 0");
        }
        this.weaponCost = weaponCost;
    }

    /**
     * Returns weapon type.
     *
     * @return String weaponType
     */
    public String getWeaponType() {
        return weaponType;
    }

    /**
     * Settings weapon type.
     *
     * @param weaponType
     * @throws NullPointerException if weaponType are null
     */
    public void setWeaponType(String weaponType) {
        if (weaponType == null) {
            throw new NullPointerException("Weapon type cannot be null");
        }
        this.weaponType = weaponType;
    }

    /**
     * Returns random Weapons object.
     *
     * @return
     */
    public static Weapons getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
