/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.BasicsOfOOP.Dragon_and_his_treasures.Cave_with_treasure;

import Practice.BasicsOfOOP.Dragon_and_his_treasures.TreasureTypes.Armor;
import Practice.BasicsOfOOP.Dragon_and_his_treasures.TreasureTypes.Jewelry;
import Practice.BasicsOfOOP.Dragon_and_his_treasures.TreasureTypes.Weapons;

/**
 *
 * @author ArtSCactus
 */
public class Treasure {

    private String type;
    private int value;

    /**
     * Constructs Treasure object as weapon.
     *
     * @param weapon
     * @throws NullPointerException if weapon type are null
     * @throws IllegalArgumentException if weapon cost are less tha 0.
     */
    public Treasure(Weapons weapon) {
        if (weapon.getWeaponType() == null) {
            throw new NullPointerException("Teasure type cannot be null");
        }
        if (weapon.getWeaponCost() < 0) {
            throw new IllegalArgumentException("Treasure value cannot be less than 0");
        }
        this.type = weapon.getWeaponType();
        this.value = weapon.getWeaponCost();
    }

    /**
     * Constructs Treasure object as armor.
     *
     * @param armor
     * @throws NullPointerException if armor type are null
     * @throws IllegalArgumentException if armor cost are less tha 0.
     */
    public Treasure(Armor armor) {
        if (armor.getArmorType() == null) {
            throw new NullPointerException("Teasure type cannot be null");
        }
        if (armor.getArmorCost() < 0) {
            throw new IllegalArgumentException("Treasure value cannot be less than 0");
        }
        this.type = armor.getArmorType();
        this.value = armor.getArmorCost();
    }

    /**
     * Constructs Treasure object as jewelry.
     *
     * @param jewelry
     * @throws NullPointerException if jewelry type are null
     * @throws IllegalArgumentException if jewelry cost are less tha 0.
     */
    public Treasure(Jewelry jewelry) {
        if (jewelry.getJewelryType() == null) {
            throw new NullPointerException("Teasure type cannot be null");
        }
        if (jewelry.getJewelryCost() < 0) {
            throw new IllegalArgumentException("Treasure value cannot be less than 0");
        }
        this.type = jewelry.getJewelryType();
        this.value = jewelry.getJewelryCost();
    }

    public String getType() {
        return type;
    }

    /**
     * Settings new value to <code>String type</code>.
     *
     * @param type
     * @throws NullPointerException if type are null
     */
    public void setType(String type) {
        if (type == null) {
            throw new NullPointerException("Teasure type cannot be null");
        }
        this.type = type;
    }

    /**
     * Returns <code>int value</code>.
     *
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * public void setValue(int value) { this.value = value; } /** Returns
     * <code>String type</code> and <code>int value</code> in a String row.
     *
     * @return
     */
    @Override
    public String toString() {
        return type + " (can be sold by price: " + value + ")";
    }

    /**
     * Randomly returns 1 object Treasure that contains 1 value ofWeapon or
     * Armor or Jewelry.
     *
     * @return
     */
    public static Treasure getRandomTreasure() {
        int typeId = (int) (1 + Math.random() * 3);
        switch (typeId) {
            case (1):
                return new Treasure(Armor.getRandom());
            case (2):
                return new Treasure(Jewelry.getRandom());
            case (3):
                return new Treasure(Weapons.getRandom());
        }
        return null;
    }
}
