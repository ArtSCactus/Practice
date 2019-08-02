/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses.Vouchers;

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

    private String voucherType;
    private String transportType;
    private String nutritionType;
    private int amountOfDays;
    private String country;

    /**
     *
     * @param country
     * @param voucherType
     * @param transportType
     * @param nutritionType
     * @param amountOfDays
     */
    public Vacation(String country, String voucherType, String transportType, String nutritionType, int amountOfDays) {
        if (amountOfDays < 0) {
            throw new IllegalArgumentException("Amount of days cannot be less than 0");
        }
        if (voucherType == null | transportType == null | nutritionType == null | country==null) {
            throw new NullPointerException("voucherType or transportType or String nutritionType or country cannot be null");
        }
        this.country=country;
        this.voucherType = voucherType;
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
    public String getVoucherType() {
        return voucherType;
    }

    /**
     *
     * @param voucherType
     */
    public void setVoucherType(String voucherType) {
        if (voucherType == null) {
            throw new NullPointerException("voucher type cannot be null");
        }
        this.voucherType = voucherType;
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
        return "Vacation to country: "+ country  + "\nVacation type: " + voucherType + "\nTransport type: " + transportType + "\nNutrition type: " + nutritionType + "\nAmount Of days: " + amountOfDays;
    }

}
