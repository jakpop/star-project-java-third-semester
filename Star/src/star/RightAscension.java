/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star;

/**
 *
 * @author pc
 */
public class RightAscension {
    
    private int hours;
    private int minutes;
    private int seconds;

    public int getHours() {
	return hours;
    }

    public void setHours(int hours) {
	this.hours = hours;
    }

    public int getMinutes() {
	return minutes;
    }

    public void setMinutes(int minutes) {
	this.minutes = minutes;
    }

    public int getSeconds() {
	return seconds;
    }

    public void setSeconds(int seconds) {
	this.seconds = seconds;
    }
    
    public RightAscension(int hours, int minutes, int seconds) throws Exception
    {
	this.hours = hours;
	this.minutes = minutes;
	this.seconds = seconds;
	
	if (hours < 0 || hours > 24) {
	    throw new Exception("right ascension value not correct");
	}
	if (minutes < 0 || minutes > 60) {
	    throw new Exception("right ascension value not correct");
	}
	if (seconds < 0 || seconds > 60) {
	    throw new Exception("right ascension value not correct");
	}
	if (hours == 24) {
	    if (minutes != 0) {
		throw new Exception("right ascension value not correct");
	    }
	    if (seconds != 0.0) {
		throw new Exception("right ascension value not correct");
	    }
	}
    }
    
}
