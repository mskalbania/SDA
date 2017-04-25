package com.sda;

public class Arrays2 {

    public static void main(String[] args) {

        int[] arr = new int[100];

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
