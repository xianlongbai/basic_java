package com.sorting_algorithm;

import java.util.Arrays;

/**
 * Created by root on 2019/8/25.
 * 希尔排序：先按步调分组,在插排
 */
public class XiEr {

    public static void main(String[] args){
        int[] ins = {2,3,5,1,23,6,78,34,23,4,5,78,34,65,32,65,76,32,76,1,9};
        int[] ins2 = sort(ins);
        int[] ins3 = shellSort(ins);
        System.out.println(Arrays.toString(ins2));
        System.out.println(Arrays.toString(ins3));
    }

    public static int[] sort(int[] ins){

        int n = ins.length;
        int gap = n/2;
        while(gap > 0){
            for(int j = gap; j < n; j++){
                int i=j;
                while(i >= gap && ins[i-gap] > ins[i]){
                    int temp = ins[i-gap]+ins[i];
                    ins[i-gap] = temp-ins[i-gap];
                    ins[i] = temp-ins[i-gap];
                    i -= gap;
                }
            }
            gap = gap/2;
        }
        return ins;
    }


    //好理解

    private static int[] shellSort(int[] a){
        int n=a.length;
        int gap=n/2;
        while(gap>=1){
            for(int i=gap;i<a.length;i++){
                int j=0;
                int temp = a[i];
                for(j=i-gap;j>=0 && temp<a[j];j=j-gap){
                    a[j+gap] = a[j];
                }
                a[j+gap] = temp;
            }
            gap = gap/2;
        }
        return a;
    }


}
