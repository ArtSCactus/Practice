/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Module_6.Notepad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Задание 2. Блокнот. Разработать консольное приложение, работающее с Заметками
 * в Блокноте. Каждая Заметка это: Заметка (тема, дата создания, e-mail,
 * сообщение). Общие пояснения к практическому заданию. • В начале работы
 * приложения данные должны считываться из файла, в конце работы – сохраняться в
 * файл. • У пользователя должна быть возможность найти запись по любому
 * параметру или по группе параметров (группу параметров можно определить
 * самостоятельно), получить требуемые записи в отсортированном виде, найти
 * записи, текстовое поле которой содержит определенное слово, а также добавить
 * новую запись. • Особое условие: поиск, сравнение и валидацию вводимой
 * информации осуществлять с использованием регулярных выражений. • Особое
 * условие: проверку введенной информации на валидность должен осуществлять код,
 * непосредственно добавляющий информацию.
 *
 * @author ArtSCactus
 * @version 1.0
 */
public class Notepad {

    /**
     * Needs to store file that we are working with.
     *
     */
    private File notebook;
    /**
     * Needs to load notes list from file.
     *
     */
    private FileReader fromFile;
    /**
     * Needs to write current notes list to file.
     *
     */
    private FileWriter toFile;
    /**
     * Needs to store notes.
     *
     */
    private List<Note> notes;
    /**
     * Regexp to find notes whick look like
     * dd/mm/yyyy|email@mail.com|topic|message.
     *
     */
    private final Pattern NOTE_TEMPLATE = Pattern.compile("[0-3][0-9]\\/[0-3][0-9]\\/[0-9]{4}\\|\\w+\\@\\w+\\.(com|ru|by|net)\\|.+?\\|.+");
    /**
     * Regexp that recognizes email address.
     *
     */
    private final Pattern EMAIL_TEMPLATE = Pattern.compile("\\w+\\@\\w+\\.(com|ru|by|net)");
    /**
     * Matcher to use patterns.
     *
     */
    private Matcher matcher;

    /**
     * Constructs notepad with file by given path. If such file does not exists,
     * it will be created.
     *
     * @param filePath
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     * @throws NullPointerException if filePath are null
     */
    public Notepad(String filePath) throws FileNotFoundException, IOException, ParseException {
        if (filePath == null) {
            throw new NullPointerException("File path cannot be null");
        }
        notebook = new File(filePath);
        if (!notebook.createNewFile()) {
            fromFile = new FileReader(notebook);
            BufferedReader scanner = new BufferedReader(fromFile);
            String currentRow;
            String[] separatedRow;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            while (scanner.ready()) {
                currentRow = scanner.readLine();
                matcher = NOTE_TEMPLATE.matcher(currentRow);
                if (matcher.find()) {
                    separatedRow = currentRow.split("\\|");
                    notes.add(new Note(format.parse(separatedRow[0]), separatedRow[1], separatedRow[2], separatedRow[3]));
                }
            }
            fromFile.close();
        }
    }

    /**
     * Constructs notepad with given. If such file does not exists, it will be
     * created. Otherwise note list are loading from this file.
     *
     * @param notebook
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     * @throws NullPointerException if notebook are null
     */
    public Notepad(File notebook) throws FileNotFoundException, IOException, ParseException {
        if (notebook == null) {
            throw new NullPointerException("File path cannot be null");
        }
        this.notebook = notebook;
        notes = new ArrayList<>();
        if (!notebook.createNewFile()) {
            fromFile = new FileReader(notebook);
            BufferedReader scanner = new BufferedReader(fromFile);
            String currentRow;//to store current readed row
            String[] separatedRow;//to store parts of note in case of match
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");//format of date that will be parsing
            while (scanner.ready()) {
                currentRow = scanner.readLine();
                matcher = NOTE_TEMPLATE.matcher(currentRow);
                if (matcher.find()) {
                    separatedRow = currentRow.split("\\|");
                    notes.add(new Note(format.parse(separatedRow[0]), separatedRow[1], separatedRow[2], separatedRow[3]));
                }
            }
            fromFile.close();
        }
    }

