package com.sorting_algorithm;

/**
 * Created by root on 2019/8/25.
 */
public class MaoPao {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 5, 10, 7};
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
