package org.example;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

import static org.example.ThreadColor.*;

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
                System.out.println(ANSI_PURPLE + "Annotation String = " + ANSI_BLUE + anno.str() + ANSI_PURPLE + " , Method ID Number = " + ANSI_BLUE + anno.id());

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {

         CustomList<Integer> numberList = new CustomArrayList<>();

        for (int i=0; i<= 20; i++) {
            numberList.add(i);
            System.out.print(i + ANSI_YELLOW );
        }

            System.out.println();
        numberList.remove(4);

            System.out.println("--------------------- Number 4 removed from array" + ANSI_CYAN);

            for (int i=0; i< numberList.getSize(); i++) {

                System.out.println(i + ")" + numberList.get(i));
            }

            numberList.add(4, 4);

            System.out.println(ANSI_YELLOW + "--------------------- Number 4 added back to array" + ANSI_CYAN);

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


            System.out.println(ANSI_YELLOW + "\nGenerated Character Array:" + ANSI_BLUE);
            for (int i = 0; i < charArray.getSize(); i ++) {
                System.out.print(charArray.get(i) + " ");
            }
            charArray.remove(2);

            System.out.println(ANSI_YELLOW + "\nGenerated Character Array after removing index 2 :" + ANSI_BLUE);
            for (int i = 0; i < charArray.getSize(); i ++) {
                System.out.print(charArray.get(i) + " ");
            }

            charArray.add(2, 'X');

            System.out.println(ANSI_YELLOW + "\nGenerated Character Array after adding X in index 2 :" + ANSI_BLUE);
            for (int i = 0; i < charArray.getSize(); i ++) {
                System.out.print(charArray.get(i) + " ");
            }

            System.out.println("\n---------------------\n");

        myMeth();

    }
}