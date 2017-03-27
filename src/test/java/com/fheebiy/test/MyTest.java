package com.fheebiy.test;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by bob zhou on 14-5-4.
 */
public class MyTest {

    @Value("#{settings['kestrel.server.host']}")
    static String server;

    @Value("${kestrel.connectionPoolSize}")
    static int poolSize;

    @Value("${kestrel.ConnectTimeout}")
    static int timeout;

    public void giveSomething() {
        System.out.println("zhouwenbo");
        String[] args = new String[]{"a", "b", "c", "d"};
        for (String s : args) {
            System.out.println(s);
        }

        int[] array = new int[]{2, 34, 23, 12, 7, 9};
        int x = getMinInt(array);
        System.out.println(x);
    }


    public void operateInt() {
        for (int i = 0; i < 100; i++) {
            if (i % 7 == 0) {
                System.out.println(i);
            }
        }

    }

    public void operString() {
        double[] array = {12, 13, 18, 11, 22, 19};
        System.out.println(getScore(array));
    }


    public int getMinInt(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }


    public void valueTest() {
       String s = "eee";
       boolean is = StringUtils.isNumeric(s);
       System.out.print(is);

    }

    public void main(String[] args) {
        try {
            System.out.println("please input heght:");
            Scanner s = new Scanner(System.in);
            String heightStr = s.next();

            System.out.println("please input di:");
            Scanner s1 = new Scanner(System.in);
            String aStr = s1.next();

            double height = Double.parseDouble(heightStr);
            double a = Double.parseDouble(aStr);
            double area = getArea(height, a);
            System.out.println(area);

        } catch (Exception e) {

        }

    }

    public static double getArea(double height, double a) {
        return height * a / 2;
    }


    public double getScore(double[] array) {
        double max = array[0];
        double min = array[0];
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
            sum += array[i];
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        double score = (sum - max - min) / (array.length - 2);
        return score;
    }

    @org.junit.Test
    public void timeTest() {
        List list = new LinkedList<Integer>();
        for (int i = 0; i < 800000; i++) {
            list.add(i);
        }

        Iterator<Integer> iterator = list.iterator();
        long t1 = System.currentTimeMillis();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }

        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

}
