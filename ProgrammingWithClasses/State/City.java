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
public class City {

    private String name;
    private District[] districts;

    public City(String name, District... districts) throws NullPointerException {
        if (name == null | districts == null) {
            throw new NullPointerException("Name or district cannot be null");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NullPointerException {
        if (name == null) {
            throw new NullPointerException("Name or district cannot be null");
        }
        this.name = name;
    }

}
