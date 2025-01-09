package baekjoon.java.stepbystep.S4;

import java.io.*;
import java.util.StringTokenizer;

public class Q6_N10813 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] basket = new int[N];

            for (int k = 0; k < N; k++) {
                basket[k] = k + 1;
            }

            int i, j;

            for (int k = 0; k < M; k++) {
                st = new StringTokenizer(br.readLine());

                i = Integer.parseInt(st.nextToken());
                j = Integer.parseInt(st.nextToken());

                swap(basket, i - 1, j - 1);
            }

            StringBuilder sb = new StringBuilder();

            for (int k = 0; k < basket.length; k++) {
                if (k == 0) {
                    sb.append(basket[k]);
                }
                else {
                    sb.append(String.format(" %d", basket[k]));
                }
            }

            System.out.println(sb);
        }
    }

    private static void swap(int[] array, int idx1, int idx2) {

        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }
}
