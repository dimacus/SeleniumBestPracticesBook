package chapter3;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Calendar;

import chapter4.TestData;

import static org.junit.Assert.assertEquals;

public class ProductReviewTests {

  private WebDriver selenium;

  @After
  public void tearDown() throws Exception {
    selenium.quit();
  }

  @Before
  public void setUp() throws Exception {
    selenium = new FirefoxDriver();
  }

  @Test
  public void testAddNewReview() throws Exception {
    String uniqueComment = generateUniqueComment();
    String reviewId = generateNewProductReview(uniqueComment);

    WebElement review = findElement(By.id(reviewId));

    String
        name =
        review.findElement(By.className("comment-author-metainfo")).findElement(By.className("url"))
            .getText();
    String comment = review.findElement(By.className("comment-content")).getText();

    assertEquals("Dima", name);
    assertEquals(uniqueComment, comment);

  }

  @Test
  public void testAddingADuplicateReview() throws Exception {
    final String uniqueComment = generateUniqueComment();

    generateNewProductReview(uniqueComment);
    Thread.sleep(2000);
    generateNewProductReview(uniqueComment);

    String error = findElement(By.id("error-page")).getText();
    assertEquals("Duplicate comment detected; it looks as though you\u2019ve already said that!",
                 error);
  }

  protected String generateNewProductReview(String review) {
    navigateToHomePage();
    selectDesiredProductOnHomepage();
    fillOutCommentForm(review);
    return getNewlyCreatedReviewId();
  }


  protected void fillOutCommentForm(String comment) {
    findElement(By.id("author")).clear();
    findElement(By.id("email")).clear();
    findElement(By.id("url")).clear();

    typeText("Dima", By.id("author"));
    typeText("dima@selenium.com", By.id("email"));
    typeText("http://awful-valentine.com", By.id("url"));
    click(By.cssSelector("a[title='5']"));
    findElement(By.id("comment")).clear();
    typeText(comment, By.id("comment"));
    click(By.id("submit"));
  }

  protected WebElement findElement(By by) {
    return selenium.findElement(by);
  }

  protected void typeText(String text, By element) {
    findElement(element).sendKeys(text);
  }

  protected void click(By element) {
    findElement(element).click();
  }

  protected void selectDesiredProductOnHomepage() {
    click(By.cssSelector(".special-item a[href*=\"our-love-is-special\"].more-info"));
  }

  protected void navigateToHomePage() {
    selenium.get("http://awful-valentine.com/");
  }

  protected String generateUniqueComment() {
    return "This is a comment for product and is for " + new java.sql.Timestamp(
        Calendar.getInstance().getTime().getTime()).toString();
  }

  protected String getNewlyCreatedReviewId() {

    if (selenium.getCurrentUrl().contains("#")) {
      String[] splitString = selenium.getCurrentUrl().split("#");
      return splitString[1];
    } else {
      return "";
    }
  }


}

