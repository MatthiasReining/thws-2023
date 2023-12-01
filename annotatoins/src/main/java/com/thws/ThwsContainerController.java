package com.thws;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Hello world!
 *
 */
public class ThwsContainerController {

    static void iniateContainerObject(Object o) {

        try {
            Class clazz = o.getClass();

            System.out.println("Fields:");
            for (Field f : clazz.getDeclaredFields()) {
                System.out.println(f);
                System.out.println("field annotations");
                for (Annotation a : f.getAnnotations()) {
                    if (ThwsController.class.equals(a.annotationType())) {
                        System.out.println("Controller annotations found!");

                        // neuer Service
                        ThwsService ts = new ThwsService();

                        f.set(o, ts);
                    }
                }

            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        try {

            Class clazz = Class.forName("com.thws.ThwsLogic1");
            System.out.println(clazz);

            // create object
            Object o = clazz.newInstance();

            iniateContainerObject(o);

            Method methodDoSomething = clazz.getMethod("doSomething");
            System.out.println(methodDoSomething);

            // execute method
            methodDoSomething.invoke(o);

        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
