package scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import generic.BasePage;
import generic.BaseTest;
import generic.Excel;
import generic.GenericUtils;
import pom.HomePage;

public class TestScipts extends BaseTest {
	@Test(enabled=false)
	public  void testCreateEmployee() throws EncryptedDocumentException, IOException {
		HomePage p=new HomePage(driver);
		p.setUserName(Excel.readData("Sheet1", 0, 1));
		p.setPwd(Excel.readData("Sheet1", 1, 1));
		p.clickLogin();
		BasePage.verifyTitle("OrangeHRM");
		p.clickPimMenu();
		p.clickAddEmpMenu();
		p.setFirstName("Nutan");
		p.setLastName("Fernandes");
		p.clickSaveBtn();
		p.verifyFirstName("Nutan");
		
	}
	@Test(enabled=true)
	public void testListBoxSortedOrNot() throws EncryptedDocumentException, IOException {
		HomePage p=new HomePage(driver);
		p.setUserName(Excel.readData("Sheet1", 0, 1));
		p.setPwd(Excel.readData("Sheet1", 1, 1));
		p.clickLogin();
		BasePage.verifyTitle("OrangeHRM");
		p.clickPimMenu();
		p.clickEmpListMenu();
		GenericUtils.sortListBox(driver.findElement(By.xpath("//select[@id='empsearch_job_title']")));
		
	}

}
