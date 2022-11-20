package karvein.algorithem;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        System.out.println();
    }
    // 注解和类名同名，所以没有引入Test包的形式使用注解
    public static String test(String[] s) {
        int index = 0;
        int len = s[0].length();
        StringBuilder j = new StringBuilder(s[0]);
        boolean flag = true;
        for (String value :
                s) {
            len = Math.min(len, value.length());
        }
        while (index < len && flag){
            for (String value :
                    s) {
                if (j.charAt(index) != value.charAt(index)) {
                    flag =false;
                }
            }
            index++;
        }
        if (index == 0) {
            return "";
        } else {
            return j.substring(0,index-1);
        }
    }

}
