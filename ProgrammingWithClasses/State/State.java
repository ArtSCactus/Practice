/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses.State;

/**
 * Task condition: 3. Создать объект класса Государство, используя классы
 * Область, Район, Город. Методы: вывести на консоль столицу, количество
 * областей, площадь, областные центры.
 *
 * @author ArtSCactus
 */
public class State {

    private City capital;
    private Region[] regions;

    /**
     *
     * @param capital
     * @param regions
     */
    public State(City capital, Region... regions) {
        if (capital == null | regions == null) {
            throw new NullPointerException("Capital or region cannot be null");
        }
        this.capital = capital;
        this.regions = regions;
    }

    /**
     *
     * @return
     */
    public City getCapital() {
        return capital;
    }

    /**
     *
     * @param capital
     */
    public void setCapital(City capital) {
        if (capital == null) {
            throw new NullPointerException("Capital or region cannot be null");
        }
        this.capital = capital;
    }

    /**
     *
     * @return
     */
    public Region[] getRegions() {
        return regions;
    }

    /**
     *
     * @param regions
     */
    public void setRegions(Region... regions) {
        if (regions == null) {
            throw new NullPointerException("Capital or region cannot be null");
        }
        this.regions = regions;
    }

    /**
     *
     * @return
     */
    public int countSquare() {
        int square = 0;
        for (Region region : regions) {
            square += region.getSquare();
        }
        return square;
    }

    /**
     *
     * @return
     */
    public int amountOfRegions() {
        return regions.length;
    }

    /**
     *
     */
    public void printRegionCenters() {
        for (Region region : regions) {
            System.out.println("Region name: " + region.getRegionName() + ". Region center: " + region.getRegionCenter().getName());
        }
    }

    /**
     *
     */
    public static void testClass() {
        State state = new State(new City("Minsk", new District("Factory district"), new District("Pervomaysky district")),
                new Region(39900, new City("Minsk", new District("Factory district"), new District("Pervomaysky district")), "Minsk region"),
                new Region(29100, new City("Mogilyov"), "Mogilyov region"),
                new Region(32800, new City("Brest"), "Brest region"),
                new Region(40000, new City("Vitebsk"), "Vitebsk region"),
                new Region(40400, new City("Gomel"), "Gomel region"),
                new Region(25100, new City("Grodno"), "Grodno region")
        );
        System.out.println("Capital: " + state.getCapital().getName());
        System.out.println("Amount of regions: " + state.amountOfRegions());
        System.out.println("Square: " + state.countSquare());
        System.out.println("Region centers: ");
        state.printRegionCenters();
    }
}
