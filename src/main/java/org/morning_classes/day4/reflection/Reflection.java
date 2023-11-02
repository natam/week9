package org.morning_classes.day4.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) {
        Person person1 = new Person("Natallia", 36);
        Class myClass = person1.getClass();
        System.out.println("Class name: " + myClass.getName());
        System.out.println("Class fields: ");
        for(Field field: myClass.getDeclaredFields()){
            System.out.println(field.getName());
        }
        System.out.println("Class methods: ");
        for(Method method: myClass.getDeclaredMethods()){
            System.out.println(method.getName());
        }
        try {
            System.out.println(myClass.getDeclaredMethod("getName").invoke(person1));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            Object person2 = myClass.getDeclaredConstructor().newInstance();
            myClass.getDeclaredMethod("setName", String.class).invoke(person2, "Nina");
            System.out.println(myClass.getDeclaredMethod("getName").invoke(person2));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
