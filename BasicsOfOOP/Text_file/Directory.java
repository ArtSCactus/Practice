/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.BasicsOfOOP.Text_file;

import java.io.File;
import java.io.IOException;

/**
 * Task condition: Создать объект класса Текстовый файл, используя классы Файл,
 * Директория. Методы: создать, переименовать, вывести на консоль содержимое,
 * дополнить, удалить.
 *
 * @author ArtSCactus
 */
public class Directory {

    private File dir;

    /**
     * Automaticly creates directory by given path, if such folder does not
     * exists.
     *
     * @param folderPath
     */
    public Directory(String folderPath) {
        dir = new File(folderPath);
        if (!dir.exists()) {
            System.out.println("Such folder does not exist, creating directory: " + dir.getName());
            try {
                dir.mkdir();
            } catch (SecurityException se) {
                System.out.println("Cannot create directory. Cause: not enouph right.");
            }
            if (dir.exists()) {
                System.out.println("Directory " + folderPath + " successfully created.");
            }
        } else {
            System.out.println("Such directory already exists. Working in: " + dir.getPath());
        }
    }

    /**
     *
     * @param fileName
     * @throws IOException
     */
    public void addFile(String fileName) throws IOException {
        File newFile = new File(dir.getPath() + "\\" + fileName);
        if (newFile.exists()) {
            System.out.println("File " + fileName + " already exists");
            return;
        } else {
            try {
                newFile.createNewFile();
            } catch (SecurityException se) {
                System.out.println("Failed to create file. Cause: not enouph rights.");
            }
        }
        if (newFile.exists()) {
            System.out.println("File " + fileName + " successfully created in folder " + dir.getPath());
        } else {
            System.out.println("Failed to create file " + fileName);
        }
    }

    /**
     *
     * @param fileName
     */
    public void deleteFile(String fileName) {
        File file = new File(dir.getPath() + "\\" + fileName);
        if (!file.exists()) {
            System.out.println("File in directory " + dir.getPath() + "\\" + fileName);
        } else {
            try {
                file.delete();
            } catch (SecurityException se) {
                System.out.println("Failed to delete file " + fileName + ". Cause: not enouph rights.");
            }
            if (!file.exists()) {
                System.out.println("File " + fileName + " successfully deleted.");
            } else {
                System.out.println("Failed to delete file " + fileName);
            }
        }
    }

    /**
     *
     */
    public void deleteDir() {
        if (dir.exists()) {
            try {
                dir.delete();
            } catch (SecurityException se) {
                System.out.println("Cannot delete directory. Cause: not enouph right.");
            }
            if (!dir.exists()) {
                System.out.println("Directory " + dir.getName() + " successfully removed.");
            } else {
                System.out.println("Failed to delete folder " + dir.getName());
            }

        } else {
            System.out.println("By path " + dir.getName() + " no such folder");
        }

    }

    /**
     *
     * @return
     */
    public String getDirPath() {
        return dir.getPath();
    }

    /**
     *
     * @throws IOException
     */
    public static void testClass() throws IOException {
        System.out.println("\nDirectory tests:\n");
        Directory dir = new Directory("New folder");
        System.out.println("Directory tests: ");
        dir.addFile("Test.txt");
        dir.deleteFile("Test.txt");
        dir.deleteDir();
        dir= new Directory("New folder");
        System.out.println("\nTextFile tests:\n ");
        TextFile txtFile = new TextFile(dir.getDirPath() + "\\" + "Test.txt");
        txtFile.rewriteFile("Hello!");
        txtFile.readFile();
        txtFile.addToFile("Hello again!");
        txtFile.readFile();
        txtFile.renameFile("RenamedTest.txt");
        txtFile.readFile();
        txtFile.deleteFile();
        dir.deleteDir();
    }
}
