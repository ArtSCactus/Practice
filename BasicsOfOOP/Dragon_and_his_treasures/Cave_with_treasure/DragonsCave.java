package Practice.BasicsOfOOP.Dragon_and_his_treasures.Cave_with_treasure;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Practice.BasicsOfOOP.Dragon_and_his_treasures.Cave_with_treasure.Treasure;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ArtSCactus
 */
public class DragonsCave {

    /**
     * List of treasures.
     *
     */
    private List<Treasure> treasures;

    /**
     * Constructs 100 treasure objects to <code>List<Treasure></code>. Every
     * Treasure object are generating randomly.
     *
     */
    public DragonsCave() {
        treasures = new ArrayList<>();
        for (int counter = 0; counter < 99; counter++) {
            treasures.add(Treasure.getRandomTreasure());
        }
    }

    /**
     * Constructs 100 treasure objects to <code>List<Treasure></code> from given
     * List. Size of this list must be 100.
     *
     * @param treasuresList list of Treasure objects with size 100.
     * @throws IllegalArgumentException if treasureList size not 100.
     */
    public DragonsCave(List treasuresList) {
        if (treasuresList.size() != 100) {
            throw new IllegalArgumentException("List size must be 100");
        }
        treasures.addAll(treasuresList);
    }

    /**
     * Prints to console all Treasure objects in list
     * (<code>List<Treasure></code>).
     *
     */
    public void printAll() {
        for (Treasure treasure : treasures) {
            System.out.println(treasure.toString() + "\n");
        }
    }

    /**
     * Prints only the most expensive (the biggest value by method
     * <code>getValue()</code> in Treasure object) treasure.
     *
     */
    public void printMostExpensive() {
        Treasure mostExpensive = treasures.get(0);
        for (int index = 0; index < treasures.size() - 1; index++) {
            if (treasures.get(index).getValue() > mostExpensive.getValue()) {
                mostExpensive = treasures.get(index);
            }
        }
        System.out.println(mostExpensive.toString());
    }

    /**
     * Displays to the console treasures that are less than or equal to the
     * specified amount.
     *
     * @param sum
     */
    public void printOnSum(int sum) {
        int counter = 0;
        for (Treasure treasure : treasures) {
            if (treasure.getValue() + counter < sum) {
                System.out.println(treasure.toString());
                counter += treasure.getValue();
            }
        }
    }
}
