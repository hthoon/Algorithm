package baekjoon.java.stepbystep.S7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4_N2563 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int N = 100;
            int M = 100;
            int[][] paper = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    paper[i][j] = 0;
                }
            }

            int papers = Integer.parseInt(br.readLine());

            for (int i = 0; i < papers; i++) {
                String[] ex = br.readLine().split(" ");
                int x = Integer.parseInt(ex[0]);
                int y = Integer.parseInt(ex[1]);

                for (int a = x; a < x + 10; a++) {
                    if (a > 100) {
                        break;
                    }
                    for (int b = y; b < y + 10; b++) {
                        if (b > 100) {
                            break;
                        }
                        paper[a][b]++;
                    }
                }
            }

            int count = 0;

            for (int[] p : paper) {
                for (int i : p) {
                    if (i > 0) {
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
