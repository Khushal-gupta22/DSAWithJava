package com.company;

public class Swap {
    public static void main(String[] args) {
        int[] arr = {1 ,2, 32, 45, 69};
        swap(arr, 1 ,4);
    }
    static void swap(int[] arr , int index1 , int index2){
        int temp =arr[index1];
        arr[index1]= arr[index2];
        arr[index2]=temp ;
    }
    static void reverse(int[] arr){
        int start = 0;
        int end= arr.length -1 ;

        while (start <end){
            //swap
            swap(arr ,start ,end);
            start++;
            end--;
        }
    }

}
