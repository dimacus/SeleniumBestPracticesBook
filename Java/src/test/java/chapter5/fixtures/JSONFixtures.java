package chapter5.fixtures;

import com.google.gson.Gson;
import com.google.gson.internal.StringMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//I'm Cheating here a little, by not parsing an actual JSON HTTP Request but storing it as a string
//I'm saving myself some headache of managing external dependencies with Java.
//In Real life you will probably have a text file instead.
public class JSONFixtures {

  private final static String json ="[\n"
                                    + "  {\n"
                                    + "    \"id\": 1,\n"
                                    + "    \"name\": \"Closeness and Togetherness\",\n"
                                    + "    \"description\": \"Show how much you appreciate just how close the two of you are\",\n"
                                    + "    \"rating\": 0.5,\n"
                                    + "    \"price\": 5.77,\n"
                                    + "    \"url\": \"/closeness-and-togetherness\",\n"
                                    + "    \"image\": \"/wp-content/uploads/2014/02/beeing_close_together.png\"\n"
                                    + "  },\n"
                                    + "  {\n"
                                    + "    \"id\": 2,\n"
                                    + "    \"name\": \"Lets Grow Old Together!\",\n"
                                    + "    \"description\": \"Isn’t it wonderful that you get to know your partner better and better each year? The person you though you first met is not necessarily the one you see today, isn’t that just the best and happiest thing ever?\",\n"
                                    + "    \"rating\": 4.5,\n"
                                    + "    \"price\": 88.79,\n"
                                    + "    \"url\": \"/lets-grow-old-together\",\n"
                                    + "    \"image\": \"/wp-content/uploads/2014/02/growing_old_together.png\"\n"
                                    + "  },\n"
                                    + "  {\n"
                                    + "    \"id\": 3,\n"
                                    + "    \"name\": \"Taking Long Drives Together\",\n"
                                    + "    \"description\": \"Don’t you just love taking a long drive to see the in-laws; that feeling of spending hours and hours talking about your relationship, your feelings, and rehashing old memories and admitting how dumb you were to make that mistake.\",\n"
                                    + "    \"rating\": 1.0,\n"
                                    + "    \"price\": 19.99,\n"
                                    + "    \"url\": \"/taking-long-drives-together\",\n"
                                    + "    \"image\": \"/wp-content/uploads/2014/02/long_drives.png\"\n"
                                    + "  },\n"
                                    + "  {\n"
                                    + "    \"id\": 4,\n"
                                    + "    \"name\": \"Our love is special!!\",\n"
                                    + "    \"description\": \"Why do you stay together after years and years of fighting and childish behavior? You know there is a reason, even if you cannot put it in words. Use this card to finally put into words how you truly feel!\",\n"
                                    + "    \"rating\": 3.5,\n"
                                    + "    \"price\": 68.99,\n"
                                    + "    \"url\": \"/our-love-is-special\",\n"
                                    + "    \"image\": \"/wp-content/uploads/2014/02/more_than_meets_the_eye.png\"\n"
                                    + "  },\n"
                                    + "  {\n"
                                    + "    \"id\": 5,\n"
                                    + "    \"name\": \"Never Forget The Special Day!\",\n"
                                    + "    \"description\": \"After a long hard day at work, or with kids, you should not have a silly little fight about how you forgot that special day. Make sure you remember it, and show exactly just how much your significant other cares about this day!\",\n"
                                    + "    \"rating\": 3.0,\n"
                                    + "    \"price\": 99.99,\n"
                                    + "    \"url\": \"/never-forget-the-special-day\",\n"
                                    + "    \"image\": \"/wp-content/uploads/2014/02/never_forget.png\"\n"
                                    + "  },\n"
                                    + "  {\n"
                                    + "    \"id\": 6,\n"
                                    + "    \"name\": \"Wrapped In Your Love\",\n"
                                    + "    \"description\": \"Show the special one in your life just how much you appreciate him or her in your life. They spend so much time without, ever letting you feel lonely by going everywhere with you. You would be so alone without them, and your friends always appreciate that you are always together to hang out. Let your significant other know, that you love the closeness!!\",\n"
                                    + "    \"rating\": 4.0,\n"
                                    + "    \"price\": 49.99,\n"
                                    + "    \"url\": \"/wrapped-in-love\",\n"
                                    + "    \"image\": \"/wp-content/uploads/2014/02/wraped_in_love.png\"\n"
                                    + "  }\n"
                                    + "]";

  public static List<StringMap> parseJsonFixtures(){
    return ((List<StringMap>) new Gson().fromJson(json, LinkedList.class));
  }

}
