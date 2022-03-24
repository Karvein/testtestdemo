package karvein.test03;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) throws Exception{
        Class userClass = Class.forName("karvein.test03.User");
        Field[] fieldArray = userClass.getDeclaredFields();
        for (Field field : fieldArray
        ) {
            System.out.println(field);
        }
        Method[] methods = userClass.getDeclaredMethods();
        for (Method method : methods
        ) {
            System.out.println(method);
        }
    }
}
