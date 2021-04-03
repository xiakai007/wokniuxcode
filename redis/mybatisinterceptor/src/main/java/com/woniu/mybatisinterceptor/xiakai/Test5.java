package com.woniu.mybatisinterceptor.xiakai;

import java.util.Arrays;

public class Test5 {
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] a=new int[k];

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println("arr:"+Arrays.toString(arr));
        for(int n=0;n<k;n++){
            a[n]=arr[n];
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr={7,8,9,5,1,15,4,3};
        int k=3;
        int[] leastNumbers = getLeastNumbers(arr,k);
        System.out.println(Arrays.toString(leastNumbers));
    }
}
