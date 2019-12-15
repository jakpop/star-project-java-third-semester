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
    
//    public String createCatalogName()
//    {
//	
//    }
    
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
	    ois = new AppendableObjectInputStream(new FileInputStream(fileName));
	    
	    Object obj = null;
	    
	    Star star = new Star();
	    ArrayList<Star> starList = new ArrayList<Star>();
	    Star.GreekAlphabet[] greek = Star.GreekAlphabet.values();
	    int howmany = 0;
	    
	    while ((obj = ois.readObject()) != null) {
		if (obj instanceof Star) {
		    star = (Star)obj;
		    starList.add(star);
		    if (howmany > 0) {
			if (starList.get(howmany).getConstellation().equals(starList.get(howmany - 1).getConstellation())) {
			starList.get(howmany).setCatalogName(greek[howmany].name() + " " + starList.get(howmany).getConstellation());
			}
		    }
		    howmany++;
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