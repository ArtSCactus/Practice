/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses.Airline;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Task condition: 10. Создать класс Airline, спецификация которого приведена
 * ниже. Определить конструкторы, set- и get- методы и метод toString(). Создать
 * второй класс, агрегирующий массив типа Airline, с подходящими конструкторами
 * и методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни
 * недели. Найти и вывести: a) список рейсов для заданного пункта назначения; b)
 * список рейсов для заданного дня недели; c) список рейсов для заданного дня
 * недели, время вылета для которых больше заданного.
 *
 * @author ArtSCactus
 */
public class Airlines {

    private Airline[] airlines;

    public Airlines(Airline... airlines) {
        if (airlines == null) {
            throw new NullPointerException("Given array are null");
        } else {
            this.airlines = airlines;
        }
    }
/** Prints to console all flight to the given destination name.
 * 
 * @param destinationName 
 */
    public void printFlightsByDestinationName(String destinationName) {
        for (Airline airline : airlines) {
            if (airline.getDestinationName().equalsIgnoreCase(destinationName)) {
                System.out.println("Match found:\n" + airline.toString() + "-------------------");
            }
        }
    }
/** Prints to console all flight in a given day.
 * 
 * @param day 
 */
    public void printFlightsByDayOfWeek(Calendar day) {
        for (Airline airline : airlines) {
            if (airline.getDepartureTime().get(Calendar.DAY_OF_YEAR) == day.get(Calendar.DAY_OF_YEAR)) {
                System.out.println("Match found:\n" + airline.toString() + "-------------------");
            }
        }
    }
/** Prints to console all flight after given time in a given day.
 * 
 * @param date 
 */
    public void printFlightByDayAndTime(Calendar date) {
        for (Airline airline : airlines) {
            if (airline.getDepartureTime().get(Calendar.DAY_OF_WEEK) == date.get(Calendar.DAY_OF_WEEK) & airline.getDepartureTime().after(date)) {
                System.out.println("Match found:\n" + airline.toString() + "-------------------");
            }
        }

    }

    public static void testClass() {
        Airlines airlines = new Airlines(
                new Airline("Moscow", 4569, "Cargo", new GregorianCalendar(2019, 6, 30, 12, 0)),
                new Airline("Paris", 4382, "Passanger", new GregorianCalendar(2019, 6, 30, 12, 0, 0)),
                new Airline("Minsk", 1982, "Passanger", new GregorianCalendar(2019, 6, 30, 12, 35))
        );
        System.out.println("Day and time test: ");
        airlines.printFlightByDayAndTime(new GregorianCalendar(2019, 6, 30, 12, 30));
        System.out.println("Day test: ");
        airlines.printFlightsByDayOfWeek(new GregorianCalendar(2019, 6, 30));
        System.out.println("Destination name test: ");
        airlines.printFlightsByDestinationName("Moscow");
    }
}
