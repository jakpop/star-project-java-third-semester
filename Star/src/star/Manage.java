/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 *
 * @author pc
 */


public class Manage implements Serializable {
    
    public static void addStar(Star star) throws Exception
    {
	ObjectOutputStream oos = null;
	
	Path path = Paths.get("star-database.obj");
	
	try 
	{
	    if (!Files.exists(path)) {
		oos = new ObjectOutputStream(new FileOutputStream("star-database.obj"));
		oos.writeObject(star);
	    }
	    else {
		oos = new AppendableObjectOutputStream(new FileOutputStream("star-database.obj", true));
		
		ObjectInputStream ois = null;
		try
		{
		    ois = new ObjectInputStream(new FileInputStream("star-database.obj"));

		    Object obj = null;

		    Star test = new Star();
		    Star.GreekAlphabet[] greek = Star.GreekAlphabet.values();
		    int greekIndex = 1;

		    while ((obj = ois.readObject()) != null) {
			if (obj instanceof Star) {
			    test = (Star)obj;
			    if (test.getConstellation().equals(star.getConstellation())) {
				star.setCatalogName(greek[greekIndex].name() + " " + star.getConstellation());
				greekIndex++;
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
		
		oos.writeObject(star);
	    }
	    
	    oos.close();
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}
    }
    
    public static void showAllStars(String fileName) throws Exception
    {
	ObjectInputStream ois = null;
	
	try
	{
	    ois = new ObjectInputStream(new FileInputStream(fileName));
	    
	    Object obj = null;
	    
	    Star star = new Star();
	    
	    while ((obj = ois.readObject()) != null) {
		if (obj instanceof Star) {
		    star = (Star)obj;

		    System.out.println(star.toString());
		    System.out.println("");
		}
	    }
	    ois.close();
	}
	catch (EOFException ex) {
	    System.out.println("\nEnd of file");
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
