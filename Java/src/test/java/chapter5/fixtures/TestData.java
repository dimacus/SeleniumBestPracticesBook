package chapter5.fixtures;

import com.google.gson.internal.StringMap;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import chapter4.JSONFixtures;
import chapter4.YAMLFixtures;

public class TestData {

  final private static Faker faker = new Faker();
  final private static Map<String, String> environmentList;

  static {
    environmentList = new HashMap<String, String>();
    environmentList.put("production", "http://awful-valentine.com/");
    environmentList.put("staging", "http://staging.awful-valentine.com/");
    environmentList.put("test", "http://test.awful-valentine.com/");
  }

  public static String getFullName() {
    return faker.name().fullName();
  }

  public static String getEmail() {
    return faker.internet().emailAddress();
  }

  public static String getWebsite() {
    return faker.internet().url();
  }

  public static String getBuzzword() {
    //Using this combo since java implementation does not have a buzz word generator
    return faker.name().firstName() + " " + faker.lorem().sentence();
  }

  public static Map<String, String> getCommentFormValues() {
    return getCommentFormValues(new HashMap<String, String>());
  }

  public static Map<String, String> getCommentFormValues(Map<String, String> overwrites) {
    Map<String, String> returnValue = new HashMap<String, String>();
    returnValue.put("name", getFullName());
    returnValue.put("email", getEmail());
    returnValue.put("url", getWebsite());
    returnValue.put("comment", getBuzzword());

    for (String key : overwrites.keySet()) {
      returnValue.put(key, overwrites.get(key));
    }

    return returnValue;

  }

  public static Map<String, Object> getProductFixtures(){
    return YAMLFixtures.parseYaml();
  }

  public static List<StringMap> getProductsFromApi(){
    return JSONFixtures.parseJsonFixtures();
  }

  public static String getBaseUrl() {
    return environmentList.get(getEnvironment());
  }

  public static String getEnvironment() {
    Map<String, String> env = System.getenv();

    if (env.keySet().contains("environment")) {
      return env.get("environment");
    } else {
      return "test";
    }
  }

}
