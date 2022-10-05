package com.interview;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ResourceBundle;

public class Addition {
    final static Integer num;
    final Integer number;

    static {
        num = 45;
    }

    public Addition() {
        number = 20;
    }

    public Addition(int x) {
        this();
    }

    public int add(int x, int y) {
        ResourceBundle bundle = ResourceBundle.getBundle("Locale.UK");
        Queue<Integer> PQ= new PriorityQueue<>();
        return x+y;
    }

    public int add(int x, int y, int z) {
        return x+y+z;
    }

    public static void main(String[] args) {
        Addition addition = new Addition();
    }

}
