/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Basics;

import java.math.BigInteger;

/**
 *
 * @author ArtSCactus
 */
public class Task3_4 {
    public static BigInteger task3_4(){
        int counter=1;
        BigInteger product = new BigInteger("1");
        BigInteger currentQuad;
        while (counter<201){
            currentQuad = new BigInteger(Integer.toString(counter*counter));
            product = product.multiply(currentQuad);
            counter++;
        }
        System.out.println("Please, don't fear. The number are really big :) ");
        return product;
    }
}
