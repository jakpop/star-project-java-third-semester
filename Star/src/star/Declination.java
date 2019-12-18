/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star;

import java.io.Serializable;

/**
 *
 * @author Jakub Popiół
 */
public class Declination implements Serializable {
    
    private int degrees;
    private int minutes;
    private double seconds;
    private boolean hemisphere;
    
    /**
     * @return the degrees
     */
    public int getDegrees() {
	return degrees;
    }
    
    public void setDegrees(int degrees) {
	this.degrees = degrees;
    }

    public int getMinutes() {
	return minutes;
    }

    public void setMinutes(int minutes) {
	this.minutes = minutes;
    }

    public double getSeconds() {
	return seconds;
    }

    public void setSeconds(double seconds) {
	this.seconds = seconds;
    }

    public boolean isHemisphere() {
	return hemisphere;
    }

    public void setHemisphere(boolean hemisphere) {
	this.hemisphere = hemisphere;
    }
    
    /** 
     * parameteres: declination value. int degrees, int minutes, double seconds, boolean hemisphere - true for north hemisphere, false for sosuth hemisphere.  
     * gets values <0.00; 90.00> for north hemisphere and  <-90.00; 0.00> for south hemisphere 
     */
    public Declination(int degrees, int minutes, double seconds, boolean hemisphere) throws Exception
    {
	this.degrees = degrees;
	this.minutes = minutes;
	this.seconds = seconds;
	this.hemisphere = hemisphere;
	
	if (hemisphere == true)
	{
	    if (degrees < 0 || degrees > 90) {
		throw new Exception("declination value not correct");
	    }
	    if (minutes < 0 || minutes > 60) {
		throw new Exception("declination value not correct");
	    }
	    if (seconds < 0.0 || seconds > 60.00) {
		throw new Exception("declination value not correct");
	    }
	    if (degrees == 90) {
		if (minutes != 0) {
		    throw new Exception("declination value not correct");
		}
		if (seconds != 0.0) {
		    throw new Exception("declination value not correct");
		}
	    }
	}
	if (hemisphere == false) {
	    if (degrees < -90 || degrees > 0) {
		throw new Exception("declination value not correct");
	    }
	    if (minutes < 0 || minutes > 60) {
		throw new Exception("declination value not correct");
	    }
	    if (seconds < 0.0 || seconds > 60.00) {
		throw new Exception("declination value not correct");
	    }
	    if (degrees == -90) {
		if (minutes != 0) {
		    throw new Exception("declination value not correct");
		}
		if (seconds != 0.0) {
		    throw new Exception("declination value not correct");
		}
	    }
	}
    }
    
    @Override
    public String toString() {
	return degrees + " degrees " + minutes + " minutes " + seconds + " seconds";
    }
    
}
