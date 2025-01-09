package baekjoon.java.stepbystep.S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9_N10811 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] baskets = new int[N];

            for (int x = 0; x < N; x++) {
                baskets[x] = x + 1;
            }

            int i, j;

            for (int x = 0; x < M; x++) {
                st = new StringTokenizer(br.readLine());

                i = Integer.parseInt(st.nextToken()) - 1;
                j = Integer.parseInt(st.nextToken()) - 1;

                while (i < j) {
                    swap(baskets, i, j);
                    i++;
                    j--;
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int basket : baskets) {
                sb.append(String.format("%d ", baskets[basket]));
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
