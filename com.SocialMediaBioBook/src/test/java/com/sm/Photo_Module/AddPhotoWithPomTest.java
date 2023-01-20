package com.sm.Photo_Module;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenricUtility.ExcelUtility;
import com.GenricUtility.FileUtility;
import com.GenricUtility.JavaUtility;
import com.GenricUtility.WebDriverUtility;
import com.biobook.pom.HomePage;
import com.biobook.pom.ProfilePage;
import com.biobook.pom.SingInPage;
import com.biobook.pom.WlcomePage;
public class AddPhotoWithPomTest {
	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wdLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();

		WebDriver driver=new ChromeDriver();
		wdLib.maximizeWindow(driver);
		int random = jLib.getRandomNo();

		String url=fLib.readDataFromPropertyFile("url");
		String email = fLib.readDataFromPropertyFile("email");
		String password = fLib.readDataFromPropertyFile("password");

		driver.get(url);
		WlcomePage wp = new WlcomePage(driver);
		wp.getSignbtn().click();
		
		SingInPage sp=new SingInPage(driver);
		sp.setlog(email,password);
		
		wdLib.waitForPageLoad(driver);
		
		HomePage hp = new HomePage(driver);
		hp.getProfilepage().click();
		
		ProfilePage pp=new ProfilePage(driver);
		pp.getEditprofilebtn().click();
		
		ArrayList<String> all = eLib.arraylist(driver, "Sheet2");
		pp.editProfile(all);
		wdLib.scrollBarAction(driver);
		pp.getSavebtn().click();
		hp.getUserpage().click();
		//to verify the same data should be display in user page 
		String username=eLib.readDataFromExcel("Sheet2",2,1)+random;
		WebElement user = hp.getUserpage();
		if (user.isDisplayed()) {
			System.out.println("the same data "+username+" displayed in user page");
		}else {
			System.out.println("the same data "+username+" not displayed in user page");
		}
		//Click on home page,
		hp.getHomepage().click();
		//Click on logout
		hp.getLogoutbtn().click();
	}
}
