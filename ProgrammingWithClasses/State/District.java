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
public class District {

    private String name;

    public District(String name) throws NullPointerException {
        if (name == null) {
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
