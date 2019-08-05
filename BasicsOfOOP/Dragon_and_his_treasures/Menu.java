/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.BasicsOfOOP.Dragon_and_his_treasures;

import Practice.BasicsOfOOP.Dragon_and_his_treasures.Cave_with_treasure.DragonsCave;
import Practice.BasicsOfOOP.Dragon_and_his_treasures.TreasureTypes.Weapons;
import java.io.IOException;
import java.util.Scanner;

/**
 * Task condition: Создать консольное приложение, удовлетворяющее следующим
 * требованиям: • Приложение должно быть объектно-, а не
 * процедурно-ориентированным. • Каждый класс должен иметь отражающее смысл
 * название и информативный состав. • Наследование должно применяться только
 * тогда, когда это имеет смысл. • При кодировании должны быть использованы
 * соглашения об оформлении кода java code convention. • Классы должны быть
 * грамотно разложены по пакетам. • Консольное меню должно быть минимальным.
 * •Для хранения данных можно использовать файлы. Дракон и его сокровища.
 * Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в
 * пещере дракона. Реализовать возможность просмотра сокровищ, выбора самого
 * дорогого по стоимости сокровища и выбора сокровищ на заданную сумму.
 *
 * @author ArtSCactus
 */
public class Menu {
/**Application launcher.
 * 
 * @throws IOException 
 */
    public static void mainMenu() throws IOException {
        Scanner scan = new Scanner(System.in);
        while(true){
        System.out.println("\nYou just overpowered the dragon and all local people are greatful to you."
                + "\nTime to collect your reward has come. What will you do firstly?"
                + "\n1-Take a look at all the treasures"
                + "\n2-Take the most expensive treasure"
                + "\n3-Take the tresure on certain amount");
                int choice;
        while(true){
             choice= scan.nextInt();
             if (choice<1 | choice>3)System.out.println("Please, choose the correct number.");
             else break;
        } 
        DragonsCave cave = new DragonsCave();
        switch (choice) {
            case (1):
                Weapons weapon;
                weapon = Weapons.getRandom();
                System.out.println(weapon.getWeaponCost() + weapon.getWeaponType());
                System.out.println("\n-------------------" + "Generated treasures: " + "\n-------------------");
                cave.printAll();
                break;
            case (2):
                 cave.printMostExpensive();
                 break;
            case (3):
                System.out.print("Please, choose the sum: ");
                int sum;
                while (true){
                    sum=scan.nextInt();
                    if (sum<0) System.out.println("Given sum must be bigger than 0!\nTry again: ");
                    else break;
                }
                System.out.println("Found on "+sum);
                cave.printOnSum(2000);
                break;
        }
        System.out.println("\nWhant to choose another variant?\n1-Yes\n2-No");
        choice=scan.nextInt();
        if(choice<1 | choice>2) System.out.println("Please, choose Yes(1) or No(2).");
        else if(choice==2) System.exit(0);
        System.out.flush();
    }
    }
}
