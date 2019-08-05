/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.BasicsOfOOP.Presents.Candys;

/**
 *
 * @author ArtSCactus
 */
public interface Candy {

    /**
     * Should be allow to set new value to a current candy.
     *
     * @param candysName
     */
    public void setName(String candysName);

    /**
     * Should return name of current candy.
     *
     * @return
     */
    public String getName();
}
