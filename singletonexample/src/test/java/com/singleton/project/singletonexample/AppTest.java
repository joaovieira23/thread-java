package com.singleton.project.singletonexample;

import static org.junit.Assert.assertTrue;

import org.junit.*;

public class AppTest
{

    @Test
    public void singletonInstanceHashCode()
    {
    	MySingletonClass instance1 = MySingletonClass.getInstance();
		MySingletonClass instance2 = MySingletonClass.getInstance();
		
		System.out.println("Instance 1 " + instance1.hashCode());
		System.out.println("Instance 2 " + instance2.hashCode());
		
        assertTrue( instance1.hashCode() == instance2.hashCode() );
    }
}