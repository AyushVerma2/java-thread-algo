package companyquestion.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Problem statement:Thread Transaction
 * https://docs.google.com/document/d/151N6_JqZ2VmewBQ4VTs2aTNr2xKKWSTnyVHCyYCwe6Q/edit
 */
public class VMWare_03 {
    public static void main(String[] a) throws InterruptedException {
        Transaction transaction = new Transaction();

        Runnable depoistTash = () -> {
            transaction.deposite(10);
            transaction.deposite(3);
            transaction.deposite(13);
            transaction.deposite(45);

        };
        Runnable withdrawTask = () -> {
            transaction.withdrawl(2);
            transaction.withdrawl(23);
            transaction.withdrawl(4);
            transaction.deposite(67);

        };

        Thread task1 = new Thread(depoistTash);
        Thread task2 = new Thread(withdrawTask);
        task1.start();
        task2.start();
        Thread.sleep(1000);
        System.out.println(transaction.getTransaction());


    }
}

class Account {
    int amout = 0;
    Lock lock = new ReentrantLock();

    public String withdraw(int amnt) {
        if (amnt >= getBalance()) {
            return "Insufficient fund " + amnt;
        }
        lock.lock();
        amout = amout - amnt;
        lock.unlock();
        return "Withdrawing " + amnt;
    }

    public String depoiste(int amnt) {
        lock.lock();
        amout = amout + amnt;
        lock.unlock();
        return "Depositing " + amnt;

    }

    int getBalance() {
        return amout;
    }

}

class Transaction {
    private List<String> allTransaction;
    private Account account;

    Transaction() {
        this.account = new Account();
        this.allTransaction = new ArrayList<>();
    }

    void deposite(int amount) {
        this.allTransaction.add(account.depoiste(amount));

    }

    void withdrawl(int amount) {
        this.allTransaction.add(account.withdraw(amount));
    }

    List<String> getTransaction() {
        return this.allTransaction;
    }


}