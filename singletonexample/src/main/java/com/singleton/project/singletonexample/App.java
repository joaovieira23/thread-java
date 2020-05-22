package com.singleton.project.singletonexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				MySingletonClass instance1 = MySingletonClass.getInstance();
				System.out.println("Instance 1 hash:" + instance1.hashCode());
			}
		});

		//Thread 2
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				MySingletonClass instance2 = MySingletonClass.getInstance();
				System.out.println("Instance 2 hash:" + instance2.hashCode());
			}
		});

		//start both the threads
		t1.start();
		t2.start();

		// using executor service
		int numberOfTasks = 5;
		ExecutorService executor= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		try{
			for ( int i=0; i < numberOfTasks; i++){

				executor.execute(new MyRunnable(i));

			}
		}catch(Exception err){
			err.printStackTrace();
		}
		executor.shutdown();
	}
}
