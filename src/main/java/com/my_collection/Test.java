package com.my_collection;

import java.util.*;

/**
 * Created by root on 2019/4/13.
 */
public class Test {

    public static void main(String[] args){

        //Collection c = new HashMap<String,String>();
        //Set set = new HashSet();
//        LinkedHashMap linkedHashMap = new LinkedHashMap();
//        linkedHashMap.put(1,"aaa");
//        linkedHashMap.put(2,"bbb");
//        linkedHashMap.put(3,"ccc");
//        linkedHashMap.put(4,"ddd");
//
//        System.out.println(linkedHashMap);

        Set set = new LinkedHashSet();
        set.add(111);
        set.add(112);
        set.add(113);
        for (Object o : set) {
            System.out.println(o);
        }



    }
}
