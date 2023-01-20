package com.sm.Home_Module;

import org.openqa.selenium.WebDriver;

import com.GenricUtility.FileUtility;
import com.GenricUtility.JavaUtility;
import com.GenricUtility.WebDriverUtility;
import com.biobook.pom.HomePage;
import com.biobook.pom.ProfilePage;
import com.biobook.pom.SingInPage;
import com.biobook.pom.UserPage;
import com.biobook.pom.WlcomePage;

public class ShareStatusWithPomTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		WebDriverUtility wdLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		
		String Url = fLib.readDataFromPropertyFile("url");
		String Email = fLib.readDataFromPropertyFile("email");
		String Password = fLib.readDataFromPropertyFile("password");
		String Image= fLib.readDataFromPropertyFile("ImagePath1");
		String Comment=fLib.readDataFromPropertyFile("comment");
		WebDriver driver = wdLib.browser("Chrome");
		driver.get(Url);
		wdLib.maximizeWindow(driver);
		
		WlcomePage  wp=new WlcomePage(driver);
		wp.getSignbtn().click();
		
		SingInPage sp=new SingInPage(driver);
		sp.setlog(Email, Password);
		
		HomePage hp=new HomePage(driver);
		hp.getProfilepage().click();
		
		ProfilePage pp=new ProfilePage(driver);
		pp.uploadPictuer(Image);
		
		hp.getUserpage().click();
		 
		UserPage up=new UserPage(driver);
		up.comment(Comment);
		
		up.deleteComment(wdLib, driver);
		hp.getLogoutbtn();
		

		
	}

}
