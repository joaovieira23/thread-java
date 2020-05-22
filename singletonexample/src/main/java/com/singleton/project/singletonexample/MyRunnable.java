package com.singleton.project.singletonexample;

class MyRunnable implements Runnable {
	int id;

	public MyRunnable(int i) {
		this.id = i;
	}

	public void run() {
		try {
			MySingletonClass instance = MySingletonClass.getInstance();
			System.out.println("Thread " + id + " has instance:" + instance.hashCode());
		} catch(Exception err){
			err.printStackTrace();
		}
	}
}