/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Basics;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Basics_launcher {

    public static void main(String[] args) {
        System.out.println("Input task number (example: 21 means part 2 task 1): ");
        Scanner in = new Scanner(System.in);
        int taskNumber = in.nextInt();
        switch (taskNumber) {
            case (11):
                System.out.println("Input variables: ");
                System.out.println("Input a (int)");
                int a = in.nextInt();
                System.out.println("Input b (int)");
                int b = in.nextInt();
                System.out.println("Input c (int)");
                int c = in.nextInt();
                System.out.println(Task1_1.task1_1(a, b, c));
                break;
            case (12):
                System.out.println("Input variables: ");
                System.out.println("Input a (double)");
                double var1 = in.nextDouble();
                System.out.println("Input b (double)");
                double var2 = in.nextDouble();
                System.out.println("Input c (double)");
                double var3 = in.nextDouble();
                System.out.println("Input d (double)");
                double var4 = in.nextDouble();
                System.out.println(Task1_2.task1_2(var1, var2, var3, var4));
                break;
            case (13):
                System.out.println("Input variables: ");
                System.out.println("Input x (int)");
                a = in.nextInt();
                System.out.println("Input y (int)");
                b = in.nextInt();
                System.out.println(Task1_3.task1_3(a, b));
                break;
            case (14):
                System.out.println("Input variables: ");
                System.out.println("Input number like 111.222 (double)");
                double f = in.nextDouble();
                System.out.println(Task1_4.task1_4(f));
                break;
            case (15):
                System.out.println("Input variables: ");
                System.out.println("Input amount of seconds (int)");
                a = in.nextInt();
                System.out.println(Task1_5.task1_5(a));
                break;
            case (16):
                System.out.println("Input variables: ");
                System.out.println("Input x (double)");
                var1 = in.nextDouble();
                System.out.println("Input y (double)");
                var2 = in.nextDouble();
                System.out.println(Task1_6.task1_6(var1, var2));
                break;
            case (21):
                System.out.println("Input variables: ");
                System.out.println("Input first angle (int)");
                var1 = in.nextDouble();
                System.out.println("Input second angle (int)");
                var2 = in.nextDouble();
                Task2_1.task2_1(var1, var2);
                break;
            case (22):
                System.out.println("Input variables: ");
                System.out.println("Input a (int)");
                a = in.nextInt();
                System.out.println("Input b (int)");
                b = in.nextInt();
                System.out.println("Input c (int)");
                c = in.nextInt();
                System.out.println("Input d (int)");
                int d = in.nextInt();
                System.out.println(Task2_2.task2_2(a, b, c, d));
                break;
            case (23):
                System.out.println("Input variables: ");
                System.out.println("Input x1 (int)");
                a = in.nextInt();
                System.out.println("Input y1 (int)");
                b = in.nextInt();
                System.out.println("Input x2 (int)");
                c = in.nextInt();
                System.out.println("Input y2 (int)");
                d = in.nextInt();
                System.out.println("Input x3 (int)");
                int e = in.nextInt();
                System.out.println("Input y3 (int)");
                int g = in.nextInt();
                System.out.println(Task2_3.task2_3(a, b, c, d, e, g));
                break;
            case (24):
                System.out.println("Input variables: ");
                System.out.println("Input A (double)");
                var1 = in.nextDouble();
                System.out.println("Input B (double)");
                var2 = in.nextDouble();
                System.out.println("Input x (double)");
                var3 = in.nextDouble();
                System.out.println("Input y (dobule)");
                var4 = in.nextDouble();
                System.out.println("Input z (double)");
                double var5 = in.nextDouble();
                System.out.println(Task2_4.task2_4(var1, var2, var3, var4, var5));
                break;
            case (25):
                System.out.println("Input variables: ");
                System.out.println("Input a (int)");
                a = in.nextInt();
                System.out.println(Task2_5.task2_5(a));
                break;
            case (31):
                System.out.println("Input variables: ");
                try {
                    System.out.println("Input a (int)");
                    a = in.nextInt();
                    System.out.println(Task3_1.task3_1(a));
                } catch (InputMismatchException ex) {
                    System.out.println("Wrong data. Limit cannot be double or  less then 0. ");
                }
                break;
            case (32):
                System.out.println("Input a (int)");
                a = in.nextInt();
                System.out.println("Input b (int)");
                b = in.nextInt();
                System.out.println("Input c (int)");
                c = in.nextInt();
                System.out.println("Output:");
                Task3_2.task3_2(a, b, c);
                break;
            case (33):
                System.out.println(Task3_3.task3_3());
                break;
            case (34):
                System.out.println(Task3_4.task3_4());
                break;
            case (35):
                System.out.println("Input e (double)");
                var1=in.nextDouble();
                System.out.println("Input row start (int)");
                a=in.nextInt();
                System.out.println("Input row end (int)");
                b = in.nextInt();
                System.out.println(Task3_5.task3_5(var1,a,b));
                break;
            case (36):
                System.out.println("Input symbol: ");
                  Object symbol =in.next();
                  System.out.println("Hash code: "+Task3_6.task3_6(symbol));
                break;
            case (37):
                System.out.println("Input start number (int): ");
                a=in.nextInt();
                System.out.println("Input end number (int): ");
                b=in.nextInt();
                Task3_7.task3_7(a,b);
            case (38):
                System.out.println("Input first number (int): ");
               a=in.nextInt();
                               System.out.println("Input second number(int): ");
               b=in.nextInt();
               Task3_8.task3_8(a, b);
               break;
            default:
                System.out.println("No such task number");
                break;
        }
    }
}
