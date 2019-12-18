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
public class Star implements Serializable {
    
    enum GreekAlphabet { alpha, beta, gamma, delta, epsilon, zeta, eta, theta, 
			 iota, kappa, lambda, mu, nu, xi, omikron, pi, rho, 
			 sigma, tau, upsilon, phi, chi, psi, omega };

    private final double LIGHT_YEAR = 9.46 * Math.pow(10, 12);
    private final double PARSEC = 3.26 * LIGHT_YEAR;
    private final double SOLAR_MASS = 1.9884 * Math.pow(10, 30);
    
    private String name;							// star name format should be like this: XXX9999
    private String catalogName;
    private Declination declination;
    private RightAscension rightAscension;
    private double apparentMagnitude;
    private double absoluteMagnitude;
    private double lightYearDistance;
    private String constellation;
    private String hemisphere;
    private double temperature;
    private double mass;							//in relation to solar mass
    
    public Star() { 
    
    };
    
    public Star(String name, Declination declination, 
		RightAscension rightAscension, double apparentMagnitude, 
		double lightYear, String constellation, double temperature, 
		double mass) throws Exception 
    {
	this.name = name;
	this.catalogName = GreekAlphabet.alpha +  " " + constellation;
	this.declination = declination;
	this.rightAscension = rightAscension;
	this.apparentMagnitude = apparentMagnitude;
	this.absoluteMagnitude = apparentMagnitude - 5*Math.log10(PARSEC) + 5;
	this.lightYearDistance = lightYear;
	this.constellation = constellation;
	if (declination.isHemisphere() == true) {
	    this.hemisphere = "Northern";
	}
	else {
	    this.hemisphere = "Southern";
	}
	this.temperature = temperature;
	this.mass = mass * SOLAR_MASS;
	
	if (name.length() > 7) {
	    throw new Exception("star name too long");
	}
	for (int i = 0; i < 3; i++) {
	    if ((byte)name.charAt(i) < 65 || (byte)name.charAt(i) > 90) {
		throw new Exception("star name format incorrect");
	    }
	}
	for (int i = 3; i < name.length(); i++) {
	    if ((byte)name.charAt(i) < 48 || (byte)name.charAt(i) > 57) {
		throw new Exception("star name format incorrect");
	    }
	}
	
	if (apparentMagnitude < -26.74 || apparentMagnitude > 15.0) {
	    throw new Exception("apparent magnitude value incorrect");
	}
	
	if (temperature < 2000.0) {
	    throw new Exception("temperature too low");
	}
	
	if (mass < 0.1 || mass > 50.0) {
	    throw new Exception("mass value incorrect");
	}
    }

    public double getLIGHT_YEAR() {
	return LIGHT_YEAR;
    }

    public double getPARSEC() {
	return PARSEC;
    }

    public double getSOLAR_MASS() {
	return SOLAR_MASS;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getCatalogName() {
	return catalogName;
    }

    public void setCatalogName(String catalogName) {
	this.catalogName = catalogName;
    }

    public String getDeclination() {
	return declination.toString();
    }

    public void setDeclination(Declination declination) {
	this.declination = declination;
    }

    public String getRightAscension() {
	return rightAscension.toString();
    }

    public void setRightAscension(RightAscension rightAscension) {
	this.rightAscension = rightAscension;
    }

    public double getApparentMagnitude() {
	return apparentMagnitude;
    }

    public void setApparentMagnitude(double apparentMagnitude) {
	this.apparentMagnitude = apparentMagnitude;
    }

    public double getAbsoluteMagnitude() {
	return absoluteMagnitude;
    }

    public void setAbsoluteMagnitude(double absoluteMagnitude) {
	this.absoluteMagnitude = absoluteMagnitude;
    }

    public double getLightYearDistance() {
	return lightYearDistance;
    }

    public void setLightYearDistance(double lightYearDistance) {
	this.lightYearDistance = lightYearDistance;
    }

    public String getConstellation() {
	return constellation;
    }

    public void setConstellation(String constellation) {
	this.constellation = constellation;
    }

    public String getHemisphere() {
	return hemisphere;
    }

    public void setHemisphere(String hemisphere) {
	this.hemisphere = hemisphere;
    }

    public double getTemperature() {
	return temperature;
    }

    public void setTemperature(double temperature) {
	this.temperature = temperature;
    }

    public double getMass() {
	return mass;
    }

    public void setMass(double mass) {
	this.mass = mass;
    }
    
    @Override
    public String toString() {
	return String.format("Name: %s\nCatalog Name: %s\nDeclination: %s\nRight Ascension: %s\nApparent Magnitude: %.0f magnitudo\n"
	+ "Absolute Magnitude: %g magnitudo\nDistance: %.1f light year\nConstellation: %s\nHemisphere: %s\nTemperature: %.2f Kelvin\nMass: %g kg", 
	getName(), getCatalogName(), getDeclination(), getRightAscension(), getApparentMagnitude(), getAbsoluteMagnitude(), 
	getLightYearDistance(), getConstellation(), getHemisphere(), getTemperature(), getMass());
    }
}
