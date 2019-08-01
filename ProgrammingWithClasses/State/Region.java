/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses.State;

/**
 *
 * @author ArtSCactus
 */
public class Region {

    private int square;
    private City regionCenter;
    private String regionName;

    /**
     *
     * @param square
     * @param regionCenter
     * @param regionName
     */
    public Region(int square, City regionCenter, String regionName) {
        if (square < 0) {
            throw new IllegalArgumentException("Square cannot be less than 0");
        }
        if (regionCenter == null) {
            throw new NullPointerException("Region center cannot be null");
        }
        if (regionName == null) {
            throw new NullPointerException("Region name cannot be null");
        }
        this.square = square;
        this.regionCenter = regionCenter;
        this.regionName=regionName;
    }

    /**
     *
     * @return
     */
    public int getSquare() {
        return square;
    }

    /**
     *
     * @param square
     */
    public void setSquare(int square) {
        if (square < 0) {
            throw new IllegalArgumentException("Square cannot be less than 0");
        }
        this.square = square;
    }

    /**
     *
     * @return
     */
    public City getRegionCenter() {
        return regionCenter;
    }

    /**
     *
     * @param regionCenter
     */
    public void setRegionCenter(City regionCenter) {
        if (regionCenter == null) {
            throw new NullPointerException("Region center cannot be null");
        }
        this.regionCenter = regionCenter;
    }

    /**
     *
     * @param regionName
     */
    public void setRegionName(String regionName) {
        if (regionName == null) {
            throw new NullPointerException("Region name cannot be null");
        }
        this.regionName = regionName;
    }

    /**
     *
     * @return
     */
    public String getRegionName() {
        return regionName;
    }

}
