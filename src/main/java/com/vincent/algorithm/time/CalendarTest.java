package com.vincent.algorithm.time;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) {
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime localDateTime = LocalDateTime.parse("1987-01-01 00:00:00", df);
//
//        CalendarTest calendarTest = new CalendarTest();
//        calendarTest.queryHoursOfDay(localDateTime);
//        calendarTest.getHoursBelow24(1987);

        Date date = new Date(-842778000000L);
        System.out.println(date);

    }


    /**
     * 计算夏令时
     *
     * @param year
     * @return
     */
    public SummerTime calculateSummerTime(int year) {
        return null;
    }

    /**
     * 查询一天有多少小时
     *
     * @param localDateTime
     * @return
     */
    public int queryHoursOfDay(LocalDateTime localDateTime) {
        int dayOfYear = localDateTime.getDayOfYear();
        int count = 0;
        while (dayOfYear == localDateTime.getDayOfYear()) {
            count++;
            // 添加30 minutes
            localDateTime = localDateTime.plusHours(1);
        }

        return count;
    }

    public LocalDateTime getHoursBelow24(int year) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(year + "-01-01 00:00:00", df);

        // 查询一天有多少小时
        while (localDateTime.getYear() == year) {

            int dayOfYear = localDateTime.getDayOfYear();
            int count = 0;
            while (dayOfYear == localDateTime.getDayOfYear()) {
                count++;
                // 添加30 minutes
                localDateTime = localDateTime.plusHours(1);
            }
            if(count!=24){
                System.out.println(count);
                System.out.println(df.format(localDateTime));
            }
        }

        System.out.println(df.format(localDateTime));

        return localDateTime;
    }


    public static class SummerTime {
        public int year;
        public String enterTime;
        public String quitTime;
    }
}
