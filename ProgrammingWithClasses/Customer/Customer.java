/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses.Customer;

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
public class Customer {

    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private int creditCardNumber;
    private int bankAccountNumber;

    /**
     * Constructs new customer. Fields to be filled in (in order of appearence)
     * id (<code>int id</code>), surname (<code>String surname</code>), name
     * (<code>String name</code>), patronymic (<code>String patronymic</code>),
     * address (<code>String address</code>), credit card number
     * (<code>int creditCardNumber</code>), bank account number
     * (<code>int bankAccoutNumber</code>).
     *
     * @param id
     * @param surname
     * @param name
     * @param patronymic
     * @param address
     * @param creditCardNumber
     * @param bankAccountNumber
     */
    public Customer(int id, String surname, String name, String patronymic, String address, int creditCardNumber, int bankAccountNumber) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    /**
     * Returns id of current customer.
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Setting new id for current customer.
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns surname of current customer.
     *
     * @return
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Setting new surname for current customer.
     *
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Returns name of current customer.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setting new name for current customer.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns patronymic of current customer.
     *
     * @return
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Setting new patronymic for current customer.
     *
     * @param patronymic
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * Returns address of current customer.
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setting new address for current customer.
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns credit card number of current customer.
     *
     * @return
     */
    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * Setting new credit card number for current customer.
     *
     * @param creditCardNumber
     */
    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    /**
     * Returns bank account number of current customer.
     *
     * @return
     */
    public int getBankAccountNumber() {
        return bankAccountNumber;
    }

    /**
     * Setting new bank account number for current customer.
     *
     * @param bankAccountNumber
     */
    public void setBankAccountNumber(int bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    /**
     * Printing to string all information about current customer.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Client ID: " + id + "\nSurname: " + surname + "\nName: " + name + "\nPatronymic: " + patronymic + "\nAddress: " + address + "\nCredit card number: " + creditCardNumber + "\nBank account number: " + bankAccountNumber;
    }
}
