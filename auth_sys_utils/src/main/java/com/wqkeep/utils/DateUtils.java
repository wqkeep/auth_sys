package com.wqkeep.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String dateToString(Date date, String patt){
        SimpleDateFormat sd = new SimpleDateFormat(patt);

        String format = sd.format(date);

        return format;
    }

    public static Date stringToDate(String date, String patt) throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat(patt);

        Date parse = sd.parse(date);

        return parse;
    }

}
