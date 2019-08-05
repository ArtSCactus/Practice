/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.BasicsOfOOP.Dragon_and_his_treasures.TreasureTypes;

import static Practice.BasicsOfOOP.Dragon_and_his_treasures.TreasureTypes.Armor.values;

/**
 *
 * @author ArtSCactus
 */
public enum Jewelry {
    KINGS_CROWN("King's crown", 400),
    GOLDEN_CUP("Golden cup", 80),
    GOLDEN_BOWL("Golden bowl", 65),
    SILVER_TABLEWARE("Silver tableware", 40),
    ROYAL_SKYPETER("Royal skypeter", 350),
    BELT_DECORATED_WITH_GOLD("Belt decorated with gold", 35),
    FUR_GOWN("Fur gown", 100),
    LEAKY_SHIRT("Leaky shirt", 5),
    TREASURE_CHEST("Treasure chest", 500);
    /**
     * Name of curent jewelry type. Cannot be null.
     *
     */
    private String jewelryType;
    /**
     * Cost of current jewelry type (price by which this item can be sold).
     * Cannot be less than 0.
     */
    private int jewelryCost;

    Jewelry(String jewelryType, int jewelryCost) {
        if (jewelryType == null) {
            throw new NullPointerException("Weapon type cannot be null");
        }
        if (jewelryCost < 0) {
            throw new IllegalArgumentException("Treasure value cannot be less than 0");
        }
        this.jewelryType = jewelryType;
        this.jewelryCost = jewelryCost;
    }

    /**
     * Returns jewelry cost.
     *
     * @return
     */
    public int getJewelryCost() {
        return jewelryCost;
    }

    /**
     * Settings new value to jewelry cost()
     *
     * @param jewelryCost
     * @throws IllegalArgumentException ifjewelryCost are less than 0
     */
    public void setJewelryCost(int jewelryCost) {
        if (jewelryCost < 0) {
            throw new IllegalArgumentException("Treasure value cannot be less than 0");
        }
        this.jewelryCost = jewelryCost;
    }

    /**
     * Returns jewelry type.
     *
     * @return String jewelryType
     */
    public String getJewelryType() {
        return jewelryType;
    }

    /**
     * Settings jewelry type.
     *
     * @param jewelryType
     * @throws NullPointerException if jewelryType are null
     */
    public void setJewelryType(String jewelryType) {
        if (jewelryType == null) {
            throw new NullPointerException("Armor type cannot be null");
        }
        this.jewelryType = jewelryType;
    }

    /**
     * Returns random Jewelry object.
     *
     * @return
     */
    public static Jewelry getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
