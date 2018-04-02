package com.example.ksachdev.myringtonemanager;

import android.util.Log;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by ksachdev on 2018-03-31.
 */

public class Tools {
    private static final String TAG  = "MyTools";
    public Tools(){

    }
    public String getDatePrefix(int dayOfMonth){
        String day_str = "";
        if(dayOfMonth < 10){
            day_str = "0"+dayOfMonth;
        }else{
            day_str = dayOfMonth+"";
        }
        return day_str;
    }

    public String getFormattedTime(int hourOfDay, int minutes){
        String result = "";
        String prefix = "";
        String minute = "";

        String hour = "";
        if(hourOfDay > 12){
            hour = (hourOfDay - 12) + "";
            prefix = "PM";
        }else if(hourOfDay == 12){
            hour = hourOfDay + "";
            prefix = "PM";

        }else if(hourOfDay < 12){
            hour = hourOfDay + "";
            prefix = "AM";
        }

        if(minutes < 10){
            minute = "0" + minutes;
        }else{
            minute = minutes + "";
        }

        result = hour + ":" + minute + " " + prefix;
        return result;
    }

    public boolean isDatePassed(String date){
        Calendar cal = Calendar.getInstance();
        Date cDate = new Date();
        cal.setTime(cDate);

        date = date + " " + cal.get(cal.HOUR) + ":" + cal.get(cal.MINUTE);
        Date mDate = new SimpleDateFormat("MMM dd , yyyy HH:mm").parse(date,new ParsePosition(0));


        Log.i(TAG,mDate.toString() + "," + cDate.toString());
        if(mDate.before(cDate)){
            return false;
        }
        return true;
    }

    public boolean isDateBefore(String mDate,String date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        mDate = mDate + " " + cal.get(cal.HOUR) + ":" + cal.get(cal.MINUTE);
        date = date + " " + cal.get(cal.HOUR) + ":" + cal.get(cal.MINUTE);

        Date mParseDate = new SimpleDateFormat("MMM dd , yyyy").parse(mDate,new ParsePosition(0));
        Date parseDate = new SimpleDateFormat("MMM dd , yyyy").parse(date,new ParsePosition(0));

        if(mParseDate.before(parseDate) || mParseDate.equals(parseDate)){
            return true;
        }
        return false;
    }
}