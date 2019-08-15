/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Data.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client class for archive project.
 *
 * @author ArtSCactus
 * @version 0.8
 */
public class Client {

    /**
     * Object input stream to receive objects (students).
     *
     */
    private ObjectInputStream inObj;
    /**
     * Object output stream to send objects.
     *
     */
    private ObjectOutputStream outObj;
    /**
     * Socket fo client
     *
     */
    private Socket clientSocket;
    /**
     * Reader to read user input from console.
     *
     */
    private BufferedReader reader;
    /**
     * Reader to read server text output.
     *
     */
    private BufferedReader in;
    /**
     * Writer to write text to the server.
     *
     */
    private BufferedWriter out;

    public Client(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Client client = new Client("localhost", 4004);
        client.run();
    }

    /**
     * Main method, that runs client application. Consist main user interface.
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void run() throws IOException, ClassNotFoundException {
        try {
            try {
                reader = new BufferedReader(new InputStreamReader(System.in));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                while (true) {
                    System.out.println("1-sign in\n2-sign up\n3-exit");
                    String command = reader.readLine();
                    switch (command) {
                        case ("1"):// all commented rows here is a complete dialog between
                            // client and server, that shows each step of communicating
                            //System.out.println("Sending command");
                            //String word = reader.readLine();
                            //Sending command to server, that we are going to sign in
                            out.write("sign in" + "\n");
                            out.flush();
                            //out.write("sign in");
                            //out.flush();
                            //   String serverWord = in.readLine();
                            // System.out.println("Server: " + serverWord);
                            System.out.print("Login: ");
                            String login = reader.readLine();
                            out.write(login + "\n");
                            out.flush();
                            //   String serverWord = in.readLine();
                            //  System.out.println("Server: " + serverWord);
                            System.out.print("Password: ");
                            String password = reader.readLine();
                            out.write(password + "\n");
                            out.flush();
                            //   String     serverWord = in.readLine();
                            //      System.out.println("Server: " + serverWord);
                            String serverWord = in.readLine();
                            System.out.println("Server: " + serverWord);
                            if (serverWord.equals("successfull")) {
                                System.out.println("Successfully signed in as " + login);
                                //runs main menu after successful authorizing
                                mainMenu();
                            } else {
                                System.out.println("Wrong login or password");
                            }
                            break;
                        case ("2")://sign up
                            //Sending to server command, that we are going to sign up
                            out.write("sign up" + "\n");
                            out.flush();
                            System.out.println("Registring new account.");
                            System.out.print("Login: ");
                            login = reader.readLine();
                            out.write(login + "\n");
                            out.flush();
                            System.out.print("Password: ");
                            password = reader.readLine();
                            out.write(password + "\n");
                            out.flush();
                            serverWord = in.readLine();
                            System.out.println("Server" + serverWord);
                            break;
                        case ("3")://leaving the application.
                            closeThreads();
                    }
                }
            } finally {
                System.out.println("Client was closed...");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }

    /**
     * Runs client main menu. This menu is available only after successful
     * authorizing.
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void mainMenu() throws IOException, ClassNotFoundException {
        Scanner inputScanner = new Scanner(System.in);
        String studentName;
        int choice;
        while (true) {
            System.out.println("~~~~~~~~Main menu~~~~~~~~"
                    + "\n1-get student case"
                    + "\n2-add student case"
                    + "\n3-change student case"
                    + "\n4-Exit");
            choice = inputScanner.nextInt();
            inputScanner.nextLine();
            switch (choice) {
                case (1):
                    out.write("get student" + "\n");
                    out.flush();
                    String serverWord = in.readLine();
                    System.out.println("Server: " + serverWord);
                    System.out.print("Enter student name: ");
                    studentName = inputScanner.nextLine();
                    out.write(studentName + "\n");
                    out.flush();
                    serverWord = in.readLine();
                    System.out.println("Server: " + serverWord);
                    serverWord = in.readLine();
                    System.out.println("Server: " + serverWord);
                    break;
                case (2):
                    out.write("add student" + "\n");
                    out.flush();
                    serverWord = in.readLine();
                    System.out.println("Server: " + serverWord);
                    outObj = new ObjectOutputStream(clientSocket.getOutputStream());
                    outObj.writeObject(constructStudent());
                    outObj.flush();
                    serverWord = in.readLine();
                    System.out.println("Server: " + serverWord);
                    break;
                case (3):
                    out.write("change student" + "\n");
                    out.flush();
                    serverWord = in.readLine();
                    if (serverWord.equals("Access is allowed")) {
                        System.out.println("Successfuly accessed");
                    } else {
                        System.out.println("Access denied. Not enough rights.");
                        break;
                    }
                    System.out.print("Enter student name: ");
                    studentName = inputScanner.nextLine();
                    out.write(studentName + "\n");
                    out.flush();
                    serverWord = in.readLine();
                    System.out.println("Server: " + serverWord);
                    inObj = new ObjectInputStream(clientSocket.getInputStream());
                    Student student = (Student) inObj.readObject();
                    if (student == null) {
                        System.out.println("No such student");
                        break;
                    } else {
                        System.out.println("Student found");
                    }
                    student = editStudent(student);
                    outObj = new ObjectOutputStream(clientSocket.getOutputStream());
                    outObj.writeObject(student);
                    outObj.flush();
                    serverWord = in.readLine();
                    System.out.println("Server: " + serverWord);
                    break;
                case (4)://exit
                    closeThreads();
            }
        }
    }

    /**
     * Runs algorithm, that builds new student by inputed by user data. Consist
     * console interface and input.
     *
     * @return Student object
     */
    public Student constructStudent() {
        Scanner scan = new Scanner(System.in);
        Student newStudent = new Student();
        System.out.print("Enter student name: ");
        newStudent.setName(scan.nextLine());
        for (int index = 0; index < 5; index++) {
            System.out.print("Average mark for term №" + (index + 1) + ": ");
            newStudent.addAverageMark(scan.nextInt());
        }
        return newStudent;
    }

    /**
     * Runs algorithm, that receives Student object and changes it as user want.
     * Consist console interface and input.
     *
     * @param student that will be changed
     * @return changed student
     */
    public Student editStudent(Student student) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        while (true) {
            System.out.println("What to change?\n1-Name\n2-Marks\n3-Finish editing");
            choice = scanner.nextLine();
            switch (choice) {
                case ("1"):
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    if (newName.isEmpty()) {
                        System.out.println("Name cannot be empty!");
                    } else {
                        student.setName(newName);
                    }
                    break;
                case ("2"):
                    student.resetMarks();
                    for (int index = 0; index < 5; index++) {
                        System.out.print("Average mark for term №" + (index + 1) + ": ");
                        student.addAverageMark(scanner.nextInt());
                    }
                    scanner.nextLine();
                    break;
                case ("3"):
                    return student;
                default:
                    System.out.println("Please, choose the correct command number.");
            }
        }
    }

    /**
     * Closes all threads and exiting the programm.
     *
     * @throws IOException
     */
    public void closeThreads() throws IOException {
        inObj.close();
        outObj.close();
        in.close();
        out.close();
        clientSocket.close();
        System.out.println("Connection to the server has been closed");
        System.exit(0);
    }
}
