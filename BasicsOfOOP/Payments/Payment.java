/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.BasicsOfOOP.Payments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Task condition: Создать класс Payment с внутренним классом, с помощью
 * объектов которого можно сформировать покупку из нескольких товаров.
 *
 * @author ArtSCactus
 */
public class Payment {

    private List<Purchase> purchaseList;

    /**
     *
     */
    public class Purchase {
/**Stores price of current purchase.
 * 
 */
        private int price;
        /**Stores name of current purchase.
         * 
         */
        private String name;
        /**Stores amount of current purhcases.
         * 
         */
        private int amount;

        /**
         *Constructs new purchase.
         * 
         * @param name
         * @param price
         * @param amount
         */
        public Purchase(String name, int price, int amount) {
            if (name == null) {
                throw new NullPointerException("Purchase name cannot be null");
            }
            if (price < 0 | amount < 0) {
                throw new IllegalArgumentException("Price and amount cannot be less than 0");
            }
            this.price = price;
            this.name = name;
        }

        /**
         *Returns amount of this purchases.
         * 
         * @return amount of this purhcases
         */
        public int getAmount() {
            return amount;
        }

        /**
         *Settings new amount of this purchase.
         * 
         * @param amount of this purchase
         * @throws IllegalArgumentException if amount less than 0
         */
        public void setAmount(int amount) {
            if (amount < 0) {
                throw new IllegalArgumentException("Amount cannot be less than 0");
            }
            this.amount = amount;
        }

        /**
         *Returns pirce of 1 current purchase.
         * 
         * @return price of 1 purchase
         */
        public int getPrice() {
            return price;
        }

        /**
         *Settings new purchase price.
         * 
         * @param price
         * @throws IllegalAgumentException if price less than 0
         */
        public void setPrice(int price) {
            if (price < 0) {
                throw new IllegalArgumentException("Price cannot be less than 0");
            }
            this.price = price;
        }

        /**
         *Returns name of this purchase.
         * 
         * @return name
         */
        public String getName() {
            return name;
        }

        /**
         *Settings new name to this purhcase.
         * 
         * @param name
         * @throws NullPointerException if name are null
         */
        public void setName(String name) {
            if (name == null) {
                throw new NullPointerException("Purchase name cannot be null");
            }
            this.name = name;
        }
/**Returns information about current purhcase as String row.
 * 
 * @return 
 */
        @Override
        public String toString() {
            return "Purchase[" + "price=" + price + ", name=" + name + ", amount=" + amount + ']';
        }

    }

    /**
     *Constructs new payments with purchases.
     * 
     * @param purchases
     * @throws NullPointerException if atleast one of purchase are null
     */
    public Payment(Purchase... purchases) {
        if (purchases == null) {
            throw new NullPointerException("Purchase cannot be null");
        }
        purchaseList = new ArrayList<>();
        purchaseList.addAll(Arrays.asList(purchases));
    }

    /**
     *Constructs empty payment
     */
    public Payment() {
        purchaseList = new ArrayList<>();
    }

    /**
     *Allows to add new purchase to the current payment.
     * 
     * @param name of this purchase
     * @param price price for 1 pruchase
     * @param amount amount of this purchases
     * @throws NullPointerException if name are null
     * @throws IllegalArgumentException if price or amount are less than 0.
     */
    public void addPurchase(String name, int price, int amount) {
        if (name==null) throw new NullPointerException("Name cannot be null");
        if (price<0 | amount<0) throw new IllegalArgumentException("Price or amount cannot be less than 0");
        purchaseList.add(new Purchase(name, price, amount));
    }

    /**
     * Allows to add object of Purchase class to current payment.
     * 
     * @param purchase
     * @throws NullPointerException if purchase are null
     */
    public void addPurchase(Purchase purchase) {
        if  (purchase==null) throw new NullPointerException("Purchase cannot be null");
        purchaseList.add(purchase);
    }

    /**
     *Counts price of current payment by pirce and amount of purchases.
     * 
     * @return
     */
    public int countPrice() {
        int sum = 0;
        for (Purchase purchase : purchaseList) {
            sum += purchase.getPrice() * purchase.getAmount();
        }
        return sum;
    }

    /**
     *Deletes all purchase by given name.
     * 
     * @param name
     * @throws NullPointerException if name are null
     */
    public void deletePurchase(String name) {
        if (name==null) throw new NullPointerException("Name cannot be null");
        for (int index = 0; index < purchaseList.size(); index++) {
            if (purchaseList.get(index).getName().equalsIgnoreCase(name)) {
                purchaseList.remove(index);
                index--;
            }
        }
    }

    /**
     *Deletes all purchases by given price for 1 item.
     * @param price
     * @throws IllegalArgumentException if price are less than 0
     */
    public void deletePurchase(int price) {
        if (price<0) throw new IllegalArgumentException("Price cannot be less than 0");
        for (int index = 0; index < purchaseList.size();) {
            if (purchaseList.get(index).getPrice() == price) {
                purchaseList.remove(index);
            }
        }
    }

    /**
     *Clears current purhcases list.
     * 
     */
    public void clearList() {
        purchaseList.clear();
    }

}
