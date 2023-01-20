package com.sm.Profile_Module;



import org.openqa.selenium.WebDriver;

import com.GenricUtility.ExcelUtility;
import com.GenricUtility.FileUtility;
import com.GenricUtility.JavaUtility;
import com.GenricUtility.WebDriverUtility;
import com.biobook.pom.HomeModulePage;
import com.biobook.pom.HomePage;
import com.biobook.pom.PhotoPage;
import com.biobook.pom.ProfilePage;
import com.biobook.pom.SingInPage;
import com.biobook.pom.WlcomePage;

public class EditUserNameWithPomTest {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		WebDriverUtility wdLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		
		int random=jLib.getRandomNo();
		String Url = fLib.readDataFromPropertyFile("url");
		String Email = fLib.readDataFromPropertyFile("email");
		String Password = fLib.readDataFromPropertyFile("password");
		String ImagePath1=fLib.readDataFromPropertyFile("ImagePath1");
		String ImagePath2 = fLib.readDataFromPropertyFile("ImagePath2");
		String User=fLib.readDataFromPropertyFile("user");
				
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

		pp.uploadPictuer(ImagePath1);
		//wdLib.scrollBarAction(driver);
		
		hp.getProfilepage().click();
		
		pp.getEditprofilebtn().click();
		
		pp.getUsernametxt().clear();
		pp.getUsernametxt().sendKeys(User); 
		
		wdLib.scrollBarAction(driver);
		pp.getSavebtn().click();
		
		hp.getPhotopage().click();
		PhotoPage php=new PhotoPage(driver);
		php.addPhoto(ImagePath2);
		
		hp.getLogoutbtn().click();
		
	}

}
