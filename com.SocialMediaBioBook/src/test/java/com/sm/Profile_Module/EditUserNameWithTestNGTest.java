package com.sm.Profile_Module;

import org.testng.annotations.Test;

import com.GenricUtility.BaseClass;
import com.biobook.pom.HomePage;
import com.biobook.pom.PhotoPage;
import com.biobook.pom.ProfilePage;

public class EditUserNameWithTestNGTest extends BaseClass {
	
	@Test(groups={"smoke","regression"})
	public void editUserName() throws Throwable
	{
		String ImagePath1=fLib.readDataFromPropertyFile("ImagePath1");
		String ImagePath2 = fLib.readDataFromPropertyFile("ImagePath2");
		String User=fLib.readDataFromPropertyFile("user");
		
		HomePage hp=new HomePage(driver);
		hp.getProfilepage().click();
		
		ProfilePage pp=new ProfilePage(driver);

		pp.uploadPictuer(ImagePath1);
		//wdLib.scrollBarAction(driver);
		
		hp.getProfilepage().click();
		
		pp.getEditprofilebtn().click();
		
		pp.getUsernametxt().clear();
		pp.getUsernametxt().sendKeys(User); 
		
		wbLib.scrollBarAction(driver);
		pp.getSavebtn().click();
		
		hp.getPhotopage().click();
		PhotoPage php=new PhotoPage(driver);
		php.addPhoto(ImagePath2);
		
	
		
	}

}


