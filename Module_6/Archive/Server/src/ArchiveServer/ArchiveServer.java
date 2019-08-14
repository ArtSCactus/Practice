package ArchiveServer;

import Data.Account;
import Data.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Server class for Archive project
 * Общие требования к заданию: 
 * • В архиве
 * хранятся Дела (например, студентов). Архив находится на сервере. • Клиент, в
 * зависимости от прав, может запросить дело на просмотр, внести в него
 * изменения, или создать новое дело. Требования к коду лабораторной работы: •
 * Для реализации сетевого соединения используйте сокеты. • Формат хранения
 * данных на сервере – xml-файлы.
 *
 * @author ArtSCactus
 * @version 0.8
 */
public class ArchiveServer {

    private ObjectInputStream inObj;
    private ObjectOutputStream outObj;
    private List<Student> students = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private String accountStoragePath;
    private String studentsStoragePath;
    private Account currentUser;

    private Socket clientSocket; // socket for client
    private ServerSocket server; // socket for server
    private BufferedReader in; // text thread from client
    private BufferedWriter out; // text thread to client

    public ArchiveServer(String accountStoragePath, String studentsStoragePath) throws IOException, SAXException, ParserConfigurationException {
        if (accountStoragePath == null | studentsStoragePath == null) {
            throw new NullPointerException("Path cannot be null");
        }
        this.accountStoragePath = accountStoragePath;
        this.studentsStoragePath = studentsStoragePath;
        File accountStorage = new File(studentsStoragePath);
        if (!accountStorage.exists()) {
            accountStorage.createNewFile();
        }
        File studentsStorage = new File(studentsStoragePath);
        if (!studentsStorage.exists()) {
            studentsStorage.createNewFile();
        }
        loadAccounts();
        loadDataBase();
    }

