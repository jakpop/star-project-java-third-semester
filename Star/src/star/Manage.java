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
    
    public static void addStar(Star star, String fileName) throws Exception
    {
	ObjectOutputStream oos = null;
	
	Path path = Paths.get(fileName);
	
	try 
	{
	    if (!Files.exists(path)) {
		oos = new ObjectOutputStream(new FileOutputStream(fileName));
		oos.writeObject(star);
	    }
	    else {
		oos = new AppendableObjectOutputStream(new FileOutputStream(fileName, true));
		
		ObjectInputStream ois = null;
		try
		{
		    ois = new ObjectInputStream(new FileInputStream(fileName));

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
    
    public static boolean containsCatalogName(ArrayList<Star> starList, String catalogName){
	for(Star star : starList) {
	    if (star != null && star.getCatalogName().equals(catalogName)) {
		return true;
	    }
	}
	return false;
    }
    
    public static void deleteStar(String catalogName, String fileName)
    {
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	File starDatabase = new File(fileName);
	ArrayList<Star> starList = new ArrayList<Star>();
	Star.GreekAlphabet[] greek = Star.GreekAlphabet.values();
	
	try
	{
	    ois = new ObjectInputStream(new FileInputStream(starDatabase));

	    Object obj = null;

	    Star test = new Star();
//	    int index = 1;
	    int greekIndex = 1;
	    int listIndex = 0;

	    while ((obj = ois.readObject()) != null) {
		if (obj instanceof Star) {
		    test = (Star)obj;
		    if (test.getCatalogName().equals(catalogName)) {
			continue;
		    }
		    starList.add(test);
//		    if (containsCatalogName(starList, catalogName)) {
//			test.setCatalogName(greek[greekIndex].name() + " " + test.getConstellation());
//			greekIndex++;
////			index++;
//		    }
		    starList.set(listIndex++, test);
		}
	    }
	    ois.close();
	    starDatabase.delete();
	}
	catch (EOFException ex) {
//		    System.out.println("\nEnd of file");
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
	
	try {
	    oos = new ObjectOutputStream(new FileOutputStream(starDatabase));

//	    int greekIndex = 0;
//	    int index = 1;
	    for (int i = 0; i < starList.size(); i++) {
		addStar(starList.get(i), fileName);
//		if (containsCatalogName(starList, catalogName)) {
//		    starList.get(index).setCatalogName(greek[greekIndex].name() + " " + starList.get(index).getConstellation());
//		    greekIndex++;
////			index++;
//		}
//		System.out.println(starList.get(i));
//		oos.writeObject(starList.get(i));
	    }
	    oos.close();
	}
	catch (EOFException ex) {
//		    System.out.println("\nEnd of file");
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
