package edu.umb.cs681.HW13;

import java.util.concurrent.atomic.AtomicBoolean;

public class WithdrawRunnable implements Runnable{

    private ThreadSafeBankAccount2 account = null;

    public AtomicBoolean done = new AtomicBoolean(false);

    public WithdrawRunnable(ThreadSafeBankAccount2 account) {
        this.account = account;
    }

    public void setDone() {
        done.getAndSet(true);
    }

    @Override
    public void run() {

        while (true) {

            if(done.get()) {
                System.out.println(Thread.currentThread().getName() +"\t Withdraw Completed");
                break;
            }

            System.out.println(Thread.currentThread().getName() +"\t is Withdrawing money");
            account.withdraw(100);

            try {
                Thread.sleep(1000);
            }catch(InterruptedException e) {
            	e.printStackTrace();
            }
        }
    }
}