/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.BasicsOfOOP.Task_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Task condition: Создать объект класса Текстовый файл, используя классы Файл,
 * Директория. Методы: создать, переименовать, вывести на консоль содержимое,
 * дополнить, удалить.
 *
 * @author ArtSCactus
 */
public class TextFile {

    private File file;

    /**
     *
     * @param fileName
     * @throws IOException
     */
    public TextFile(String fileName) throws IOException {
        file = new File(fileName);
        if (file.exists()) {
            System.out.println("File " + fileName + " already exists. Working with file " + file.getName());
            return;
        } else {
            try {
                file.createNewFile();
            } catch (SecurityException se) {
                System.out.println("Failed to create file. Cause: not enouph rights.");
            }
        }
        if (file.exists()) {
            System.out.println("File " + fileName + " successfully created in folder " + file.getPath());
        } else {
            System.out.println("Failed to create file " + fileName);
        }
    }

    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void readFile() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(file);
        Scanner scan = new Scanner(fr);

        int rowNumber = 1;
        while (scan.hasNextLine()) {
            System.out.println(rowNumber + " : " + scan.nextLine());
            rowNumber++;
        }

        fr.close();
    }

    /**
     *
     * @param information
     * @throws IOException
     */
    public void rewriteFile(String information) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(information);
        writer.close();
    }

    /**
     *
     * @param information
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void addToFile(String information) throws FileNotFoundException, IOException {
        String previousInf = "";
        FileReader fr = new FileReader(file);
        Scanner scan = new Scanner(fr);

        while (scan.hasNextLine()) {
            if (scan.hasNextLine()) {
                previousInf += scan.nextLine() + "\n";
            } else {
                previousInf += scan.nextLine();
            }
        }
        fr.close();
        rewriteFile(previousInf + information);

    }

    /**
     *
     * @param newFileName
     */
    public void renameFile(String newFileName) {
        System.out.println("Trying to rename file " + file.getName() + " to " + newFileName);
        if (file.renameTo(new File(file.getParent() + "\\" + newFileName))) {
            System.out.println("Successfully renamed. ");
            file = new File(file.getParent() + "\\" + newFileName);
            System.out.println("New file name: " + file.getName());
        } else {
            System.out.println("Failed to rename. Possibly such file exists. Trying to solve problem...");
            newFileName = insertMarkToFileName(newFileName);
            if (file.renameTo(new File(file.getParent() + "\\" + newFileName))) {
                System.out.println("Successfully renamed.");
                file = new File(file.getParent() + "\\" + newFileName);
                System.out.println("New file name: " + file.getName());
            } else {
                System.out.println("Failed to rename.");
            }
        }
    }

    private String insertMarkToFileName(String fileName) {
        String[] parts = fileName.split("\\.");
        parts[0] += " (renamed " + file.getName() + ")";
        return parts[0] + "." + parts[1];
    }

    /**
     *
     */
    public void deleteFile() {
        if (file.exists()) {
            try {
                file.delete();
            } catch (SecurityException se) {
                System.out.println("Cannot delete directory. Cause: not enouph right.");
            }
            if (!file.exists()) {
                System.out.println("File " + file.getName() + " successfully removed.");
            } else {
                System.out.println("Failed to delete folder " + file.getName());
            }

        } else {
            System.out.println("By path " + file.getName() + " no such folder");
        }

    }
}
