package com.sm.Home_Module;

import org.testng.annotations.Test;
import com.GenricUtility.BaseClass;
import com.biobook.pom.HomePage;
import com.biobook.pom.ProfilePage;
import com.biobook.pom.UserPage;

public class ShareStatusWithTestNGTest extends BaseClass {
	
	@Test(groups={"smoke","regression"})
	
	public void ShareStatus() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.getProfilepage().click();
		String Image = fLib.readDataFromPropertyFile("ImagePath1");
		String Comment=fLib.readDataFromPropertyFile("comment2");
		 
		ProfilePage pp=new ProfilePage(driver);
		pp.uploadPictuer(Image);
		hp.getUserpage().click();
		UserPage up=new UserPage(driver);
		up.comment(Comment);
	}
	@Test(groups="smoke")
	public void school()
	{
		System.out.println("today is close");
	}
	@Test
	public void college() {
		System.out.println("Today is open");
	}
}
