package com.epam.reflection.tutorial;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;


/**
 * Created by Зая on 28.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        Bachelor bachelor = new Bachelor("Ivan", 4, 5555, "Filters", Qualification.INFORMATION_TECHNOLOGIES);
        Class<?> sub = bachelor.getClass();
        // getSubclassInfoDetails(bachelor);
        //  getSuperclassInfoDetails(sub);
        //  getFields(sub);
        //  getConstructors(sub);
        // getMethods(sub);
        // parseAnnotation(sub);
        Bachelor resrored = restoreBachelorInstance(sub, "Ivan", 4, 5555, "Filters", Qualification.INFORMATION_TECHNOLOGIES);
        invokeSetDegreeWorkTitleMethod(resrored,sub,"New title");
        System.out.println(resrored);
    }

    public static void getSubclassInfoDetails(Object object) {
        Class<?> sub = object.getClass();
        System.out.println("The class name: " + sub.getName() + " Simple name: " + sub.getSimpleName());
        System.out.println("The package name: " + sub.getPackage());
        int mods = sub.getModifiers();
        if (Modifier.isPublic(mods)) {
            System.out.println("public");
        }
        if (sub.isAnnotationPresent(ClassInfo.class)) {
            System.out.println(Arrays.toString(sub.getAnnotations()));
        }
    }

    public static void getSuperclassInfoDetails(Class<?> object) {
        Class<?> superC = object.getSuperclass();
        System.out.println("The super class canonical name: " + superC.getCanonicalName());
        Class[] interfaces = superC.getInterfaces();
        System.out.println("Interfaces, implemented by a super class: " + Arrays.toString(interfaces));
    }

    public static void getFields(Class<?> object) {
        System.out.println("Declared fields and their annotations:");
        Field[] fields = object.getDeclaredFields();
        // Field[] fields = object.getFields();
        for (Field item : fields) {
            int mods2 = item.getModifiers();
            if (Modifier.isPrivate(mods2)) {
                System.out.print("private ");
            } else if (Modifier.isPublic(mods2)) {
                System.out.print("public ");
            }
            System.out.println(item.getType().getSimpleName() + " " + item.getName());
            if (item.isAnnotationPresent(FieldAnnotation.class)) {
                System.out.println(Arrays.toString(item.getAnnotations()) + "\n");
            }
        }
    }

    public static void getConstructors(Class<?> object) {
        Constructor[] constructors = object.getConstructors();
        System.out.println(Arrays.toString(constructors));
        int i = 1;
        for (Constructor item : constructors) {
            System.out.println("\nConstructor " + (i++) + ": ");
            System.out.print("Parameter types:");
            Class<?>[] paramTypes = item.getParameterTypes();
            for (Class param : paramTypes) {
                System.out.print(param.getSimpleName() + ", ");
            }
        }
    }

    public static void getMethods(Class<?> object) {
        Method[] methods = object.getDeclaredMethods();
        System.out.println("Declared methods: ");
        for (Method m : methods) {
            int mods2 = m.getModifiers();
            if (Modifier.isPublic(mods2)) {
                System.out.print("\n" + "public ");
            }
            System.out.print(m.getReturnType().getSimpleName() + " " + m.getName() + "(");
            Class<?>[] paramTypes = m.getParameterTypes();
            for (Class param : paramTypes) {
                System.out.print(param.getSimpleName() + " ");
            }
            System.out.println(")");
        }
    }

    public static void parseAnnotation(Class<?> object) {
        Method[] methods = object.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(MethodInfo.class)) {
                for (Annotation annotation : m.getDeclaredAnnotations()) {
                    System.out.println("\nAnnotation in method '" + m.getName() + "' : " + annotation);
                }
                if (m.getAnnotation(MethodInfo.class).revision() == 1) {
                    System.out.println("Method with revision number 1= " + m);
                }
            }
        }
    }

    public static Bachelor restoreBachelorInstance(Class<?> object, String name, int courseYear, int id,
                                                   String degreeWorkTitle, Qualification qualification) {
        Bachelor bachelor = null;
        try {
            Constructor<?> ctr = object.getConstructor(String.class, int.class, int.class, String.class, Qualification.class);
            bachelor = (Bachelor) ctr.newInstance(name, courseYear, id, degreeWorkTitle, qualification);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bachelor;
    }
    public static void invokeSetDegreeWorkTitleMethod(Bachelor instance,Class<?> object,String thesisTitle){
        try {
            Method method=object.getMethod("setDegreeWorkTitle", String.class );
            method.invoke(instance,thesisTitle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
