package TypeRacer_Selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main {

	public static void main(String[] args) {

//setting the driver executable
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Shoki 2022\\Desktop\\Java\\chromedriver_win32\\chromedriver.exe");

//Initiating your chromedriver
		WebDriver driver = new ChromeDriver();

//Applied wait time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//maximize window
		driver.manage().window().maximize();

//open browser with desired URL
		driver.get("https://play.typeracer.com/");

		WebElement clickable = driver.findElement(By.id("gwt-uid-2"));
		new Actions(driver).click(clickable).perform();

		List<WebElement> divList = driver.findElements(By.tagName("div"));

		List<String> divtext = new ArrayList<String>();

		System.out.println(divList.size());
		int index = 0;
		if (divList.size() != 184) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (WebElement el : divList) {
				try {

					if (el.getText().endsWith("(leave practice)")) {
						System.out.println("Found");
						break;
					} else {
						index++;
					}
				} catch (StaleElementReferenceException e) {

				}
			}
		} else {
			index = 41;
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//180 39
//			/180 33 ?
		}
		System.out.println("index for" + divList.size() +" is "+ index);
		System.out.println(divList.get(index).getText());
		
		

		String text = divList.get(index).getText();
		int i = text.indexOf("wpm") + 5;
		int i2 = text.indexOf("change display format");

		text = text.substring(i - 1, i2);
		System.out.println(text);
		char[] t = text.toCharArray();

		WebElement clickInput = driver.findElement(By.className("txtInput"));
		new Actions(driver).click(clickInput).perform();
//		
//		
		System.out.println("よろしくお願いいしまーーーーす！");
		
		Type type = new Type();
		type.type(t);

//closing the browser
//		driver.quit();

	}

}