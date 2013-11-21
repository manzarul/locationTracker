/**
 * 
 */
package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import play.Logger;

/**
 * @author Manzarul.Haque
 *
 */
public class DateUtil {
	private static final String TIMEZONE = "UTC";
	private static DateUtil dateUtil = null;
	static{
		dateUtil = new DateUtil();
	}

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    
    public static String getSqlTimeStamp(Date date,String ... timeZone) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(timeZone != null && timeZone.length>0){
            format.setTimeZone(TimeZone.getTimeZone(timeZone[0]));
        }
        String dateStr = format.format(date);
        Logger.debug("formatted timeStamp:" + dateStr);
        return dateStr;
    }

    /**
     * this method will convert long value to date 
     * object and provide formatted date object in 
     * "yyyy-MM-dd HH:mm:ss" this form
     * @param time  
     * @return
     */
    public static String getSqlTimeStamp(Long time) {
        return getSqlTimeStamp(new Date(time));
    }


    /**
     *
     * @param date
     * @param timeZone
     * @return
     * @throws Exception
     */
    public static Date getDateInDefaultTimeZone (String date) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        SimpleDateFormat formatterWithDefaultTimeZone = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        format.setTimeZone(TimeZone.getTimeZone(TIMEZONE));
        Date reservationTimeWithTimeZone = format.parse(date);
        String reservationTimeWithDefaultTimeZone  = formatterWithDefaultTimeZone.format(reservationTimeWithTimeZone);
        return formatterWithDefaultTimeZone.parse(reservationTimeWithDefaultTimeZone);
    }



    /**
     * this method is used to take system current time and return time with time zone.
     *
     * @param date
     *            current date
     * @param timezone
     *            time
     * @return String 
     */
    public static String convertDateWithTimeZone(Date date, String timezone) {
        SimpleDateFormat dateFormatGmt = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        dateFormatGmt.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormatGmt.format(date);

    }
   
 
  public static Date convertStringToDate(String date) {
	  SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
      Date afterFormat = null;
      try {
          afterFormat = format.parse(date);
      } catch (Exception e) {
          e.printStackTrace();
      }
      return afterFormat;
  }
  
  
  public static final SimpleDateFormat dateFormatWithOutSeconds = new SimpleDateFormat("MM-dd-yyyy  HH:mm");
  public static final SimpleDateFormat dateFormatWithOutMilliSeconds = new SimpleDateFormat("MM-dd-yyyy  HH:mm:ss");
  
  
  /**
	 * get trip duration from milliseconds 
	 * @param tripDuration
	 * @return trip duration in String
	 */
	
	public static String getTripDurationFromMilliSeconds(long tripDuration)
	{

 	 String tripDurationString="";
 	   if(tripDuration>0)
 	   {
 		   if(tripDuration>=3600000) // 1hour=3600000 milliseconds
 		   {
 			   tripDurationString+=tripDuration/3600000+"h ";
 			   tripDuration=tripDuration%3600000;
 			   if(tripDuration>0)
 			   {
 				   tripDurationString+=tripDuration/60000+"m ";  
 				   tripDuration=tripDuration%60000;
 				   if(tripDuration>0)
     			   {
 					   tripDurationString+=tripDuration/1000+"s ";  
     			   }
 				   
 			   }
 			   
 		   }
 		   else
 		   {
 			   tripDurationString+=tripDuration/60000+"m ";      
 			   tripDuration=tripDuration%60000;
 				   if(tripDuration>0)
     			   {
 					   tripDurationString+=tripDuration/1000+"s ";  
     			   }
 				                  			   
 		   }
 		   
 	   }
 	   return tripDurationString;
	}
	
	
}
