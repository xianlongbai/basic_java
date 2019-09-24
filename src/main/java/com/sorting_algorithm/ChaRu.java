package com.sorting_algorithm;

import java.util.Arrays;

/**
 * Created by root on 2019/8/25.
 * 算法稳定性 -- 假设在数列中存在a[i]=a[j]，若在排序之前，a[i]在a[j]前面；并且排序之后，a[i]仍然在a[j]前面。则这个排序算法是稳定的
 *
 * 适合小规模数据或者基本有序的数据
 */
public class ChaRu {

    public static void insertSort(int[] arr){
        int j=0;
        int temp=0; //临时变量
        for(int i=1 ; i<arr.length ; i++ ){    //从第二数开始比较
            temp = arr[i];  //将当前数插入到已经有序的数组中
            for( j=i-1; j>=0; j--){
                if( arr[j] > temp ){   //如果前面的数大于当前数,将他后移
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = temp;    //将当前轮数的数放到应该在的位置
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args){
        int[] arr = {8,3,2,4};
        insertSort(arr);
    }

}
