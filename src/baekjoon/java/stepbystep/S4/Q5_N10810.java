package baekjoon.java.stepbystep.S4;

import java.io.*;
import java.util.StringTokenizer;

public class Q5_N10810 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] basket = new int[N];

            int start, end, balls;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                start = Integer.parseInt(st.nextToken());
                end = Integer.parseInt(st.nextToken());
                balls = Integer.parseInt(st.nextToken());

                for (int j = start - 1; j < end; j++) {
                    basket[j] = balls;
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < basket.length; i++) {
                if (i == 0) {
                    sb.append(basket[i]);
                }
                else {
                    sb.append(String.format(" %d", basket[i]));
                }
            }

            System.out.println(sb);
        }
    }
}
