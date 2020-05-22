package com.singleton.project.singletonexample;

public class MySingletonClass {

	private static volatile MySingletonClass instance;
	private static Object mutex = new Object();

	private MySingletonClass() {
		
		// avoid reflection creation
		if (instance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
	}

	public static MySingletonClass getInstance() {
		MySingletonClass result = instance;
		if (result == null) {
			synchronized (mutex) {
				result = instance;
				if (result == null)
					instance = result = new MySingletonClass();
			}
		}
		return result;
	}

	// avoid serialization and de-serialization
	protected MySingletonClass readResolve() {
        return getInstance();
    }
}