/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses.Customer;

import java.util.Comparator;

/**
 * Task condition: 8. Создать класс Customer, спецификация которого приведена
 * ниже. Определить конструкторы, set- и get- методы и метод toString(). Создать
 * второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
 * и методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки,
 * номер банковского счета. Найти и вывести: a) список покупателей в алфавитном
 * порядке; b) список покупателей, у которых номер кредитной карточки находится
 * в заданном интервале
 *
 * @author ArtSCactus
 */
public class CustomerBase {

    private Customer[] customers;

    public CustomerBase(Customer[] customers) {
        this.customers = customers;
    }

    /**
     * Calling method <code>toString()</code> for each customer in a current
     * object.
     *
     */
    public void printCustomers() {
        Customer[] sortedCustomers = customers;
        sortCustomers(sortedCustomers);
        for (Customer customer : customers) {
            System.out.println("----------\n" + customer.toString());
        }
    }

    /**
     * Sorting customers array by alphabet (If surname are same, looking by
     * name, if it's same too looking by patronymic).
     *
     * @param customers array of Customer class objects
     */
    private void sortCustomers(Customer[] customers) {
        Comparator<Customer> comparator = new Comparator<Customer>() {
            @Override
            public int compare(Customer customerOne, Customer customerTwo) {
                if (!customerOne.getSurname().equalsIgnoreCase(customerTwo.getSurname())) {
                    return customerOne.getSurname().compareTo(customerTwo.getSurname());
                } else {
                    if (!customerOne.getName().equalsIgnoreCase(customerTwo.getName())) {
                        return customerOne.getName().compareTo(customerTwo.getName());
                    } else {
                        return customerOne.getPatronymic().compareTo(customerTwo.getPatronymic());
                    }
                }
            }
        };
        boolean notSorted = true;
        while (notSorted) {
            notSorted = false;
            for (int index = 0; index < customers.length - 1; index++) {
                if (comparator.compare(customers[index], customers[index + 1]) > 0) {
                    notSorted = true;
                    Customer temp = customers[index];
                    customers[index] = customers[index + 1];
                    customers[index + 1] = temp;

                }
            }
        }
    }

    /**
     * Calling method <code>toString()</code> for each customer in a current
     * object if its card number falls into the specified interval.
     *
     * @param from down interval border
     * @param to upper interval border
     *
     */
    public void printByCreditCard(int from, int to) {
        // To escape mistakes in case of from value  are bigger than to value
        if (from > to) {
            int temp = to;
            to = from;
            from = temp;
        }
        for (Customer customer : customers) {
            if (customer.getCreditCardNumber() <= to & customer.getCreditCardNumber() >= from) {
                System.out.println("------------\n" + customer.toString());
            }
        }

    }

    public static void testClass() {
        Customer[] customers = new Customer[]{
            new Customer(11, "Bush", "John", "Malkovich", "city Washington", 339, 679011),
            new Customer(10, "Antonov", "Ivan", "Petrovich", "city Samara", 555, 439290),
            new Customer(12, "Kennedy", "Jack", "Maktavish", "city Boston", 450, 383567)};
        CustomerBase base = new CustomerBase(customers);
        base.printByCreditCard(300, 400);
        base.printCustomers();
    }
}
