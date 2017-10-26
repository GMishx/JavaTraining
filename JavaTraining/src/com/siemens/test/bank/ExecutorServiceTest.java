package com.siemens.test.bank;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.siemens.beans.bank.BankAccount;
import com.siemens.service.bank.DepositorThread;
import com.siemens.service.bank.WithdrawThread;

public class ExecutorServiceTest implements Callable<BankAccount> {

	public static void main(String[] args) {
		/*ExecutorService service = Executors.newFixedThreadPool(2);

		List<BankAccount> accounts = new java.util.LinkedList<>();
		for (int i = 1000; i < 2000; i += 10) {
			accounts.add(new BankAccount().setAmmount(i));
		}

		Runnable[] dt = new Runnable[5];
		Runnable[] wt = new Runnable[5];

		for (int i = 0; i < 5; i++) {
			dt[i] = new Thread(new DepositorThread(accounts.get(i)).setAmmount(25));
			wt[i] = new Thread(new WithdrawThread(accounts.get(i)).setAmmount(accounts.get(i).getAmmount() + 25));
		}

		for (int i = 0; i < 5; i++) {
			service.execute(dt[i]);
			service.execute(wt[i]);
		}

		try {
			service.awaitTermination(5, TimeUnit.SECONDS);
			System.out.println("Ballance at end");
			for (int i = 0; i < 5; i++) {
				System.out.println(accounts.get(i).getAmmount());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Future f = service.submit(dt[0]);

		try {
			System.out.println(f.get());
		} catch (InterruptedException | ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		service.shutdown();*/
		
		ExecutorService cal=Executors.newFixedThreadPool(1);
		Future<BankAccount> f = cal.submit(new ExecutorServiceTest());
		cal.shutdown();
		try {
			System.out.println(f.get().getAmmount());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public BankAccount call() throws Exception {
		return new BankAccount().setAmmount(500);
	}

}
