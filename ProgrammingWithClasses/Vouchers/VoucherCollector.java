/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses.Vouchers;

import java.util.ArrayList;
import java.util.Arrays;
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
public class VoucherCollector {
private List<Voucher> vouchersList=new ArrayList<>();

    public VoucherCollector(Voucher ...vouchers) {
        vouchersList.addAll(Arrays.asList(vouchers));
    }
    
    public List getRecomendationList(String country, String voucherType, String nutritionType, String transportType, int amountOfDays){
        List<Voucher> recomendationList = new ArrayList<>();
        for (Voucher voucher : vouchersList)
            if (voucher.getCountry().equalsIgnoreCase(country) & voucher.getVoucherType().equalsIgnoreCase(voucherType)
                    & voucher.getNutritionType().equalsIgnoreCase(nutritionType) & voucher.getTransportType().equalsIgnoreCase(transportType)
                    & voucher.getAmountOfDays()==amountOfDays) recomendationList.add(voucher);
        return recomendationList;
    }

}
