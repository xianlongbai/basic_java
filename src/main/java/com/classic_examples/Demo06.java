package com.classic_examples;

/**
 * Created by root on 2019/11/6.
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""
 */
public class Demo06 {

    //myself
    public static String longestCommonPrefix(String[] strs) {
        if (strs==null||strs.length==0) return "";
        String min = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length()<min.length()){
                min = strs[i];
            }
        }
        String res = "";
        int index = 0;
        OUT:
        for (int i = 0; i < min.length(); i++) {
            char stat = strs[0].charAt(index);
            for (int y = 1; y < strs.length; y++) {
                if (strs[y].charAt(i)!=stat){
                    break OUT;
                }
            }
            index++;
            res += stat;
        }
        return res;
    }

    //myself---two
    public static String longestCommonPrefixTwo(String[] strs) {
        if (strs==null||strs.length==0) return "";
        String res = "";
        OUT:
        for (int i = 0; i < strs[0].length(); i++) {
            char stat = strs[0].charAt(i);
            for (int y = 1; y < strs.length; y++) {
                if (strs[y].length()<i+1 || strs[y].charAt(i)!=stat){
                    break OUT;
                }
            }
            res += stat;
        }
        return res;
    }


    //经典:水平扫描法,优化：分治
    public static String longestCommonPrefixThree(String[] strs) {
        if (strs==null||strs.length==0) return "";
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }



    public static void main(String[] args){
        String[] strs = {"aac"};
        System.out.println(longestCommonPrefixTwo(strs));
    }


}
