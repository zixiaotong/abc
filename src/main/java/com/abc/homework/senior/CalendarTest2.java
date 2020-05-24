package com.abc.homework.senior;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class CalendarTest2 {
    public CalendarTest2() {
    }

    public static void main(String[] args) {
//        Calendar calendar1 = Calendar.getInstance();
//        calendar1.set(2020, 4 - 1, 1);
//        Calendar calendar2 = Calendar.getInstance();
//        long difference = calendar2.getTimeInMillis() - calendar1.getTimeInMillis();
//        System.out.println("相差" + difference / 1000 / 60 / 60 / 24 + "天");
//        // -------------------------------------------------------------------------------------------------
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(calendar.DATE, 1);
//        int start = calendar.get(calendar.DAY_OF_WEEK);
//        int end = calendar.getActualMaximum(calendar.DATE);
//        System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
//        for (int i = 1; i < start; i++) {
//            System.out.print("\t\t");
//        }
//        for (int i = 1; i < end; i++) {
//            System.out.print(i + "\t\t");
//            if ((start - 1 + i) % 7 == 0) {
//                System.out.println();
//            }
//        }

        // -------------------------------------------------------------------------------------------------
//        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
//        SimpleDateFormat myFmt1 = new SimpleDateFormat("yy/MM/dd HH:mm");
//        SimpleDateFormat myFmt2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat myFmt3 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒E");
//        SimpleDateFormat myFmt4 = new SimpleDateFormat("一年中的第D天 一年中的第w个星期 一月中第W个星期在一天中k时z时区");
//        Date now = new Date();
//        System.out.println(myFmt.format(now));
//        System.out.println(myFmt1.format(now));
//        System.out.println(myFmt2.format(now));
//        System.out.println(myFmt3.format(now));
//        System.out.println(myFmt4.format(now));
//        System.out.println(now);


        LinkedList<String> all = new LinkedList<>();
        all.add("HELLO");
        all.add("world");
        System.out.println(all);
        for (int i = 0; i < all.size(); i++) {
            System.out.println(all.get(i));
        }
        System.out.println("==============");

        all.addFirst("First");
        for (int i = 0; i < all.size(); i++) {
            System.out.println(all.get(i));
        }
        System.out.println("==============");
        all.addLast("Last");
        for (int i = 0; i < all.size(); i++) {
            System.out.println(all.get(i));
        }
        System.out.println("==============");


    }
}
