package com.study.javastudy.time;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

public class LocalDateTest {
    @Test
    public void test01(){
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(localDate.minusMonths(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(localDate.minusMonths(2).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(localDate.minusMonths(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(localDate.minusMonths(4).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
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

        LocalDateTime of1 = LocalDateTime.of(2021, 1, 5, 10, 10, 10);
        LocalDateTime of2 = LocalDateTime.of(2021, 1, 5, 10, 10, 11);
        System.out.println(of1.equals(of2));
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
        LocalDate localDate1 = LocalDate.parse("2022-02-06");
        System.out.println(localDate);
        System.out.println(localDate1);
        Period between = Period.between(localDate, localDate1);
        System.out.println(between.getDays());// 天数相减
        System.out.println(between.getMonths());//月份相减
        System.out.println(between.getYears());//年相减


        System.out.println(ChronoUnit.DAYS.between(localDate, localDate1));
        System.out.println(ChronoUnit.MONTHS.between(localDate, localDate1));
        System.out.println(ChronoUnit.YEARS.between(localDate, localDate1));


        LocalDateTime localDateTime  = LocalDateTime.now();
        LocalDate localDate2 = localDateTime.toLocalDate();
        LocalDate from = LocalDate.from(localDateTime);
        System.out.println(localDateTime);
        System.out.println(localDate2);
        System.out.println(from);
    }

    @Test
    public void test05_1(){
        LocalDate parse = LocalDate.parse("2022-01-07");
        LocalDate parse1 = LocalDate.parse("2020-11-05");
        Period period = Period.between(parse1,parse);
        int months = period.getMonths();
        System.out.println(months);
        System.out.println(ChronoUnit.MONTHS.between(parse1, parse));

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


    /**
     * 比较今天是否生日
     */
    @Test
    public void test07(){
        LocalDate localDateBirth = LocalDate.of(1989,1,5);
        MonthDay birthDay = MonthDay.of(localDateBirth.getMonth(),localDateBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(LocalDate.now());
        boolean equals = currentMonthDay.equals(birthDay);
        System.out.println(equals);

        System.out.println(localDateBirth.getMonthValue() == LocalDate.now().getMonthValue() && localDateBirth.getDayOfMonth() == LocalDate.now().getDayOfMonth());

    }

    @Test
    public void test08(){
        System.out.println(LocalTime.now());
        System.out.println(LocalTime.now().plusHours(2));

        LocalDate now = LocalDate.now();
        LocalDate plus = now.plus(1, ChronoUnit.WEEKS);
        System.out.println(plus);

        LocalDate localDate = plus.minusWeeks(1);
        System.out.println(localDate);
        System.out.println(Math.floor(3.4D));
    }

    @Test
    public void test09(){
        LocalDate now = LocalDate.now();
        LocalDate plus = now.plus(1, ChronoUnit.DAYS);
        System.out.println(now);
        System.out.println(plus);
        System.out.println(now.isBefore(plus));

    }

    /**
     * Date 与 Instant 互转
     */
    @Test
    public void test10(){
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(System.currentTimeMillis());
        Date from = Date.from(now);
        System.out.println(from);
        System.out.println(from.toInstant());
    }





}
