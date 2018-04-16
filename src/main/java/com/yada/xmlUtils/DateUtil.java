package com.yada.xmlUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sungang on 2017/4/6.
 */
public class DateUtil {
    public static String addDay(String startDay) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date now = sdf.parse(startDay);
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.add(Calendar.DAY_OF_MONTH,1);
        Date addDay = c.getTime();

     return sdf.format(addDay);
    }

}
