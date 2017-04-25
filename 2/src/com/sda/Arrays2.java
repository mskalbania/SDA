package com.sda;
/*
Simple algorithm counting average of first n numbers including 0
 */

public class Arrays2 {

    private static final int sizeOfArray = 100; //( n numbers )

    public static void main(String[] args) {

        int[] arr = new int[sizeOfArray];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        double average = countAverage(arr);

        System.out.println("Av = " + average);

        //  showArray(arr);

    }

    public static double countAverage(int[] arr) {

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return (double) (sum) / (double) (arr.length);
    }

    public static void showArray(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
