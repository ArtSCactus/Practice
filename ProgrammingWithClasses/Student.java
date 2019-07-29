/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Task condition: 3. Создайте класс с именем Student, содержащий поля: фамилия
 * и инициалы, номер группы, успеваемость (массив из пяти элементов). Создайте
 * массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
 * номеров групп студентов, имеющих оценки, равные только 9 или 10.
 *
 * @author ArtSCactus
 */
public class Student {

    private String surnameAndInitials;
    private String group;
    private int[] progress = new int[5];

    /**
     * Constructs the inforamtion about student. If one of the <code>String</code>
     * arguments are null, gerenating <code>IllegalArgumentException</code>. If
     * progress array (<code>progress</code>) length are bigger than 5 or equals
     * 0, then also generationg <code>IllegalArgumentException</code>. If
     * progress array (<code>progress</code>) length less than 5 and bigger than
     * 0, then the array fills to the size of 5 elements. Added items are 0. If
     * any element of progress array (<code>progress</code>) are bigger than 10
     * or less than 0, then also generationg
     * <code>IllegalArgumentException</code>.
     *
     * @param surnameAndInitials
     * @param group
     * @param progress
     * @throws IllegalArgumentException
     */
    public Student(String surnameAndInitials, String group, int[] progress) throws IllegalArgumentException {
        if (surnameAndInitials == null || group == null) {
            throw new IllegalArgumentException();
        }
        if (progress.length > 5) {
            throw new IllegalArgumentException("Progress array length more than 5: "+progress.length);
        } else {
            progress = Arrays.copyOf(progress, progress.length + (5 - progress.length));
        }
        for (int currentProgressForGrade : progress) {
            if (currentProgressForGrade > 10 || currentProgressForGrade < 0) {
                throw new IllegalArgumentException("One of the marks for grade are more than 10 or less than 0: "+currentProgressForGrade);
            }
        }
        this.surnameAndInitials = surnameAndInitials;
        this.group = group;
        this.progress = progress;
    }

    /**
     * Returns progress array (<code>int[] progress</code>).
     *
     * @return
     */
    public int[] getProgress() {
        return progress;
    }

    /**
     * Setting a new elements instead old to the progress of student
     * (<code>progress</code>).
     *
     * @param progress
     */
    public void setProgress(int[] progress) {
        if (progress.length > 5) {
            throw new IllegalArgumentException();
        } else {
            progress = Arrays.copyOf(progress, progress.length + (5 - progress.length));
        }
        this.progress = progress;
    }

    /**
     * Returns true if all marks of student (<code>int[] progress</code>) are 9 or 10.
     * Otherwise returns false.
     *
     * @return
     */
    public boolean isExcellentStudent() {
        for (int currentProgressForGrade : progress) {
            if (currentProgressForGrade < 9) {
                return false;
            }
        }
        return true;
    }

    /**
     * Printing student name (<code>String surnameAndInitials</code>) and student group
     * (<code>group</code>) to console.
     *
     */
    public void printNameAndGroup() {
        System.out.println("Student name: " + surnameAndInitials + "\nStudent group: " + group);
    }

    /**
     * Returns student name (<code>String surnameAndinitials</code>).
     *
     * @return
     */
    public String getSurnameAndInitials() {
        return surnameAndInitials;
    }

    /**
     * Setting new value to student name (<code>String surnameAndInitials</code>).
     *
     * @param surnameAndInitials If this argument are null throws
     * IllegalArgumentException;
     * @throws IllegalArgumentException
     */
    public void setSurnameAndInitials(String surnameAndInitials) throws IllegalArgumentException {
        if (surnameAndInitials == null) {
            throw new IllegalArgumentException();
        }
        this.surnameAndInitials = surnameAndInitials;
    }

    /**
     * Returns student group (<code>String group</code>).
     *
     * @return
     */
    public String getGroup() {
        return group;
    }

    /**
     * Setting new value to student group (<code>String group</code>).
     *
     * @param group If this argument are <tt>null</tt> throws
     * IllegalArgumentException;
     * @throws IllegalArgumentException
     */
    public void setGroup(String group) throws IllegalArgumentException {
        if (group == null) {
            throw new IllegalArgumentException();
        }
        this.group = group;
    }

    /**
     * Method to test how class Student works.
     *
     */
    static void testClass() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иванов С.А.", "750205", new int[]{9, 9, 10, 9, 9}));
        students.add(new Student("Козлов К.Р.", "750205", new int[]{10, 9, 10, 9, 10}));
        students.add(new Student("Беляков Р.С.", "750313", new int[]{9, 8, 10, 9, 9}));
        students.add(new Student("Антонов А.А.", "650240", new int[]{3, 2, 1, 4, 5}));
        students.add(new Student("Кирилюк Г.П.", "6502240", new int[]{9, 9, 5, 6, 7}));
        students.add(new Student("Петров Д.И.", "829453", new int[]{9, 9, 10}));
        students.add(new Student("Ивашенко В.П.", "Марсианская колония", new int[]{10, 10, 10, 10, 10}));
        students.add(new Student("Горбачёв М.С.", "193188", new int[]{9, 5, 10, 9, 9}));
        students.add(new Student("Васильев В.В.", "890205", new int[]{9, 9, 10, 9, 9}));
        students.add(new Student("Петроненко К.О.", "321205", new int[]{9, 9, 10, 9, 4}));
        for (Student student : students) {
            if (student.isExcellentStudent()) {
                student.printNameAndGroup();
            }
        }
    }
}
