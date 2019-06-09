/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Basics;

/**
 *
 * @author Asusq
 */
public class Task3_1 {
    public static int task3_1(int limit){
        if (limit<0|| limit%1!=0) {System.out.println("Wrong input data"); return 0;} 
        int  result=1;
        int iterator=1;
        while (iterator!=limit)
        {
            result+=result+1;
            iterator++;
        }
        return result;
    }
}
