package baekjoon.java.stepbystep.S7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2_N2566 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int N = 9;
            int M = 9;

            int[][] arr = new int[N][M];

            for (int i = 0; i < N; i++) {
                String[] row = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(row[j]);
                }
            }

            int max = arr[0][0];
            int idxR = 0;
            int idxC = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] > max) {
                        max = arr[i][j];
                        idxR = i;
                        idxC = j;
                    }
                }
            }

            System.out.printf("%d\n%d %d", max, idxR + 1, idxC + 1);
        }
    }
}
