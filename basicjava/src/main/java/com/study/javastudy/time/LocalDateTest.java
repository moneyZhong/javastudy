package com.study.javastudy.time;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateTest {
    @Test
    public void test01(){
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("yyyy-MM")));
        System.out.println(localDate.minusMonths(1).format(DateTimeFormatter.ofPattern("yyyy-MM")));
        System.out.println(localDate.minusMonths(2).format(DateTimeFormatter.ofPattern("yyyy-MM")));
        System.out.println(localDate.minusMonths(3).format(DateTimeFormatter.ofPattern("yyyy-MM")));
        System.out.println(localDate.minusMonths(4).format(DateTimeFormatter.ofPattern("yyyy-MM")));
    }

    /**
     * 时间字符串转化
     */
    @Test
    public void  test02(){
        String format = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(format);

        LocalDate of = LocalDate.of(2020, 9, 9);
        System.out.println(of.format(DateTimeFormatter.ISO_DATE));

        LocalDateTime parse = LocalDateTime.parse("2020-10-10 13:24:55", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(parse.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    /**
     * 时间操作
     */
    @Test
    public void test03(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        int year = localDateTime.getYear();
        int month = localDateTime.getMonthValue();
        int day = localDateTime.getDayOfMonth();
        int hour = localDateTime.getHour();
        int minis = localDateTime.getMinute();
        int second = localDateTime.getSecond();
        System.out.println(year+"-"+month+"-"+day+" "+hour+":"+minis+":"+second);

        LocalDateTime localDateTime1 = localDateTime.plusDays(25);
        System.out.println(localDateTime1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        LocalDateTime localDateTime2 = localDateTime.minusDays(5);
        System.out.println(localDateTime2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

    }

    @Test
    public void test04() throws Exception{
        Instant instant = Instant.now();
        Thread.sleep(1000);
        Instant instant1 = Instant.now();
        Duration between = Duration.between(instant, instant1);
        System.out.println(between.toMillis());
    }

    @Test
    public void test05(){
//        LocalDateTime localDateTime = LocalDateTime.of(2020, 1, 12, 12, 13,15);
//        LocalDateTime localDateTime1 = LocalDateTime.parse("2020-01-13 05:00:00");
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.parse("2020-10-01");
        Period between = Period.between(localDate, localDate1);
        System.out.println(between.getDays());

        LocalDateTime localDateTime  = LocalDateTime.now();
        LocalDate localDate2 = localDateTime.toLocalDate();
        System.out.println(localDate2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    /**
     * LocalDateTime 与 Date 互转
     */
    @Test
    public void test06(){
        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        Date from = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(from));
    }


}
