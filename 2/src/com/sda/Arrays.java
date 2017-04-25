package com.sda;

public class Arrays {

    private final static int x = 7;
    private final static int y = 7;
    private final static int z = 7;

    public static void main(String[] args) {

        int[][][] arr = new int[x][y][z];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    arr[x][y][z] = i + j + k;
                }
            }
        }

        for (int[][] i : arr) {

            for (int[] j : i) {

                for (int k : j) {
                    System.out.println(k);
                }
                System.out.println();
            }
            System.out.println();

        }

    }
}
