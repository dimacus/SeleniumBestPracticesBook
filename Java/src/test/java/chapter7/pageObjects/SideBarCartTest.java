package chapter7.pageObjects;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

import chapter7.pageObjects.contactUsPage.ContactUsPage;
import chapter7.pageObjects.homePage.HomePage;

public class SideBarCartTest {

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
  public void testSidebarCartOnContactPage() throws Exception {

    selenium.get("http://awful-valentine.com/");

    HomePage homePage = new HomePage(selenium);
    homePage.getSpecialItems().get(0).addToCart();

    selenium.get("http://awful-valentine.com/contact-us");
    ContactUsPage contactUsPage = new ContactUsPage(selenium);
    assertEquals("You have 1 item ($5.77) in your shopping cart.",
                 contactUsPage.getSidebar().getSidebarCart().getSummary());
    assertEquals("$5.77", contactUsPage.getSidebar().getSidebarCart().getSubtotal());


  }

}
