/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses.Car;

/**
 *
 * @author ArtSCactus
 */
public class Wheel {
    private final double diameter;
    private final SeasonType seasonType;
    private boolean isOK;
    public static enum SeasonType{
        WINTER, SUMMER;
    }

    /**
     *
     * @param diameter
     * @param seasonType
     * @param isOK
     */
    public Wheel(double diameter, SeasonType seasonType, boolean isOK) throws IllegalArgumentException{
        if (diameter<0) throw new IllegalArgumentException("Wheel diameter cannot be less than 0");
    this.diameter=diameter;
    this.seasonType=seasonType;
    this.isOK=isOK;
}

    /**
     *
     * @return
     */
    public double getDiameter() {
        return diameter;
    }

    /**
     *
     * @return
     */
    public SeasonType getSeasonType() {
        return seasonType;
    }

    /**
     *
     * @return
     */
    public boolean isOK() {
        return isOK;
    }

    /**
     *
     * @param isOK
     */
    public void setCondition(boolean isOK) {
        this.isOK = isOK;
    }
    
}
