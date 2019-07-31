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
public class Engine {

    private boolean isOK;
    private boolean working;
    private int horsePower;

    /**
     *
     * @param isOK
     * @param working
     * @param horsePower
     */
    public Engine(boolean isOK, boolean working, int horsePower) {
        this.isOK = isOK;
        this.working = working;
        this.horsePower = horsePower;
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

    /**
     *
     * @return
     */
    public boolean isWorking() {
        return working;
    }

    /**
     *
     * @param working
     */
    public void setWorking(boolean working) {
        this.working = working;
    }

    /**
     *
     * @return
     */
    public int getHorsePower() {
        return horsePower;
    }

    /**
     *
     * @param horsePower
     */
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
