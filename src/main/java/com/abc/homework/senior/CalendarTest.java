package com.abc.homework.senior;

import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(calendar.YEAR);
        int month = calendar.get(calendar.MONTH);
        int date = calendar.get(calendar.DATE);


        int hour = calendar.get(calendar.HOUR);
        int minute = calendar.get(calendar.MINUTE);
        int second = calendar.get(calendar.SECOND);

        System.out.println("年：" + year);
        System.out.println("月：" + (month + 1));
        System.out.println("日：" + date);
        System.out.println("时：" + hour);
        System.out.println("分：" + minute);
        System.out.println("秒：" + second);

    }
}
