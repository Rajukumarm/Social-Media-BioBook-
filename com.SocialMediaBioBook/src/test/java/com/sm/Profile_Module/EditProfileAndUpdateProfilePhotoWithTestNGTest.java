package com.sm.Profile_Module;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.GenricUtility.BaseClass;
import com.biobook.pom.HomePage;
import com.biobook.pom.ProfilePage;

public class EditProfileAndUpdateProfilePhotoWithTestNGTest extends BaseClass {

	@Test(groups="regression")
	public void editProfile() throws Throwable
	{
	
	HomePage hp=new HomePage(driver);
	hp.getProfilepage().click();
	

	ProfilePage pp=new ProfilePage(driver);
	pp.getEditprofilebtn().click();
	String User=fLib.readDataFromPropertyFile("user")+random;

	pp.getUsernametxt().clear();
	pp.getUsernametxt().sendKeys(User);
	
	wbLib.scrollBarAction(driver);
	pp.getSavebtn();
	
	WebElement ele = hp.getUserpage();
	if(ele.isDisplayed())
	{
		System.out.println("The same data "+ele.getText()+" dispalyed in user page");
		
	}
	else
	{
		System.out.println("The same data "+ele.getText()+" not dispalyed in user page");
	}
	hp.getHomepage().click();
	}
}
