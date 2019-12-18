/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star;

/**
 *
 * @author Jakub Popiół
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
    Star s1 = new Star("ARI1111", new Declination(23, 27, 46.0, true), new RightAscension(2, 7, 10), 2.01, 66, "Aries", 4480, 1.5);
    Star s2 = new Star("ARI2222", new Declination(20, 48, 29.9, true), new RightAscension(1, 54, 38), 2.64, 60, "Aries", 9000, 1.34);
    Star s3 = new Star("CMA1111", new Declination(-16, 42, 58.0171, false), new RightAscension(6, 45, 8), -1.46, 8.6, "Canis Major", 9940, 2.063);
    Star s4 = new Star("UYS1250", new Declination(-12, 27, 58.866, false), new RightAscension(18, 27, 36), 8.29, 5100, "Scutum", 3365, 8);
	
//	Manage.addStar(s1, "star-database.obj");
//	Manage.addStar(s2, "star-database.obj");
//	Manage.addStar(s3, "star-database.obj");
//	Manage.addStar(s4, "star-database.obj");
//	Manage.deleteStar("alpha Aries", "star-database.obj");
//	Manage.showAllStars("star-database.obj");
//	Search.constellation("Aries", "star-database.obj");
//	Search.closerThan(10, "star-database.obj");
//	Search.temparature(1000, 6000, "star-database.obj");
//	Search.absoluteMagnitude(-60, -40, "star-database.obj");
//	Search.hemisphere("Southern", "star-database.obj");
//	Search.supernovas("star-database.obj");
    }
}
