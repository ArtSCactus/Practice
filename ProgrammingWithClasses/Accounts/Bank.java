/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses.Accounts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Task condition: 4. Счета. Клиент может иметь несколько счетов в банке.
 * Учитывать возможность блокировки/разблокировки счета. Реализовать поиск и
 * сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по всем
 * счетам, имеющим положительный и отрицательный балансы отдельно.
 *
 * @author ArtSCactus
 */
public class Bank {

    private List<Account> accountList = new ArrayList<>();
    private String bankName;

    public Bank(String bankName, Account... accounts) {
        if (bankName == null) {
            throw new NullPointerException("Bank name cannot be null");
        }
        if (accountList == null) {
            throw new NullPointerException("Account cannot be null");
        }
        accountList.addAll(Arrays.asList(accounts));
        this.bankName = bankName;
    }

    public Bank(String bankName) {
        if (bankName == null) {
            throw new NullPointerException("Bank name cannot be null");
        }
        this.bankName = bankName;
    }

    public void addAccount(Account account) {
        if (account == null) {
            throw new NullPointerException("Account cannot be null");
        }
        accountList.add(account);
    }

    public void sortByName(boolean ascendingOrder) {
        if (ascendingOrder) {
            Collections.sort(accountList, new Comparator<Account>() {
                @Override
                public int compare(Account firstUser, Account secondUser) {
                    return firstUser.getUserName().compareTo(secondUser.getUserName());
                }
            }
            );
        } else {
            Collections.sort(accountList, new Comparator<Account>() {
                @Override
                public int compare(Account firstUser, Account secondUser) {
                    return secondUser.getUserName().compareTo(firstUser.getUserName());
                }
            }
            );
        }
    }

    public int countAllAccountsMoney() {
        int sum = 0;
        for (Account account : accountList) {
            sum += account.getBalance();
        }
        return sum;
    }

    public int countAllNegativeBalance() {
        int sum = 0;
        for (Account account : accountList) {
            if (account.getBalance() < 0) {
                sum += account.getBalance();
            }
        }
        return sum;
    }

    public int countAllPositiveBalance() {
        int sum = 0;
        for (Account account : accountList) {
            if (account.getBalance() > 0) {
                sum += account.getBalance();
            }
        }
        return sum;
    }

    public void blockUser(int userID) {
        for (Account account : accountList) {
            if (account.getID() == userID) {
                account.blockAccount(true);
                System.out.println("User " + account.getUserName() + " ID " + account.getID() + " has been blocked");
            }
        }
    }

    public void unblockUser(int userID) {
        for (Account account : accountList) {
            if (account.getID() == userID) {
                account.blockAccount(false);
                System.out.println("User " + account.getUserName() + " ID " + account.getID() + " has been unblocked");
            }
        }
    }

    public Account getUser(int userID) {
        for (int index = 0; index < accountList.size(); index++) {
            if (accountList.get(index).getID() == userID) {
                return accountList.get(index);
            }
        }
        return null;
    }

    public Account getUser(String userName) {
        for (int index = 0; index < accountList.size(); index++) {
            if (accountList.get(index).getUserName().equalsIgnoreCase(userName)) {
                return accountList.get(index);
            }
        }
        return null;
    }

    public Account getUser(int userID, String userName) {
        for (int index = 0; index < accountList.size(); index++) {
            if (accountList.get(index).getUserName().equalsIgnoreCase(userName) & accountList.get(index).getID() == userID) {
                return accountList.get(index);
            }
        }
        return null;
    }

    public void changeBalance(int userID, int newBalance) {
        for (Account account : accountList) {
            if (account.getID() == userID & account.isAccountBlocked() == false) {
                System.out.print("Balance of user " + account.getUserName() + " ID " + account.getID() + " succesfully changed from " + account.getBalance() + " to ");
                account.setBalance(newBalance);
                System.out.println(account.getBalance());
            } else if (account.isAccountBlocked()) {
                System.out.println("Cannot change balance. Cause: Account " + account.getUserName() + " ID " + account.getID() + " are blocked");
            }
        }
    }

    public void changeBalance(String userName, int newBalance) {
        for (Account account : accountList) {
            if (account.getUserName().equalsIgnoreCase(userName) & account.isAccountBlocked() == false) {
                System.out.print("Balance of user " + account.getUserName() + " ID " + account.getID() + " succesfully changed from " + account.getBalance() + " to ");
                account.setBalance(newBalance);
                System.out.println(account.getBalance());
            } else if (account.isAccountBlocked()) {
                System.out.println("Cannot change balance. Cause: Account " + account.getUserName() + " ID " + account.getID() + " are blocked");
            }

        }
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
          if (bankName == null) {
            throw new NullPointerException("Bank name cannot be null");
        }
        this.bankName = bankName;
    }

    public void toConsole() {
        for (Account account : accountList) {
            System.out.println(account.toString());
        }
    }

    public static void testClass() {
        Bank bank = new Bank("Blackwater industry bank");
        bank.addAccount(new Account(459789, "Richardson J.S.", 25000, false));
        bank.addAccount(new Account(506780, "Smith W.R.", 50000, false));
        bank.addAccount(new Account(605309, "Adamson G.T.", 30000, false));
        bank.addAccount(new Account(409358, "Bennew R.O.", -5500, false));
        bank.sortByName(true);
        bank.toConsole();
        System.out.println("----------------\nSearch by name Smith W.R.");
        System.out.println(bank.getUser("Smith W.R.").toString());
        System.out.println("----------------\nSearch by id 605309");
        System.out.println(bank.getUser(605309).toString());
        System.out.println("----------------\nUser block test");
        bank.blockUser(409358);
        bank.changeBalance(409358, 0);
        bank.unblockUser(409358);
        bank.changeBalance(409358, -5000);
        System.out.println("----------------\nCount all balance test: ");
        System.out.println("Summary money balance " + bank.countAllAccountsMoney());
        System.out.println("Summary negative balance " + bank.countAllNegativeBalance());
        System.out.println("Summary positive money " + bank.countAllPositiveBalance());

    }
}
