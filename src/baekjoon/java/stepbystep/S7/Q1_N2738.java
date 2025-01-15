package baekjoon.java.stepbystep.S7;

import java.io.*;

public class Q1_N2738 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String S = br.readLine();

            int N = Integer.parseInt(S.split(" ")[0]);
            int M = Integer.parseInt(S.split(" ")[1]);

            int[][] arr1 = new int[N][M];
            int[][] arr2 = new int[N][M];

            // 각 배열에 값 대입
            for (int i = 0; i < N; i++) {
                String[] row = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    arr1[i][j] = Integer.parseInt(row[j]);
                }
            }

            for (int i = 0; i < N; i++) {
                String[] row = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    arr2[i][j] = Integer.parseInt(row[j]);
                }
            }

            // 덧셈 연산
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.printf("%d ", arr1[i][j] + arr2[i][j]);
                }
                System.out.print("\n");
            }
        }
    }
}
