package org.example;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
    String str();
    int val();
    int id();
}
public class Main {

        @MyAnno(str = "Custom^_^Title", val = 1560 , id = 45)
        public static void myMeth() {

            Main obtain = new Main();

            try {
                Class<?> c = obtain.getClass();

                Method m = c.getMethod("myMeth");

                MyAnno anno = m.getAnnotation(MyAnno.class);
                System.out.println("\u001B[35mAnnotation String = \u001B[34m" + anno.str() + "\u001B[35m , Method ID Number = \u001B[34m" + anno.id());

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {

         CustomList<Integer> numberList = new CustomArrayList<>();

        for (int i=0; i<= 20; i++) {
            numberList.add(i);
            System.out.print(i + "\u001B[33m-");
        }

            System.out.println();
        numberList.remove(4);

            System.out.println("--------------------- Number 4 removed from array\u001B[36m");

            for (int i=0; i< numberList.getSize(); i++) {

                System.out.println(i + ")" + numberList.get(i));
            }

            numberList.add(4, 4);

            System.out.println("\u001B[33m--------------------- Number 4 added back to array\u001B[36m");

            for (int i=0; i< numberList.getSize(); i++) {

                System.out.println(i + ")" + numberList.get(i));
            }

            System.out.println("---------------------");


            int arrayLength = 16;


            CustomList<Character> charArray = new CustomArrayList<>();


            for (int i = 0; i < arrayLength; i++) {

                char randomChar = (char) ('A' + (int) (Math.random() * 26));
                charArray.add(i, randomChar);
            }


            System.out.println("\u001B[33mGenerated Character Array:\u001B[34m");
            for (int i = 0; i < charArray.getSize(); i ++) {
                System.out.print(charArray.get(i) + " ");
            }
            charArray.remove(2);

            System.out.println("\u001B[33m\nGenerated Character Array after removing index 2 :\u001B[34m");
            for (int i = 0; i < charArray.getSize(); i ++) {
                System.out.print(charArray.get(i) + " ");
            }

            charArray.add(2, 'X');

            System.out.println("\u001B[33m\nGenerated Character Array after adding X in index 2 :\u001B[34m");
            for (int i = 0; i < charArray.getSize(); i ++) {
                System.out.print(charArray.get(i) + " ");
            }

            System.out.println("\n---------------------\n");

        myMeth();

    }
}