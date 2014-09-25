package chapter7.pageObjects.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

import chapter7.pageObjects.shared.Page;

public class HomePage extends Page {


  public HomePage(WebDriver selenium) throws Exception {
    super(selenium);
  }

  public SpecialItems getSpecialItems() {
    return new SpecialItems(this.selenium);
  }

  @Override
  public String getPagePath() {
    return "/";
  }

  @Override
  public PageBody getPageBody() {
    return null;
  }

  public Object getRecentProducts() {
    //IMPLEMENT ME
    return null;
  }


  public Object getFeaturedItemCarousel() {
    //IMPLEMENT ME
    return null;
  }

  public class SpecialItems{

    protected WebDriver selenium;
    protected List<SpecialItem> elements = new LinkedList<SpecialItem>();

    public SpecialItems(WebDriver selenium) {
      this.selenium = selenium;

      for (WebElement e : selenium.findElements(By.className("special-item"))) {
        this.elements.add(new SpecialItem(e, selenium));
      }

    }

    public SpecialItem get(int index){
      return this.elements.get(index);
    }

    public class SpecialItem {

      protected WebDriver selenium;
      protected WebElement element;

      public SpecialItem(WebElement element, WebDriver selenium) {
        this.selenium = selenium;
        this.element = element;
      }


      public void addToCart() {
        this.element.findElement(By.className("add-to-cart")).click();
        this.selenium.findElement(By.id("fancybox-outer")).findElement(By.className("purAddToCart"))
            .click();
      }

    }

  }

}