    /**
     * Saves notes list to file. Ыsed only when exiting the application
     *
     * @throws IOException
     */
    private void saveNotes() throws IOException {
        toFile = new FileWriter(notebook);
        for (Note note : notes) {
            toFile.write(note.toString() + "\n");
        }
        toFile.close();
    }

    /**
     * Adds new note to notes list (not saving to file). Date is sets
     * automatically to the current date. Input of all fields are making in this
     * method.
     *
     */
    public void addNote() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter note topic: ");
        String topic = scanner.nextLine();
        System.out.print("Enter email: ");
        String email;
        Matcher emailFinder;
        while (true) {
            email = scanner.nextLine();
            emailFinder = EMAIL_TEMPLATE.matcher(email);
            if (emailFinder.find()) {
                email = emailFinder.group();
                break;
            } else {
                System.out.print("Email not found or not correct. Try again: ");
            }
        }
        System.out.print("Enter note's message (symbol | are reserved): ");
        String message = scanner.nextLine();
        Date currentDate = new Date();
        notes.add(new Note(currentDate, email, topic, message));
        System.out.println("Note successfully added");
    }

    /**
     * Removes first meeted note with inputed by user characteristics(topic and
     * email). Topic and email input are making by this function.
     *
     */
    public void deleteNote() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter note topic: ");
        String topic = scanner.nextLine();
        System.out.print("Enter email: ");
        String email;
        Matcher emailFinder;
        while (true) {
            email = scanner.nextLine();
            emailFinder = EMAIL_TEMPLATE.matcher(email);
            if (emailFinder.find()) {
                email = emailFinder.group();
                break;
            } else {
                System.out.print("Email not found or not correct. Try again: ");
            }
        }
        for (int index = 0; index < notes.size(); index++) {
            if (notes.get(index).getEmail().equals(email) & notes.get(index).getTopic().equals(topic)) {
                notes.remove(index);
                System.out.println("Successfully removed");
                break;
            }
        }
    }

    /**
     * Searchs and collects to the list matched notes, then returns sorted by
     * topic list.
     *
     * @param topic
     * @param email
     * @throws NullPointerException if atleast topic or email are null
     * @return matched notes in ArrayList
     */
    public List<Note> findNote(String topic, String email) {
        if (topic == null | email == null) {
            throw new NullPointerException("Topic or email cannot be null");
        }
        List<Note> matchedNotes = new ArrayList<>();
        for (Note note : notes) {
            if (note.getEmail().equals(email) & note.getTopic().equals(topic)) {
                matchedNotes.add(note);
            }
        }
        //Sorting by topic
        Collections.sort(matchedNotes, new Comparator<Note>() {
            @Override
            public int compare(Note noteOne, Note noteTwo) {
                return noteOne.getTopic().compareTo(noteTwo.getTopic());
            }
        });
        return matchedNotes;
    }

    /**
     * Searchs and collects to the list matched notes, then returns sorted by
     * topic list.
     *
     * @param topic
     * @param date
     * @throws NullPointerException if atleast topic or date are null
     * @return matched notes in ArrayList
     */
    public List<Note> findNote(Date date, String topic) {
        List<Note> matchedNotes = new ArrayList<>();
        for (Note note : notes) {
            if (note.getCreationDate().equals(date) & topic.equals(note.getTopic())) {
                matchedNotes.add(note);
            }
        }
        //Sorting by topic
        Collections.sort(matchedNotes, new Comparator<Note>() {
            @Override
            public int compare(Note noteOne, Note noteTwo) {
                return noteOne.getTopic().compareTo(noteTwo.getTopic());
            }
        });
        return matchedNotes;
    }

    /**
     * Returns list with all notes.
     *
     * @return notes
     */
    public List<Note> getAllNotes() {
        return notes;
    }

    /**
     * Searchs and collects to the list matched notes, then returns sorted by
     * topic list.
     *
     * @param email
     * @throws NullPointerException if email are null
     * @return matched notes in ArrayList
     */
    public List<Note> findNoteByEmail(String email) {
        List<Note> matchedNotes = new ArrayList<>();
        for (Note note : notes) {
            if (note.getEmail().equals(email)) {
                matchedNotes.add(note);
            }
        }
        //Sorting by topic
        Collections.sort(matchedNotes, new Comparator<Note>() {
            @Override
            public int compare(Note noteOne, Note noteTwo) {
                return noteOne.getTopic().compareTo(noteTwo.getTopic());
            }
        });
        return matchedNotes;
    }

    /**
     * Searchs and collects to the list matched notes, then returns sorted by
     * topic list.
     *
     * @param date
     * @throws NullPointerException date are null
     * @return matched notes in ArrayList
     */
    public List<Note> findNoteByDate(Date date) {
        List<Note> matchedNotes = new ArrayList<>();
        for (Note note : notes) {
            if (note.getCreationDate().compareTo(date) == 0) {
                matchedNotes.add(note);
            }
        }
        //Sorting by topic
        Collections.sort(matchedNotes, new Comparator<Note>() {
            @Override
            public int compare(Note noteOne, Note noteTwo) {
                return noteOne.getTopic().compareTo(noteTwo.getTopic());
            }
        });
        return matchedNotes;
    }

    /**
     * Searchs and collects to the list matched notes, then returns sorted by
     * topic list.
     *
     * @param topic
     * @throws NullPointerException topic are null
     * @return matched notes in ArrayList
     */
    public List<Note> findNoteByTopic(String topic) {
        List<Note> matchedNotes = new ArrayList<>();
        for (Note note : notes) {
            if (note.getTopic().equals(topic)) {
                matchedNotes.add(note);
            }
        }
        //Sorting by topic
        Collections.sort(matchedNotes, new Comparator<Note>() {
            @Override
            public int compare(Note noteOne, Note noteTwo) {
                return noteOne.getTopic().compareTo(noteTwo.getTopic());
            }
        });
        return matchedNotes;
    }

    /**
     * Searchs and collects to the list matched notes, then returns sorted by
     * topic list.
     *
     * @param message
     * @throws NullPointerException message are null
     * @return matched notes in ArrayList
     */
    public List<Note> findNoteByMessage(String message) {
        List<Note> matchedNotes = new ArrayList<>();
        for (Note note : notes) {
            if (note.getMessage().equals(message)) {
                matchedNotes.add(note);
            }
        }
        //Sorting by topic
        Collections.sort(matchedNotes, new Comparator<Note>() {
            @Override
            public int compare(Note noteOne, Note noteTwo) {
                return noteOne.getTopic().compareTo(noteTwo.getTopic());
            }
        });
        return matchedNotes;
    }

    /**
     * Runs a menu, that connected to all search types of class Notepad. Consist
     * it's own interface.
     */
    private void runSearchSystem() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Choose type of search:"
                + "\n1-By date"
                + "\n2-By email"
                + "\n3-By topic"
                + "\n4-By message"
                + "\n5-By date and topic"
                + "\n6-By email and topic");
        choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case (1)://By date
                System.out.print("Input date: ");
                String dateAsRow;
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date date;
                while (true) {
                    dateAsRow = scanner.nextLine();
                    try {
                        date = format.parse(dateAsRow);
                        break;
                    } catch (ParseException ex) {
                        System.out.println("Wrong date type. Please, input like dd/mm/yyyy");
                    }
                }
                List<Note> foundedNotes = findNoteByDate(date);
                if (foundedNotes.isEmpty()) {
                    System.out.println("No match found");
                } else {
                    System.out.println("Founded notes: ");
                    for (Note note : foundedNotes) {
                        System.out.println(note.toString());
                    }
                }
                break;
            case (2)://By email
                System.out.print("Enter email: ");
                String email;
                Matcher emailFinder;
                while (true) {
                    email = scanner.nextLine();
                    emailFinder = EMAIL_TEMPLATE.matcher(email);
                    if (emailFinder.find()) {
                        email = emailFinder.group();
                        break;
                    } else {
                        System.out.print("Email not found or not correct. Try again: ");
                    }
                }
                foundedNotes = findNoteByEmail(email);
                if (foundedNotes.isEmpty()) {
                    System.out.println("No match found");
                } else {
                    System.out.println("Founded notes: ");
                    for (Note note : foundedNotes) {
                        System.out.println(note.toString());
                    }
                }
                break;
            case (3)://By topic
                System.out.print("Enter topic: ");
                String topic = scanner.nextLine();
                foundedNotes = findNoteByTopic(topic);
                if (foundedNotes.isEmpty()) {
                    System.out.println("No match found");
                } else {
                    System.out.println("Founded notes: ");
                    for (Note note : foundedNotes) {
                        System.out.println(note.toString());
                    }
                }
                break;
            case (4)://By message
                System.out.print("Enter message: ");
                String message = scanner.nextLine();
                foundedNotes = findNoteByMessage(message);
                if (foundedNotes.isEmpty()) {
                    System.out.println("No match found");
                } else {
                    System.out.println("Founded notes: ");
                    for (Note note : foundedNotes) {
                        System.out.println(note.toString());
                    }
                }
                break;
            case (5)://By date and message
                System.out.print("Input date: ");
                dateAsRow = scanner.nextLine();
                format = new SimpleDateFormat("dd/MM/yyyy");
                while (true) {
                    try {
                        date = format.parse(dateAsRow);
                        break;
                    } catch (ParseException ex) {
                        System.out.println("Wrong date type. Please, input like dd/mm/yyyy");
                    }
                }
                System.out.print("Enter topic: ");
                topic = scanner.nextLine();
                foundedNotes = findNote(date, topic);
                if (foundedNotes.isEmpty()) {
                    System.out.println("No match found");
                } else {
                    System.out.println("Founded notes: ");
                    for (Note note : foundedNotes) {
                        System.out.println(note.toString());
                    }
                }
                break;
            case (6)://By email and topic
                System.out.print("Enter email: ");
                email = scanner.nextLine();
                emailFinder = EMAIL_TEMPLATE.matcher(email);
                while (true) {
                    if (emailFinder.find()) {
                        email = emailFinder.group();
                        break;
                    } else {
                        System.out.print("Email not found or not correct. Try again: ");
                        email = scanner.nextLine();
                    }
                }
                System.out.print("Enter topic: ");
                topic = scanner.nextLine();
                foundedNotes = findNote(topic, email);
                if (foundedNotes.isEmpty()) {
                    System.out.println("No match found");
                } else {
                    System.out.println("Founded notes: ");
                    for (Note note : foundedNotes) {
                        System.out.println(note.toString());
                    }
                }
                break;
        }

    }

    /**
     * Runs application. Consist it's own inteface.
     *
     *
     * @throws IOException
     */
    public void run() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("~~~~~~~~~~Menu~~~~~~~~~~"
                    + "\n1-Add note"
                    + "\n2-Delete Note"
                    + "\n3-Find note"
                    + "\n4-Print all notes"
                    + "\n5-Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case (1):
                    addNote();
                    break;
                case (2):
                    deleteNote();
                    break;
                case (3):
                    runSearchSystem();
                    break;
                case (4):
                    System.out.println("Notepad consist " + notes.size() + " notes: ");
                    for (Note note : getAllNotes()) {
                        System.out.println(note.toString());
                    }
                    break;
                case (5):
                    saveNotes();
                    System.exit(0);
                default:
                    System.out.println("Wrong command number");
                    break;
            }
        }
    }
}
