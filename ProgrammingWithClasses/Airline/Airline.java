/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses.Airline;

import java.util.Calendar;

/**
 * Task condition:
 *10. Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и методами. Задать критерии выбора данных и вывести эти данные на консоль.
Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
Найти и вывести:
a) список рейсов для заданного пункта назначения;
b) список рейсов для заданного дня недели;
c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 * @author ArtSCactus
 */
public class Airline {
    private String destinationName;
    private int flightNumber;
    private String planeType;
    private Calendar departureTime;
   
    /**
     *
     * @param destinationName
     * @param flightNumber
     * @param planeType
     * @param departureTime
     * @param day
     */
    public Airline(String destinationName, int flightNumber, String planeType, Calendar departureTime) {
        this.destinationName = destinationName;
        this.flightNumber = flightNumber;
        this.planeType = planeType;
        this.departureTime = departureTime;
    }

    /**
     *
     * @return
     */
    public String getDestinationName() {
        return destinationName;
    }

    /**
     *
     * @param destinationName
     */
    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    /**
     *
     * @return
     */
    public int getFlightNumber() {
        return flightNumber;
    }

    /**
     *
     * @param flightNumber
     */
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     *
     * @return
     */
    public String getPlaneType() {
        return planeType;
    }

    /**
     *
     * @param planeType
     */
    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    /**
     *
     * @return
     */
    public Calendar getDepartureTime() {
        return departureTime;
    }

    /**
     *
     * @param departureTime
     */
    public void setDepartureTime(Calendar departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "Airline: \n" + "Destination name=" + destinationName + "\nFlight number=" + flightNumber + "\nPlane type=" + planeType + "\nDeparture time=" + departureTime.getTime()+"\n";
    }
    
}
