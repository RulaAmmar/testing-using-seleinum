package smokeTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class seleinum {
WebDriver driver;
String email="majdmmar13@gmail.com";
String password="BUD@Dhg2ZzJWwbX";
	
@BeforeTest
public void myBeforeTest() throws IOException {
driver=new ChromeDriver();
driver.manage().window().maximize();
}

@Test(description = "Open magento",priority = 1)
public void openMagentoWebsite() {
	driver.get("https://magento.softwaretestingboard.com/");
}

@Test(description = "Search",priority = 2)
public void search() {
driver.findElement(By.cssSelector("#search")).sendKeys("bag"+Keys.ENTER);
}

@Test(description = "print the page title",priority = 3)
public void print() {
//String title=driver.getTitle();
//System.out.println(title);
String title	=driver.findElement(By.className("page-title")).getText();
System.out.println(title);
}

@Test(description = "Print the name of the categories",priority = 4)
public void printCategories() {
//for(int i=1;i<=6;i++) {
//	WebElement element=driver.findElement(By.cssSelector(".nav-"+i));
//	String categorie=element.getText();
//	System.out.println(categorie);
//}
List<WebElement> elements=driver.findElements(By.cssSelector(".level0.category-item"));
for(int i=0;i<elements.size();i++) {
System.out.println(elements.get(i).getText());
}
}

@Test(description = "Login functionality",priority = 5)
public void loginFunctionality() {
	driver.findElement(By.linkText("Sign In")).click();
	driver.findElement(By.id("email")).sendKeys(email);
	driver.findElement(By.id("pass")).sendKeys(password);
	driver.findElement(By.id("send2")).click();
}

@Test(description = "Filter functionality",priority = 6)
public void filterFunctionality () {
driver.findElement(By.cssSelector(".level0:first-child")).click();
driver.findElement(By.linkText("Jackets")).click();
WebElement select=driver.findElement(By.id("sorter"));
Select dropdown=new Select(select);
dropdown.selectByValue("name");
}

@AfterTest()
public void myAfterTest(){
	driver.quit();
}
}