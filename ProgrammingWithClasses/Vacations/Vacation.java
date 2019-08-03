/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses.Vacations;

/**
 * Task condition: 5. Туристические путевки. Сформировать набор предложений
 * клиенту по выбору туристической путевки различного типа (отдых, экскурсии,
 * лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать
 * возможность выбора транспорта, питания и числа дней. Реализовать выбор и
 * сортировку путевок.
 *
 * @author ArtSCactus
 */
public class Vacation {

    private String vacationType;
    private String transportType;
    private String nutritionType;
    private int amountOfDays;
    private String country;

    /**
     *
     * @param country
     * @param vacationType
     * @param transportType
     * @param nutritionType
     * @param amountOfDays
     */
    public Vacation(String country, String vacationType, String transportType, String nutritionType, int amountOfDays) {
        if (amountOfDays < 0) {
            throw new IllegalArgumentException("Amount of days cannot be less than 0");
        }
        if (vacationType == null | transportType == null | nutritionType == null | country==null) {
            throw new NullPointerException("vacationType or transportType or String nutritionType or country cannot be null");
        }
        this.country=country;
        this.vacationType = vacationType;
        this.transportType = transportType;
        this.nutritionType = nutritionType;
        this.amountOfDays = amountOfDays;
    }

    /**
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     */
    public void setCountry(String country) {
                if (country == null) {
            throw new NullPointerException("country cannot be null");
        }
        this.country = country;
    }

    /**
     *
     * @return
     */
    public String getVacationType() {
        return vacationType;
    }

    /**
     *
     * @param vacationType
     */
    public void setVacationType(String vacationType) {
        if (vacationType == null) {
            throw new NullPointerException("vacation type cannot be null");
        }
        this.vacationType = vacationType;
    }

    /**
     *
     * @return
     */
    public String getTransportType() {
        return transportType;
    }

    /**
     *
     * @param transportType
     */
    public void setTransportType(String transportType) {
        if (transportType == null) {
            throw new NullPointerException("Transport type cannot be null");
        }
        this.transportType = transportType;
    }

    /**
     *
     * @return
     */
    public String getNutritionType() {
        return nutritionType;
    }

    /**
     *
     * @param nutritionType
     */
    public void setNutritionType(String nutritionType) {
        if (nutritionType == null) {
            throw new NullPointerException("Nutrition type cannot be null");
        }
        this.nutritionType = nutritionType;
    }

    /**
     *
     * @return
     */
    public int getAmountOfDays() {
        return amountOfDays;
    }

    /**
     *
     * @param amountOFDays
     */
    public void setAmountOfDays(int amountOFDays) {
        if (amountOfDays < 0) {
            throw new IllegalArgumentException("amount of days cannot be less than 0");
        }
        this.amountOfDays = amountOfDays;
    }

    @Override
    public String toString() {
        return "Vacation to country: "+ country  + "\nVacation type: " + vacationType + "\nTransport type: " + transportType + "\nNutrition type: " + nutritionType + "\nAmount Of days: " + amountOfDays;
    }

}
