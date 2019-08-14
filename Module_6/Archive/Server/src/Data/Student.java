/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ArtSCactus
 */
public class Student implements Serializable {

    /**
     * Contains student name.
     *
     */
    private String name;
    /**
     * Contains average marks for term for current student.
     *
     */
    private final List<Integer> averageMarks;

    /**
     * Constructs new student with name and undefind amount of average marks.
     *
     * @param name
     * @param averageMarks
     * @throws NullPointerException if name are null
     */
    public Student(String name, Integer... averageMarks) {
        this.averageMarks = new ArrayList<>();
        if (name == null) {
            throw new NullPointerException("Student name cannot be null");
        }
        if (averageMarks == null) {
            throw new NullPointerException("Average mark cannot be null");
        }

        this.averageMarks.addAll(Arrays.asList(averageMarks));
        this.name = name;
    }

    /**
     * Constracts new student with empty name and average marks.
     *
     */
    public Student() {
        name = "";
        averageMarks = new ArrayList<>();
    }

    /**
     * Returns name of current student.
     *
     * @return student name
     */
    public String getName() {
        return name;
    }

    /**
     * Settings new student name for current student.
     *
     * @param name
     * @throws NullPointerException if name are null
     */
    public void setName(String name) {
        if (name == null) {
            throw new NullPointerException("Student name cannot be null");
        }
        this.name = name;
    }

    /**
     * Returns list with average marks.
     *
     * @return averageMarks as list
     */
    public List<Integer> getAverageMarks() {
        return averageMarks;
    }

    /**
     * Adds new mark to the average marks list.
     *
     * @param mark
     * @throws IllegalArgumentException if mark are less than 0
     */
    public void addAverageMark(int mark) {
        if (mark < 0) {
            throw new IllegalArgumentException("Mark cannot be less than 0");
        }
        averageMarks.add(mark);
    }

    /**
     * Clear average marks list.
     *
     */
    public void resetMarks() {
        averageMarks.clear();
    }

    /**
     * Returns all information about current student as String row.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Student " + name + " Average marks: " + averageMarks.toString();
    }

}
