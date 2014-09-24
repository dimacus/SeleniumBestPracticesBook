package chapter5;

import com.google.gson.internal.StringMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import org.openqa.selenium.By;

import java.util.Map;


import chapter5.fixtures.TestData;
import chapter5.helpers.SeleniumWrapper;

import static org.junit.Assert.assertEquals;


public class ProductValidationTest {

  private SeleniumWrapper selenium;

  @After
  public void tearDown() throws Exception {
    selenium.quit();
  }

  @Before
  public void setUp() throws Exception {
    selenium = new SeleniumWrapper("firefox");
  }

  @Test
  public void testAllProductsWithFixtures() throws Exception {
    Map<String, Object> foo = TestData.getProductFixtures();
    for ( String key : foo.keySet()) {
      Map<String, Object> productInfo = (Map<String, Object>) foo.get(key);
      selenium.get(TestData.getBaseUrl() + productInfo.get("url"));
      verifyProductInfo(productInfo);
    }
  }

  @Test
  public void testAllProductsWithApiResponse() throws Exception {
    for (StringMap productInfo : TestData.getProductsFromApi()) {
      selenium.get(TestData.getBaseUrl() + productInfo.get("url"));
      verifyProductInfo(productInfo);
    }
  }

  private void verifyProductInfo(Map productInfo) {
    assertEquals(productInfo.get("name"), getProductTitle());
    String
        expectedUrl = TestData.getBaseUrl() + ((String) productInfo.get("url")).replaceAll("/", "") + "/";
    assertEquals(expectedUrl, getCurrentUrl());
    assertEquals(productInfo.get("description"), getProductDescription());
    assertEquals(productInfo.get("price").toString(), getProductPrice());
  }

  private String getProductPrice() {
    return selenium.getInnerText(By.className("price-tag")).replaceAll("[\n\\$]", "");
  }

  private String getProductDescription() {
    return selenium.findElement(By.id("main-products")).findElement(By.className("content"))
        .getText();
  }

  private String getProductTitle() {
    return selenium.getInnerText(By.className("category-title"));
  }

  public String getCurrentUrl() {
    return selenium.getCurrentUrl();
  }
}