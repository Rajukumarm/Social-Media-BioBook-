package com.sm.User_Module;

import static org.testng.Assert.fail;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenricUtility.BaseClass;
import com.biobook.pom.HomeModulePage;
import com.biobook.pom.HomePage;
@Listeners(com.GenricUtility.ListenerImplimentationClass.class)
public class WriteAndDeleteCommentWithTestNGTest extends  BaseClass{
@Test(groups={"smoke","regression"},retryAnalyzer = com.GenricUtility.RetryImpClass.class)
public void writeAndDeleteComment() throws Throwable {
	
	String Comment2 = fLib.readDataFromPropertyFile("comment2")+random;
	String Comment = fLib.readDataFromPropertyFile("comment");
	String ImagePath3=fLib.readDataFromPropertyFile("ImagePath3");

	//Click on home page
	HomePage hp= new HomePage(driver);
	hp.getHomepage().click();
	
	//write comment
	
	HomeModulePage hm=new HomeModulePage(driver);
	fail();
	hm.shareStatus(Comment2,ImagePath3);
	hm.comment(Comment);
	hm.deleteComment(wbLib, driver);
	
	
}
}
