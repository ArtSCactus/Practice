/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

/**
 *
 * @author ArtSCactus
 */
public class SplitOnNumbersAlgorithm {
      /**
     * Returns a massive of elements, that in summ will give number.
     * numberOfItems - number of times, that you need get, after number dividing
     *
     * @param number;
     * @param numberOfItems;
     * @return theTerms (int[]);
     */
    private static int[] splitNumber(int number, int numberOfItems) {
        int[] theTerms = new int[numberOfItems];
        int summOfElements = 0;
        for (int index = 0; index < theTerms.length; index++) {
            theTerms[index] = 1;
        }
        for (int index = 0; index < theTerms.length; index++) {
            summOfElements += theTerms[index];
        }
        if (summOfElements > number) {
            int summBeforeZeroPoint=0;
            for (int index=0; index<theTerms.length; index++){
                if (summBeforeZeroPoint== number) theTerms[index]=0;
                else summBeforeZeroPoint+=theTerms[index];
            }
             summOfElements=0;
                   for (int index = 0; index < theTerms.length; index++) {
            summOfElements += theTerms[index];
        }
        } else if (summOfElements == number) {
            return theTerms;
        }
        int currentElementNumber = 0;
        while (true) {
            summOfElements = 0;
            for (int index = 0; index < theTerms.length; index++) {
                summOfElements += theTerms[index];
            }
            if (summOfElements == number) {
                break;
            } else {
                theTerms[currentElementNumber]++;
                if (currentElementNumber == theTerms.length - 1) {
                    currentElementNumber = 0;
                } else {
                    currentElementNumber++;
                }
            }
        }
        return theTerms;
    }
}
