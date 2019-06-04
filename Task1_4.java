/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package step1tasks.Practice;

/**
 *
 * @author ArtSCactus
 */
public class Task1_4 {
 public static double task1_4(double number){
String fraction="";
String wholePart="";
boolean firstPartPassed=false;
       for (String buffer : Double.toString(number).split("\\.")) {
           if(firstPartPassed==false){ wholePart=buffer;
            firstPartPassed=true;}
            else fraction=buffer;
        }
      String result=fraction+"."+wholePart;
return Double.parseDouble(result);
}
}
