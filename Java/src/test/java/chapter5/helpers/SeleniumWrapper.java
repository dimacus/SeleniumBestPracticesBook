package chapter5.helpers;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SeleniumWrapper {

  private WebDriver selenium;

  public SeleniumWrapper(String browser) {
    if (browser.equals("firefox")) {
      FirefoxProfile profile = new FirefoxProfile();
      profile.setPreference("network.proxy.type", 1);
      profile.setPreference("network.proxy.http", "127.0.0.1");
      profile.setPreference("network.proxy.http_port", 9999);
      profile
          .setPreference("network.proxy.no_proxies_on",
                         "localhost, 127.0.0.1, *awful-valentine.com");

      selenium = new FirefoxDriver(profile);
    }
  }

  public void get(String url){
    selenium.get(url);
  }

  public void quit() {
    selenium.quit();
  }

  public String getCurrentUrl(){
    return selenium.getCurrentUrl();
  }

  public void typeText(String text, By element) throws Exception {
    try {
      bringCurrentWindowToFront();
      clear(element);
      findElement(element).sendKeys(text);
      waitForAjaxAndAnimation();
    } catch (Exception e) {
      System.out
          .println("Attempted to type " + text + " into " + element.toString() + " has failed");
      e.printStackTrace();
      takeScreenshot();
      throw e;
    }
  }

  public void click(By element) throws Exception {
    try {
      bringCurrentWindowToFront();
      findElement(element).click();
      waitForAjaxAndAnimation();
    } catch (Exception e) {
      System.out
          .println("Attempt to click on element " + element.toString() + " has failed");
      e.printStackTrace();
      takeScreenshot();
      throw e;
    }
  }

  public String getInnerText(By element) {
    return findElement(element).getText();
  }

  public void takeScreenshot() {
    File scrFile = ((TakesScreenshot) selenium).getScreenshotAs(OutputType.FILE);
    try {
      File filename = new File("images", TimeStamp.getTimestamp() + ".png");
      System.out.println("Saving screenshot to " + filename.getAbsolutePath());
      FileUtils.copyFile(scrFile, filename);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }


  public WebElement findElement(By element) {
    return selenium.findElement(element);
  }

  public void clear(By element) {
    selenium.findElement(element).clear();
  }

  public void bringCurrentWindowToFront() {
    List<String> windows = new LinkedList<String>();

    Set windowsHashSet = selenium.getWindowHandles();
    Iterator iterator = windowsHashSet.iterator();

    while (iterator.hasNext()) {
      windows.add((String) iterator.next());
    }

    selenium.switchTo().window(windows.get(0));
  }


  public void waitForAjax() {
    new WebDriverWait(selenium, 60000) {
    }.until(new ExpectedCondition<Boolean>() {
      @Override
      public Boolean apply(WebDriver driverObject) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        Long
            returnedValue =
            (Long) ((JavascriptExecutor) driverObject).executeScript("return jQuery.active");

        return returnedValue == 0;
      }

    });
  }


  public void waitForAnimation() {

    new WebDriverWait(selenium, 60000) {
    }.until(new ExpectedCondition<Boolean>() {
      @Override
      public Boolean apply(WebDriver driverObject) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        Long
            returnedValue =
            (Long) ((JavascriptExecutor) driverObject)
                .executeScript("return jQuery(':animated').length");

        return returnedValue == 0;
      }

    });
  }

  public void waitForAjaxAndAnimation() {
    if (isJQueryDefined()) {
      waitForAjax();
      waitForAnimation();
    }
  }

  public boolean isJQueryDefined() {
    return (Boolean) ((JavascriptExecutor) selenium)
        .executeScript("return typeof jQuery == 'function'");
  }

}
