package karvein.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) throws Exception{
        Class userClass = Class.forName("karvein.reflection.User");
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
