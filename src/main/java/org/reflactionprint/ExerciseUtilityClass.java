package org.reflactionprint;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;

/*
* Tipalti interview utility class
* 02/01/2023
*
* I am not familiar with .NET reflection APIs
* */
public class ExerciseUtilityClass {
    private static ArrayList<Integer> arrayOfHashes = new ArrayList<>();
    public static void printObject(Object o) {
        printObject(o, "  ");
    }

    private static void printObject(Object o, String space) {
        if (Objects.isNull(o)) {
            System.out.println("null");
            return;
        }

        if (arrayOfHashes.contains(o.hashCode())) {
            System.out.println(space + "[" + o.hashCode() + "] Printing object already been printed under this section");
            return;
        }

        arrayOfHashes.add(o.hashCode());
        if (!isPrimitiveObject(o)) {
            System.out.println(space + "Object of Class \" " + o.getClass().getSimpleName() + "\" [" + o.hashCode() + "]");
            System.out.println(space + "-----------------------------------------------------------");
            for (Field f : o.getClass().getDeclaredFields()) {
                Object fieldValue = getFieldValue(f, o);
                System.out.print(space.repeat(2) + f.getName() + " = ");
                if (Objects.isNull(fieldValue)) {
                    System.out.println("null");
                } else if (isPrimitiveObject(fieldValue)) {
                    System.out.println(fieldValue);
                } else if (isArray(fieldValue)) {
                    printArray(fieldValue);
                }else {
                    System.out.println();
                    printObject(fieldValue, space.repeat(2));
                }
            }
        } else {
            printPrimitive(o);
        }
        arrayOfHashes.remove(arrayOfHashes.indexOf(o.hashCode()));
    }

    private static void print(String str) {
        //
    }

    private static Object getFieldValue(Field f, Object o) {
        try {
            f.setAccessible(true);
            return f.get(o);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void printArray(Object o) {
        System.out.print(" [ ");
        for (int i = 0; i < Array.getLength(o) - 1; i++) {
            System.out.print(Array.get(o, i));
        }
        System.out.println(Array.get(o, Array.getLength(o) - 1) + " ] ");
    }

    private static void printPrimitive(Object o) {
        System.out.println("value for object from primitive type : " + o.getClass().getSimpleName() + " is " + o);
    }

    private static boolean isArray(Object o) {
        return o.getClass().isArray();
    }

    private static boolean isPrimitiveObject(Object o) {
        return o.getClass().getPackageName().equals("java.lang") && !o.getClass().isArray();
    }
}
