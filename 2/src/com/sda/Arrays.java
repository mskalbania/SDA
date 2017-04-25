package com.sda;

public class Arrays {

    private final static int rows = 5;
    private final static int columns = 5;

    public static void main(String[] args) {

        int[][] arr = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = i + j;
            }
        }

        for (int[] i : arr) {

            for (int j : i) {
                System.out.print(j + " ");
            }

            System.out.println("");

        }

    }
}
