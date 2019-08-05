/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.BasicsOfOOP.Task_3;

import java.util.ArrayList;
import java.util.List;

/**
 * Task condition: Создать класс Календарь с внутренним классом, с помощью
 * объектов которого можно хранить информацию о выходных и праздничных днях.
 *
 * @author ArtSCactus
 */
public class HolidayCalendar {

    private List<Holiday> holidays = new ArrayList<>();

    /**
     *
     */
    public class Holiday {

        private String name;
        private int day;
        private int month;

        /**
         *
         * @param name
         * @param month
         * @param day
         */
        public Holiday(String name, int month, int day) {
            if (name == null) {
                throw new NullPointerException("Holiday name cannot be null");
            }
            if (month < 0 | day < 0 | month > 12 | day > 31) {
                throw new IllegalArgumentException("Date is not correct");
            }
        }

        /**
         *
         * @return
         */
        public String getName() {
            return name;
        }

        /**
         *
         * @param name
         */
        public void setName(String name) {
            if (name == null) {
                throw new NullPointerException("Holiday name cannot be null");
            }
            this.name = name;
        }

        /**
         *
         * @param name
         * @param day
         * @param month
         */
        public void setHolidayDate(String name, int day, int month) {
            if (name == null) {
                throw new NullPointerException("Holiday name cannot be null");
            }
            if (month < 0 | day < 0 | month > 12 | day > 31) {
                throw new IllegalArgumentException("Date is not correct");
            }
            this.day = day;
            this.month = month;
        }

        /**
         *
         * @return
         */
        public int getDay() {
            return day;
        }

        /**
         *
         * @param day
         */
        public void setDay(int day) {
            if (day > 31 | day < 0) {
                throw new IllegalArgumentException("Day cannot be less than 0 and bigger than 31");
            }
            this.day = day;
        }

        /**
         *
         * @return
         */
        public int getMonth() {
            return month;
        }

        /**
         *
         * @param month
         */
        public void setMonth(int month) {
            if (month > 12 | month < 0) {
                throw new IllegalArgumentException("Month cannot be less than 0 and bigger than 12");
            }
            this.month = month;
        }

        @Override
        public String toString() {
            return "Holiday " + name + " Date: " + day + "." + month;
        }

    }

    /**
     *
     * @param name
     * @param month
     * @param dayOfMonth
     */
    public void addHoliday(String name, int month, int dayOfMonth) {
        holidays.add(new Holiday(name, month, dayOfMonth));
    }

    /**
     *
     * @param name
     */
    public void removeHoliday(String name) {
        for (int index = 0; index < holidays.size(); index++) {
            if (holidays.get(index).getName().equalsIgnoreCase(name)) {
                holidays.remove(index);
                index--;
            }
        }
    }

    /**
     *
     * @param month
     * @param day
     */
    public void removeHoliday(int month, int day) {
        for (int index = 0; index < holidays.size(); index++) {
            if (holidays.get(index).day == day & holidays.get(index).month == month) {
                holidays.remove(index);
                index--;
            }
        }
    }

    /**
     *
     */
    public void toConsole() {
        for (Holiday holiday : holidays) {
            System.out.println(holiday.toString() + "\n");
        }
    }
}
