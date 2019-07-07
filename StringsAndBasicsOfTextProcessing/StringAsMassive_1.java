/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.StringsAndBasicsOfTextProcessing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Task condition: 1. Дан массив названий переменных в camelCase. Преобразовать
 * названия в snake_case.
 *
 * @author ArtSCactus
 */
public class StringAsMassive_1 {

    static void methodLauncher() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter something in camelCase style: ");
        String row = in.nextLine();
        System.out.println("In Snake case style: " + toSnakeCase(row));
    }

    /**
     * Returns a row, where word in camelCase are replaced on snake_case style.
     *
     * @param row
     * @return
     */
    static String toSnakeCase(String row) {
        if (row.equals("")) {
            return row;
        }
        char[] symbols = row.toCharArray();
        for (int index = 0; index < symbols.length; index++) {
            // Checking is it Upper case symbol
            if (Character.isUpperCase(symbols[index]) == true) {
                symbols[index] = Character.toLowerCase(symbols[index]);
                symbols = Arrays.copyOf(symbols, symbols.length + 1);
                // Shifting char massive on 1 element in right
                for (int shiftIndex = symbols.length - 1; shiftIndex > index; shiftIndex--) {
                    symbols[shiftIndex] = symbols[shiftIndex - 1];
                }
                // Inserting on a free space symbol "_"
                symbols[index] = '_';
            }

        }
        // String concatenation
        String result = new String(symbols);
        return result;
    }
}
