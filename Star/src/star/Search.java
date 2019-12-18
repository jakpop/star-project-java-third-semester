/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star;

import java.io.*;

/**
 *
 * @author Jakub Popiół
 */
public class Search {
    
    public static void constellation(String constellation, String fileName) 
    {	
	try
	{
	    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));

	    Object obj = null;

	    Star test = new Star();

	    while ((obj = ois.readObject()) != null) {
		if (obj instanceof Star) {
		    test = (Star)obj;
		    if (test.getConstellation().equals(constellation)) {
			System.out.println(test.toString() + "\n");
		    }
		}
	    }
	    ois.close();
	}
	catch (EOFException ex) {
//		    System.out.println("\nEnd of file");
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    public static void closerThan(double parsec, String fileName) 
    {
	double lightYear = 0;
	
	try
	{
	    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));

	    Object obj = null;

	    Star test = new Star();

	    while ((obj = ois.readObject()) != null) {
		if (obj instanceof Star) {
		    test = (Star)obj;
		    lightYear = parsec * 3.296;
		    if (test.getLightYearDistance() < lightYear) {
			System.out.println(test.toString() + "\n");
		    }
		}
	    }
	    ois.close();
	}
	catch (EOFException ex) {
//		    System.out.println("\nEnd of file");
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    public static void temparature(double tempStart, double tempEnd, String fileName) 
    {
	try
	{
	    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));

	    Object obj = null;

	    Star test = new Star();

	    while ((obj = ois.readObject()) != null) {
		if (obj instanceof Star) {
		    test = (Star)obj;
		    if (test.getTemperature() > tempStart && test.getTemperature() < tempEnd) {
			System.out.println(test.toString() + "\n");
		    }
		}
	    }
	    ois.close();
	}
	catch (EOFException ex) {
//		    System.out.println("\nEnd of file");
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    public static void absoluteMagnitude(double magnitudeStart, double magnitudeEnd, String fileName)
    {
	try
	{
	    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));

	    Object obj = null;

	    Star test = new Star();

	    while ((obj = ois.readObject()) != null) {
		if (obj instanceof Star) {
		    test = (Star)obj;
		    if (test.getAbsoluteMagnitude() > magnitudeStart && test.getAbsoluteMagnitude() < magnitudeEnd) {
			System.out.println(test.toString() + "\n");
		    }
		}
	    }
	    ois.close();
	}
	catch (EOFException ex) {
//		    System.out.println("\nEnd of file");
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    public static void hemisphere(String hemisphere, String fileName)
    {
	try
	{
	    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));

	    Object obj = null;

	    Star test = new Star();

	    while ((obj = ois.readObject()) != null) {
		if (obj instanceof Star) {
		    test = (Star)obj;
		    if (test.getHemisphere().equals(hemisphere)) {
			System.out.println(test.toString() + "\n");
		    }
		}
	    }
	    ois.close();
	}
	catch (EOFException ex) {
//		    System.out.println("\nEnd of file");
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    public static void supernovas(String fileName)
    {
	Star solar = new Star();
	double chandrasekhar = 1.44 * solar.getSOLAR_MASS();
	
	try
	{
	    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));

	    Object obj = null;

	    Star test = new Star();

	    while ((obj = ois.readObject()) != null) {
		if (obj instanceof Star) {
		    test = (Star)obj;
		    if (test.getMass() > chandrasekhar) {
			System.out.println(test.toString() + "\n");
		    }
		}
	    }
	    ois.close();
	}
	catch (EOFException ex) {
//		    System.out.println("\nEnd of file");
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
}
