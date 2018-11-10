package com.xtl.dictree.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;


public class XtlDateUtil {
    
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    
	public static String getPreDay(String specifiedDay){ 
		
		Calendar c = Calendar.getInstance(); 
		Date date=null; 
		try { 
			date = format.parse(specifiedDay); 
		} catch (ParseException e) { 
			e.printStackTrace(); 
		} 
		c.setTime(date); 
		int day=c.get(Calendar.DATE); 
		c.set(Calendar.DATE,day-1); 

		String preDay = format.format(c.getTime()); 
		return preDay; 
	} 
	
	public static String getNextDay(String specifiedDay){ 
		
		Calendar c = Calendar.getInstance(); 
		Date date=null; 
		try { 
			date = format.parse(specifiedDay); 
		} catch (ParseException e) { 
			e.printStackTrace(); 
		} 
		c.setTime(date); 
		int day=c.get(Calendar.DATE); 
		c.set(Calendar.DATE,day+1); 

		String nextDay = format.format(c.getTime()); 
		return nextDay; 
	} 
    
	public static List<Dictionary<String, String>> getDateBetween(String sdate, String edate) throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		List<Dictionary<String, String>> rslt = new ArrayList<Dictionary<String,String>>();
		
		String last_day = lastDayOfMonth(sdate);
		String first_day = sdate;
		while(last_day.compareTo(edate)<0){
			Dictionary<String, String> dic = new Hashtable<String, String>();
			dic.put("sdate", first_day);
			dic.put("edate", last_day);
			rslt.add(dic);
			last_day = lastDayOfNextMonth(last_day);
			first_day = firstDayOfMonth(last_day);
		}
		
		Dictionary<String, String> dic = new Hashtable<String, String>();
		dic.put("sdate", first_day);
		dic.put("edate", edate);
		rslt.add(dic);
		
		return rslt;
	}
	
	public static String lastDayOfMonth(String date) throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
	    
	    Calendar calendar = Calendar.getInstance();
        calendar.setTime(df.parse(date));
        calendar.add(Calendar.MONTH, 1);  
        calendar.set(Calendar.DATE, 0);  
	    return df.format(calendar.getTime());
	}
	
	private static String lastDayOfNextMonth(String date) throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
	    
	    Calendar calendar = Calendar.getInstance();
        calendar.setTime(df.parse(date));
        calendar.add(Calendar.MONTH, 2);  
        calendar.set(Calendar.DATE, 0);  
	    return df.format(calendar.getTime());
	}

	private static String firstDayOfMonth(String date) throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
	    
	    Calendar calendar = Calendar.getInstance();
        calendar.setTime(df.parse(date));
        calendar.set(Calendar.DATE, 1);
	    return df.format(calendar.getTime());
	}
	
	public static String lastDayOfWeek(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal =Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		try {
			if(sdf.parse(date).after(cal.getTime())){
				cal.add(Calendar.WEEK_OF_YEAR, 1);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		String rslt = sdf2.format(cal.getTime());
		return rslt;
	}
	
	public static String firstDayOfWeek(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal =Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		try {
			if(cal.getTime().after(sdf.parse(date))){
				cal.add(Calendar.WEEK_OF_YEAR, -1);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		String rslt = sdf2.format(cal.getTime());
		return rslt;
	}
	
	public static String getNow(String type){
		SimpleDateFormat sdf = null;
		switch(type){
		case "year":
			sdf = new SimpleDateFormat("yyyy");
			break;
		case "month":
			sdf = new SimpleDateFormat("yyyy-MM");
			break;
		case "day":
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			break;
		case "hour":
			sdf = new SimpleDateFormat("yyyy-MM-dd HH");
			break;
		case "minute":
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			break;
		case "second":
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			break;
		default:
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			break;
		}
		Date date = new Date();
		return sdf.format(date);
	}
}