package org.example;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
    String str();
    int val();
}
public class Main {

        @MyAnno(str = "My Method Annotation Title", val = 1560)
        public static void myMeth() {

            Main obtain = new Main();

            try {
                Class<?> c = obtain.getClass();

                Method m = c.getMethod("myMeth");

                MyAnno anno = m.getAnnotation(MyAnno.class);
                System.out.println("\u001B[35mAnnotation String = \u001B[34m" + anno.str() + "\u001B[35m , Method ID Number = \u001B[34m" + anno.val());

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {

         CustomList<Integer> numberList = new CustomArrayList<>();

        for (int i=0; i< 99; i++) {
            numberList.add(i+1);
            System.out.print(i + "\u001B[33m-");
        }

        System.out.println();
        myMeth();

    }
}