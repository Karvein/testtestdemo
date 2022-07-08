package karvein.basicClass;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {

    public static void main(String[] args) {
        // 时间
        Date date = new Date();
        System.out.println(date);

        // 时间格式化
        SimpleDateFormat ft = new SimpleDateFormat ("GG yyyy年MM月dd日 hh:mm:ss ");
        System.out.println("当前时间为: " + ft.format(date));

        // 当前时间戳
        System.out.println(System.currentTimeMillis());

        System.out.println(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss" ).format(System.currentTimeMillis()));

    }

}
