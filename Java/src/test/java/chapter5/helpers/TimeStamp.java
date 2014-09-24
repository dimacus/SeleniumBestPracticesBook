package chapter5.helpers;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStamp {

  public static String getTimestamp(){
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yyyy_h_mm_ss");
    return sdf.format(date);
  }

}
