package chapter1;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class CheeseFinderTests {

  @Test
  public void testFindSomeCheese() throws Exception{
    WebDriver selenium = new FirefoxDriver();

    selenium.get("http://awful-valentine.com/");
    selenium.findElement(By.id("searchinput")).clear();
    selenium.findElement(By.id("searchinput")).sendKeys("cheese");
    selenium.findElement(By.id("searchsubmit")).click();
    assertTrue(selenium.findElement(By.className("entry")).getText().contains("No Results Found"));

    selenium.quit();
  }


}
