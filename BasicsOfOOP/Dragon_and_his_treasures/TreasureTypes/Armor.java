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
public enum Armor {
    ARMOR_OF_FORGOTTEN_KING("Armor of forgotten king", 600),
    HEAVY_STEEL_ARMOR("Heavy stell armor", 600),
    WOODEN_ARMOR("Wooden armor", 320),
    ROYAL_GUARD_ARMOR("Royal guard armor", 700),
    PRAETORIAN_GUARD_ARMOR("Praetorian guard armor", 650),
    ANCIENT_EGYPT_ARMOR("Ancient egypt armor", 1000),
    CRUSADER_ARMOR("Crusader armor", 800),
    SAMURAI_ARMOR("Samurai armor", 900),
    PARADE_KING_ARMOR("Parade king armor", 1500),
    MARCHING_ARMOR("Marching armor", 400),
    CHINES_WARLOD_ARMOR("Chines warlord armor", 1300);

    /**
     * Name of curent armor type. Cannot be null.
     *
     */
    private String armorType;
    /**
     * Cost of current weapon type (price by which this item can be sold).
     * Cannot be less than 0.
     */
    private int armorCost;

    Armor(String armorType, int armorCost) {
        if (armorType == null) {
            throw new NullPointerException("Weapon type cannot be null");
        }
        if (armorCost < 0) {
            throw new IllegalArgumentException("Treasure value cannot be less than 0");
        }
        this.armorType = armorType;
        this.armorCost = armorCost;
    }

    /**
     * Returns armor cost.
     *
     * @return
     */
    public int getArmorCost() {
        return armorCost;
    }

    /**
     * Settings new value to weapon cost ()
     *
     * @param armorCost
     * @throws IllegalArgumentException if armorCost less than 0
     */
    public void setArmorCost(int armorCost) {
        if (armorCost < 0) {
            throw new IllegalArgumentException("Treasure value cannot be less than 0");
        }
        this.armorCost = armorCost;
    }

    /**
     * Returns armor type.
     *
     * @return String armorType
     */
    public String getArmorType() {
        return armorType;
    }

    /**
     * Settings armor type.
     *
     * @param armorType
     * @throws NullPointerException if armorType are null
     */
    public void setArmorType(String armorType) {
        if (armorType == null) {
            throw new NullPointerException("Armor type cannot be null");
        }
        this.armorType = armorType;
    }

    /**
     * Returns random Armor object.
     *
     * @return
     */
    public static Armor getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
