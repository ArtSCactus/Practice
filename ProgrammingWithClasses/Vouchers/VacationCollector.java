/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses.Vouchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Task condition: 5. Туристические путевки. Сформировать набор предложений
 * клиенту по выбору туристической путевки различного типа (отдых, экскурсии,
 * лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать
 * возможность выбора транспорта, питания и числа дней. Реализовать выбор и
 * сортировку путевок.
 *
 * @author ArtSCactus
 */
public class VacationCollector {

    private List<Vacation> vacationsList = new ArrayList<>();

    /**
     *
     * @param vacations
     */
    public VacationCollector(Vacation... vacations) {
        vacationsList.addAll(Arrays.asList(vacations));
    }

    public VacationCollector() {

    }

    /**
     *
     * @return
     */
    public List getVacationList() {
        return vacationsList;
    }

    /**
     *
     * @param vacation
     * @throws NullPointerException
     */
    public void addVacation(Vacation vacation) throws NullPointerException {
        if (vacation == null) {
            throw new NullPointerException("Vacation cannot be null");
        }
        vacationsList.add(vacation);
    }

    /**
     *
     * @param ascendingOrder
     */
    public void sortVacationByCountry(boolean ascendingOrder) {
        if (ascendingOrder) {
            Collections.sort(vacationsList, new Comparator<Vacation>() {
                @Override
                public int compare(Vacation firstVacation, Vacation secondVacation) {
                    return firstVacation.getCountry().compareTo(secondVacation.getCountry());
                }
            }
            );
        } else {
            Collections.sort(vacationsList, new Comparator<Vacation>() {
                @Override
                public int compare(Vacation firstVacation, Vacation secondVacation) {
                    return secondVacation.getCountry().compareTo(firstVacation.getCountry());
                }
            }
            );
        }
    }

    /**
     *
     * @param transportType
     * @return
     */
    public List getVacationsByTransportType(String transportType) {
        List<Vacation> matchedVacations = new ArrayList<>();
        for (Vacation vacation : vacationsList) {
            if (vacation.getTransportType().equalsIgnoreCase(transportType)) {
                matchedVacations.add(vacation);
            }
        }
        return matchedVacations;
    }

    /**
     *
     * @param amountOfDays
     * @return
     */
    public List getVacationsByAmountOfDays(int amountOfDays) {
        List<Vacation> matchedVacations = new ArrayList<>();
        for (Vacation vacation : vacationsList) {
            if (vacation.getAmountOfDays() == amountOfDays) {
                matchedVacations.add(vacation);
            }
        }
        return matchedVacations;
    }

    /**
     *
     * @param nutritionType
     * @return
     */
    public List getVacationsByNutritionType(String nutritionType) {
        List<Vacation> matchedVacations = new ArrayList<>();
        for (Vacation vacation : vacationsList) {
            if (vacation.getNutritionType().equalsIgnoreCase(nutritionType)) {
                matchedVacations.add(vacation);
            }
        }
        return matchedVacations;
    }

    /**
     *
     * @param transportType
     * @param nutritionType
     * @param amountOfDays
     * @return
     */
    public List getVacations(String transportType, String nutritionType, int amountOfDays) {
        List<Vacation> matchedVacations = new ArrayList<>();
        for (Vacation vacation : vacationsList) {
            if (vacation.getTransportType().equalsIgnoreCase(transportType) & vacation.getNutritionType().equalsIgnoreCase(nutritionType) & vacation.getAmountOfDays() == amountOfDays) {
                matchedVacations.add(vacation);
            }
        }
        return matchedVacations;
    }

    /**
     *
     */
    public void printAllVacations() {
        for (Vacation vacation : vacationsList) {
            System.out.println("------------------\n" + vacation.toString());
        }
        System.out.println();

    }

    /**
     *
     * @param vacationsList
     */
    public void printAllVacations(List<Vacation> vacationsList) {
        for (Vacation vacation : vacationsList) {
            System.out.println("------------------\n" + vacation.toString());

        }
        System.out.println();
    }

    public static void testClass() {
        VacationCollector collection = new VacationCollector();
        collection.addVacation(new Vacation("Spain", "tourism", "plane", "two times", 7));
        collection.addVacation(new Vacation("Ukraine", "sanitary", "train", "three times", 14));
        collection.addVacation(new Vacation("Pacific ocean", "cruise", "ship", "unlimited", 7));
        collection.addVacation(new Vacation("France", "shopping", "plane", "two times", 5));
        collection.addVacation(new Vacation("Germany", "excursion", "bus", "three times", 4));
        collection.addVacation(new Vacation("Marshall islands", "rest", "plane", "three times", 7));
        collection.addVacation(new Vacation("Argentina", "tourism", "plane", "two times", 14));
        collection.sortVacationByCountry(true);
        System.out.println("All vacations(sorted): ");
        collection.printAllVacations();
        System.out.println("Get vacations by amount of days test(7): ");
        collection.printAllVacations(collection.getVacationsByAmountOfDays(7));
        System.out.println("Get vacations by transport type test(plane): ");
        collection.printAllVacations(collection.getVacationsByTransportType("plane"));
        System.out.println("Get vacations by nutrition type test(two times): ");
        collection.printAllVacations(collection.getVacationsByNutritionType("two times"));
        System.out.println("Get vacations by transport type, nutrition type and amount of days test( plane, two times, 7): ");
        collection.printAllVacations(collection.getVacations("plane", "two times", 7));

    }
}
