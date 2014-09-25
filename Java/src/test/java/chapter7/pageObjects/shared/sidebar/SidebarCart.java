package chapter7.pageObjects.shared.sidebar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SidebarCart {

  private WebDriver selenium;

  public SidebarCart(WebDriver selenium){
    this.selenium = selenium;
  }

  public String getSummary(){
    return selenium.findElement(By.id("Cart66WidgetCartEmptyAdvanced")).getText();

  }

  public String getSubtotal(){
    return selenium.findElement(By.className("Cart66Subtotal")).getText();
  }


}
