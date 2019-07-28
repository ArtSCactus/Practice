/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Task condition:
 *  4. Создайте класс Train, содержащий поля: название пункта
 * назначения, номер поезда, время отправления. Создайте данные в массив из пяти
 * элементов типа Train, добавьте возможность сортировки элементов массива по
 * номерам поездов. Добавьте возможность вывода информации о поезде, номер
 * которого введен пользователем. Добавьте возможность сортировки массив по
 * пункту назначения, причем поезда с одинаковыми пунктами назначения должны
 * быть упорядочены по времени отправления.
 *
 * @author ArtSCactus
 */
public class Train {

    private String destinationName;
    private int trainNumber;
    private Date departureTime;

    public Train(String destinationName, int trainNumber, Date departureTime) {
        this.destinationName = destinationName;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
    }

    public Train(String destinationName, int trainNumber, String departureTime) throws ParseException {
        this.destinationName = destinationName;
        this.trainNumber = trainNumber;
        this.departureTime = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy").parse(departureTime);
    }

    /**
     * Returns destination name (<code>destinationName</code>).
     *
     * @return
     */
    public String getDestinationName() {
        return destinationName;
    }

    /**
     * Setting new destination name (<code>destinationName</code>).
     *
     * @param destinationName
     */
    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    /**
     * Returns trainNumber(<code>trainNumber</code>).
     *
     * @return
     */
    public int getTrainNumber() {
        return trainNumber;
    }

    /**
     * Setting new trainNumber (<code>trainNumber</code>).
     *
     * @param trainNumber
     */
    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    /**
     * Returns departure time (<code>departureTime</code>).
     *
     * @return
     */
    public Date getDepartureTime() {
        return departureTime;
    }

    /**
     * Setting new destination name (<code>destinationName</code>).
     *
     * @param departureTime
     */
    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * Printing all information (destination name
     * <code>String destinationName</code>, <code>int trainNumber</code>,
     * <code>Date departureTime</code>) to console about current train.
     *
     */
    public void printTrainInfo() {
        System.out.println("Destination: " + destinationName + "\nTrain number: " + trainNumber + "\nDeparture time: " + departureTime);
    }

    /**
     * Calling method <code>printTrainInfo()</code> for train with given number
     * <code>int trainNumber</code>. In the absence of train with such number
     * printing to console <code>System.out.println("No such train.");
     * </code>
     *
     * @param trains
     * @param trainNumber
     */
    public static void printTrainInfoByItsNumber(Train[] trains, int trainNumber) {
        if (trains.length == 0) {
            System.out.println("No given trains");
            return;
        }
        for (Train train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                train.printTrainInfo();
                return;
            }
        }
        System.out.println("No such train.");
    }

    /**
     * Sorting given trains array by destination name
     * (<code>String destinationName</code>) in ascending order (if
     * <code>boolean ascendingOrder</code> are true. Otherwise in descending
     * order). If destination name are matching, sorting are going by departure
     * time (<code>Date departureTime</code>).
     *
     * @param trains
     * @param ascendingOrder
     */
    public static void sortByDestinationName(Train[] trains, boolean ascendingOrder) {
        Comparator<Train> comparator = new Comparator<Train>() {
            @Override
            public int compare(Train trainOne, Train trainTwo) {
                return trainOne.getDestinationName().compareTo(trainTwo.getDestinationName());
            }
        };
        boolean notSorted = true;
        if (ascendingOrder == true) {
            while (notSorted) {
                notSorted = false;
                for (int index = 0; index < trains.length - 1; index++) {
                    if (comparator.compare(trains[index], trains[index + 1]) > 0) {
                        notSorted = true;
                        Train temp = trains[index];
                        trains[index] = trains[index + 1];
                        trains[index + 1] = temp;
                    } else if (comparator.compare(trains[index], trains[index + 1]) == 0) {
                        if (trains[index].getDepartureTime().compareTo(trains[index + 1].getDepartureTime()) == 1) {
                            Train temp = trains[index];
                            trains[index] = trains[index + 1];
                            trains[index + 1] = temp;
                        }
                    }
                }
            }
        } else {
            while (notSorted) {
                notSorted = false;
                for (int index = 0; index < trains.length - 1; index++) {
                    if (comparator.compare(trains[index], trains[index + 1]) < 0) {
                        notSorted = true;
                        Train temp = trains[index];
                        trains[index] = trains[index + 1];
                        trains[index + 1] = temp;
                    } else if (comparator.compare(trains[index], trains[index + 1]) == 0) {
                        if (trains[index].getDepartureTime().compareTo(trains[index + 1].getDepartureTime()) == -1) {
                            notSorted = true;
                            Train temp = trains[index];
                            trains[index] = trains[index + 1];
                            trains[index + 1] = temp;
                        }
                    }
                }
            }
        }
    }

    /**
     *
     * @throws java.text.ParseException
     */
    public static void testClass() throws ParseException {
        Train[] trains = new Train[]{
            new Train("Moscow", 13, "13:30:00 25/07/2019"),
            new Train("Saint-Petersburg", 15, "14:00:00 25/07/2019"),
            new Train("Kaliningrad", 14, "14:30:00 25/07/2019"),
            new Train("Gomel", 12, "15:00:00 25/07/2019"),
            new Train("Brest", 11, "15:30:00 25/07/2019")};
        Train.sortByDestinationName(trains, true);
        for (Train train : trains) {
            train.printTrainInfo();
        }
        System.out.println("Print train info by its number test:");
        Train.printTrainInfoByItsNumber(trains, 13);
    }
}
