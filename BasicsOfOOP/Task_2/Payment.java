/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.BasicsOfOOP.Task_2;

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

        private int price;
        private String name;
        private int amount;

        /**
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
         *
         * @return
         */
        public int getAmount() {
            return amount;
        }

        /**
         *
         * @param amount
         */
        public void setAmount(int amount) {
            if (amount < 0) {
                throw new IllegalArgumentException("Amount cannot be less than 0");
            }
            this.amount = amount;
        }

        /**
         *
         * @return
         */
        public int getPrice() {
            return price;
        }

        /**
         *
         * @param price
         */
        public void setPrice(int price) {
            if (price < 0) {
                throw new IllegalArgumentException("Price cannot be less than 0");
            }
            this.price = price;
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
                throw new NullPointerException("Purchase name cannot be null");
            }
            this.name = name;
        }

        @Override
        public String toString() {
            return "Purchase[" + "price=" + price + ", name=" + name + ", amount=" + amount + ']';
        }

    }

    /**
     *
     * @param purchases
     */
    public Payment(Purchase... purchases) {
        if (purchases == null) {
            throw new NullPointerException("Purchase cannot be null");
        }
        purchaseList = new ArrayList<>();
        purchaseList.addAll(Arrays.asList(purchases));
    }

    /**
     *
     */
    public Payment() {
        purchaseList = new ArrayList<>();
    }

    /**
     *
     * @param name
     * @param price
     * @param amount
     */
    public void addPurchase(String name, int price, int amount) {
        purchaseList.add(new Purchase(name, price, amount));
    }

    /**
     *
     * @param purchase
     */
    public void addPurchase(Purchase purchase) {
        purchaseList.add(purchase);
    }

    /**
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
     *
     * @param name
     */
    public void deletePurchase(String name) {
        for (int index = 0; index < purchaseList.size(); index++) {
            if (purchaseList.get(index).getName().equalsIgnoreCase(name)) {
                purchaseList.remove(index);
                index--;
            }
        }
    }

    /**
     *
     * @param price
     */
    public void deletePurchase(int price) {
        for (int index = 0; index < purchaseList.size();) {
            if (purchaseList.get(index).getPrice() == price) {
                purchaseList.remove(index);
            }
        }
    }

    /**
     *
     */
    public void clearList() {
        purchaseList.clear();
    }

}
