/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Basics;

/**
 * Task condition: 6. Вывести на экран соответствий между символами и их
 * численными обозначениями в памяти компьютера.
 *
 * @author ArtSCactus
 */
public class Task3_6 {

    public static Object task3_6_hash(Object symbol) {
        return symbol.hashCode();
    }
    public static void task3_6(String symbolsRow){
        char[] symbols=symbolsRow.toCharArray();
        int codeNumber;
        for (char symbol: symbols){
            codeNumber = (int) symbol;
            System.out.println(symbol+": "+codeNumber);
        }
    }
}
