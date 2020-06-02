package com.classic_examples;

/**
 * Created by root on 2019/11/5.
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1
 *
 * 理解KMP算法  *****
 */
public class Demo04 {

    public static int strStr(String haystack, String needle) {
        int index = -1;
        if (haystack==null || needle==null) return index;
        if ("".equals(needle)) {
            index = 0;
        } else {
            char first = needle.charAt(0);
            for (int i = 0; i < haystack.length(); i++) {
                if (haystack.charAt(i)==first) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    public static int strStr2(String haystack, String needle) {
        int index = -1;
        if (haystack==null || needle==null) return index;
        if ("".equals(needle)) {
            index = 0;
        } else {
            if (haystack.contains(needle)){
                index = haystack.indexOf(needle);
            }
        }
        return index;
    }


    public static void main(String[] args){
        System.out.println(strStr2("baaaaaa","aaaa"));
    }

}
