package chapter2;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductReviewTests {

  @Test
  public void testAddNewReview() throws Exception {
    WebDriver selenium = new FirefoxDriver();

    selenium.get("http://awful-valentine.com/");

    selenium.findElement(By.cssSelector(".special-item a[href*=\"our-love-is-special\"].more-info"))
        .click();

    assertEquals("http://awful-valentine.com/our-love-is-special/", selenium.getCurrentUrl());
    assertEquals("Our love is special!!",
                 selenium.findElement(By.className("category-title")).getText());

    selenium.findElement(By.id("author")).sendKeys("Dima");
    selenium.findElement(By.id("email")).sendKeys("dima@selenium.com");
    selenium.findElement(By.id("url")).sendKeys("http://awful-valentine.com");
    selenium.findElement(By.cssSelector("a[title='5']")).click();
    selenium.findElement(By.id("comment")).clear();
    selenium.findElement(By.id("comment"))
        .sendKeys("This is a comment for product " + System.getProperty("user.name"));
    selenium.findElement(By.id("submit")).click();


    if (!selenium.getCurrentUrl().contains("#")) {
      System.out.println("Something went wrong with creation of the test");
      System.exit(1);
    }

    String[] splitString = selenium.getCurrentUrl().split("#");
    String reviewId = splitString[1];

    WebElement review = selenium.findElement(By.id(reviewId));

    WebElement metaInfo = review.findElement(By.className("comment-author-metainfo"));
    String name = metaInfo.findElement(By.className("url")).getText();
    String comment = review.findElement(By.className("comment-content")).getText();//

    assertEquals("Dima", name);
    assertEquals("This is a comment for product " + System.getProperty("user.name"), comment);

    selenium.quit();
  }

  @Test
  public void testAddingADuplicateReview() throws Exception {

    WebDriver selenium = new FirefoxDriver();

    selenium.get("http://awful-valentine.com/");

    selenium.findElement(By.cssSelector(".special-item a[href*=\"our-love-is-special\"].more-info"))
        .click();

    assertEquals("http://awful-valentine.com/our-love-is-special/", selenium.getCurrentUrl());
    assertEquals("Our love is special!!",
                 selenium.findElement(By.className("category-title")).getText());

    selenium.findElement(By.id("author")).sendKeys("Dima");
    selenium.findElement(By.id("email")).sendKeys("dima@selenium.com");
    selenium.findElement(By.id("url")).sendKeys("http://awful-valentine.com");
    selenium.findElement(By.cssSelector("a[title='5']")).click();
    selenium.findElement(By.id("comment")).clear();
    selenium.findElement(By.id("comment"))
        .sendKeys("This is a comment for product " + System.getProperty("user.name"));
    selenium.findElement(By.id("submit")).click();

    String error = selenium.findElement(By.id("error-page")).getText();
    assertEquals("Duplicate comment detected; it looks as though you\u2019ve already said that!",
                 error);

    selenium.quit();
  }


}

