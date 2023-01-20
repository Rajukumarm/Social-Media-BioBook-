package com.sm.Profile_Module;

import org.testng.annotations.Test;

import com.GenricUtility.BaseClass;
import com.biobook.pom.HomeModulePage;
import com.biobook.pom.HomePage;
import com.biobook.pom.PhotoPage;

public class EditProfileWithTestNgTest extends BaseClass {
	@Test(groups={"regression","smoke"})
	public void editProfile() throws Throwable {
		String Image=fLib.readDataFromPropertyFile("ImagePath1");
		String Status=fLib.readDataFromPropertyFile("status");
		String Comment=fLib.readDataFromPropertyFile("Comment3")+random;

		wbLib.waitForPageLoad(driver);
		HomePage hp=new HomePage(driver);
		hp.getPhotopage().click();
		PhotoPage php=new PhotoPage(driver);
		php.addPhoto(Image);

		hp.getProfilepage().click();

		hp.getHomepage().click();

		HomeModulePage hmp=new HomeModulePage(driver);
		hmp.shareStatus(Status, Image);

		hmp.comment(Comment);
		hmp.deleteComment(wbLib, driver);
		System.out.println("Deleted comment sucessfully");
	}
}
