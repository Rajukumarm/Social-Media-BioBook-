package com.sm.User_Module;

import org.openqa.selenium.WebDriver;

import com.GenricUtility.FileUtility;
import com.GenricUtility.JavaUtility;
import com.GenricUtility.WebDriverUtility;
import com.biobook.pom.HomeModulePage;
import com.biobook.pom.HomePage;
import com.biobook.pom.SingInPage;
import com.biobook.pom.WlcomePage;
import com.graphbuilder.math.func.RandFunction;

public class WriteAndDeleteCommentWithPomTest {
	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		WebDriverUtility wdLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		
		int random=jLib.getRandomNo();
		String Url = fLib.readDataFromPropertyFile("url");
		String Email = fLib.readDataFromPropertyFile("email");
		String Password = fLib.readDataFromPropertyFile("password");
		String Comment2 = fLib.readDataFromPropertyFile("comment2")+random;
		String Comment = fLib.readDataFromPropertyFile("comment");
		String ImagePath3=fLib.readDataFromPropertyFile("ImagePath3");
		
		WebDriver driver = wdLib.browser("Chrome");
	 	driver.get(Url);
		wdLib.maximizeWindow(driver);
		
		WlcomePage  wp=new WlcomePage(driver);
		wp.getSignbtn().click();
		//login as user
		
		SingInPage sp= new SingInPage(driver);
		sp.setlog(Email, Password);
		//Click on home page
		HomePage hp= new HomePage(driver);
		hp.getHomepage().click();
		
		//write comment
		
		HomeModulePage hm=new HomeModulePage(driver);
		hm.comment(Comment);
		hm.shareStatus(Comment2,ImagePath3);
		
		
		hp.getLogoutbtn().click();
		
		
		
		
		
		
}
}

