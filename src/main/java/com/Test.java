package com;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(4);
        list.add(888);
        list.add(5);
        list.add(777);
        System.out.println(list.get(3));

    }

}