    private void loadAccounts() throws FileNotFoundException, IOException, SAXException, ParserConfigurationException {
        File accountStorage = new File(studentsStoragePath);
        if (!accountStorage.exists()) {
            accountStorage.createNewFile();
            return;
        }
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        DefaultHandler defaultHandler = new DefaultHandler() {
            Account user;
            boolean userTag = false;
            boolean rightsTag = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equals("user")) {
                    user = new Account();
                    user.setLogin(attributes.getValue(0));
                    user.setPassword(attributes.getValue(1));
                    userTag = true;
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                //  System.out.println("End element: " + qName);
                if (qName.equals("user")) {
                    userTag = false;
                    accounts.add(user);
                }
            }

            @Override
            public void characters(char ch[], int start, int length) throws SAXException {
                //   System.out.println("Tag value: " + new String(ch, start, length));
                if (userTag == true) {
                    if (new String(ch, start, length).equals("admin")) {
                        user.setRightsStatus(true);
                    } else {
                        user.setRightsStatus(false);
                    }
                }
            }
        };
        saxParser.parse(accountStoragePath, defaultHandler);
    }

    private void saveAccounts() throws SAXException, IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(accountStoragePath);
        Node root = document.getElementsByTagName("users").item(0);
        if (root == null) {
            root = document.createElement("users");
        }
        NodeList nodelist = root.getChildNodes();
        for (int index = 0; index < nodelist.getLength(); index++) {
            root.removeChild(nodelist.item(index));
        }
        for (int index = 0; index < accounts.size(); index++) {
            Element user = document.createElement("user");
            user.setAttribute("login", accounts.get(index).getLogin());
            user.setAttribute("password", accounts.get(index).getPassword());
            if (accounts.get(index).getRightsStatus()) {
                // user.setNodeValue("admin");
                user.setTextContent("admin");
            } else {
                // user.setNodeValue("user");
                user.setTextContent("user");
            }
            root.appendChild(user);
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(accountStoragePath));

        transformer.transform(domSource, streamResult);
    }

    private void loadDataBase() throws SAXException, IOException, ParserConfigurationException {
        File studentsStorage = new File(studentsStoragePath);
        if (!studentsStorage.exists()) {
            studentsStorage.createNewFile();
            return;
        }
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        DefaultHandler defaultHandler = new DefaultHandler() {
            Student student;
            boolean termTag = false;
            boolean studentTag = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equals("student")) {
                    studentTag = true;
                    student = new Student();
                    student.setName(attributes.getValue(0));
                }
                if (qName.equals("term")) {
                    termTag = true;
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (qName.equals("student")) {
                    studentTag = false;
                    students.add(student);
                }
                if (qName.equals("term")) {
                    termTag = false;
                }
            }

            @Override
            public void characters(char ch[], int start, int length) throws SAXException {
                if (termTag == true) {
                    student.addAverageMark(Integer.parseInt(new String(ch, start, length)));
                }
            }
        };
        saxParser.parse(studentsStoragePath, defaultHandler);
    }

    public void saveStudents() throws TransformerException, IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(studentsStoragePath);
        Node root = document.getElementsByTagName("students").item(0);
        if (root == null) {
            root = document.createElement("students");
        }
        document.removeChild(root);
        root = document.createElement("students");
        document.appendChild(root);

        for (int index = 0; index < students.size(); index++) {
            Element student = document.createElement("student");
            root.appendChild(student);
            student.setAttribute("name", students.get(index).getName());

            for (int termIndex = 0; termIndex < students.get(index).getAverageMarks().size(); termIndex++) {
                Element sem = document.createElement("term");
                sem.appendChild(document.createTextNode(Integer.toString(students.get(index).getAverageMarks().get(termIndex))));
                sem.setNodeValue(Integer.toString(students.get(index).getAverageMarks().get(termIndex)));
                student.appendChild(sem);
            }
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(studentsStoragePath));

        transformer.transform(domSource, streamResult);
    }

    private boolean signIn(String login, String password) {
        for (Account account : accounts) {
            if (account.logIn(login, password)) {
                currentUser = account;
                return true;
            }
        }
        return false;
    }

    public void addStudent(Student student) throws IOException, TransformerException, SAXException, ParserConfigurationException {
        if (currentUser.getRightsStatus()) {
            if (student == null) {
                throw new NullPointerException();
            }
            students.add(student);
            saveStudents();
            System.out.println("New student has been added: " + student.toString());
        }
    }

    public void addAccount(String login, String password) throws IOException, TransformerException, SAXException, ParserConfigurationException {
        if (login == null | password == null) {
            throw new NullPointerException("Login or password cannot be null");
        }
        accounts.add(new Account(login, password));
        saveAccounts();
        System.out.println("New account has been registred");
    }

    public void addAccount(Account user) throws IOException, TransformerException, SAXException, ParserConfigurationException {
        if (user == null) {
            throw new NullPointerException("Account cannot be null");
        }
        accounts.add(user);
        saveAccounts();
        System.out.println("New account has been registred");
    }

    public Student findStudent(String studentName) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(studentName)) {
                return student;
            }
        }
        return null;
    }

    public boolean isAuthorized() {
        if (currentUser == null) {
            return false;
        } else {
            return true;
        }
    }

    public void run() throws IOException, ClassNotFoundException, TransformerException, SAXException, ParserConfigurationException {
        try {
            try {
                loadDataBase();
                server = new ServerSocket(4004);
                System.out.println("Server successfully started");
                clientSocket = server.accept();
                try {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    String login;
                    String password;
                    try {
                        while (true) {
                            System.out.println("Waiting for command");
                            String word = in.readLine();
                            System.out.println("Client command: " + word);
                            switch (word) {
                                case ("sign in"):
                                    word = in.readLine();
                                    login = word;
                                    System.out.println("Client: " + word);
                                    word = in.readLine();
                                    System.out.println("Client: " + word);
                                    password = word;
                                    if (signIn(login, password)) {
                                        out.write("successfull" + "\n");
                                        out.flush();
                                    } else {
                                        out.write("fail" + "\n");
                                        out.flush();
                                    }
                                    break;
                                case ("sign up"):
                                    System.out.println("registring new account");
                                    word = in.readLine();
                                    login = word;
                                    word = in.readLine();
                                    System.out.println("Client: " + word);
                                    password = word;
                                    addAccount(login, password);
                                    out.write("Successfully registred new account" + "\n");
                                    out.flush();
                                    break;
                                case ("get student"):
                                    out.write("Got you, will be searching the student. I'm waiting for student name." + "\n");
                                    out.flush();
                                    word = in.readLine();
                                    out.write("Ok, his name " + word + ", i'll search such student." + "\n");
                                    out.flush();
                                    Student foundedStudent = findStudent(word);
                                    if (foundedStudent != null) {
                                        out.write("Found him: " + foundedStudent.toString() + "\n");
                                        out.flush();
                                    } else {
                                        out.write("Not found");
                                        out.flush();
                                    }
                                    break;
                                case ("add student"):
                                    if (!currentUser.getRightsStatus()) {
                                        out.write("Access denied");
                                        out.flush();
                                        break;
                                    }
                                    out.write("Got you, will be adding new student. I'm waiting for student object" + "\n");
                                    out.flush();
                                    // outObj= new ObjectOutputStream(clientSocket.getOutputStream());
                                    //outObj.writeObject(students.get(0));
                                    //outObj.flush();
                                    inObj = new ObjectInputStream(clientSocket.getInputStream());
                                    addStudent((Student) inObj.readObject());
                                    out.write("Successfully added" + "\n");
                                    out.flush();
                                    break;
                                case ("change student"):
                                    if (!currentUser.getRightsStatus()) {
                                        out.write("Access denied" + "\n");
                                        out.flush();
                                        break;
                                    } else {
                                        out.write("Access is allowed" + "\n");
                                        out.flush();
                                    }
                                    word = in.readLine();
                                    String studentName = word;
                                    out.write("Ok, his name " + word + ", i'll search such student." + "\n");
                                    out.flush();
                                    outObj = new ObjectOutputStream(clientSocket.getOutputStream());
                                    int indexSaver = getStudentIndexInList(findStudent(studentName));
                                    outObj.writeObject(findStudent(studentName));
                                    outObj.flush();
                                    inObj = new ObjectInputStream(clientSocket.getInputStream());
                                    Student changedStudent = (Student) inObj.readObject();
                                    students.set(indexSaver, changedStudent);
                                    saveStudents();
                                    out.write("Successfully changed" + "\n");
                                    out.flush();
                                    System.out.println("Student has been successfully changed.");
                                    break;
                                default:
                                    out.write("I'm sorry, due some errors something is gone wrong. " + "\n");
                                    out.flush();
                                    break;
                            }
                        }
                    } catch (SocketException ex) {
                        System.out.println("Client has cutted down the connection.");
                    }
                } finally {
                    clientSocket.close();
                    in.close();
                    out.close();
                    inObj.close();
                    outObj.close();
                }
            } finally {
                System.out.println("Server has been closed");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public int getStudentIndexInList(Student student) {
        boolean targetFound = false;
        for (int index = 0; index < students.size(); index++) {
            if (student.getName().equals(students.get(index).getName())) {
                targetFound = true;
                for (int markIndex = 0; markIndex < students.get(index).getAverageMarks().size(); markIndex++) {
                    if (student.getAverageMarks().get(markIndex) == students.get(index).getAverageMarks().get(markIndex)) {
                        targetFound = true;
                    } else {
                        targetFound = false;
                        break;
                    }
                }
                if (targetFound) {
                    return index;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException, ClassNotFoundException {
        ArchiveServer server = new ArchiveServer("data\\Accounts storage.xml", "data\\Student base.xml");
        server.run();
    }
}
