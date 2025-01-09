package baekjoon.java.stepbystep.S4;

import java.io.*;
import java.util.StringTokenizer;

public class Q3_N10818 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            int min = A[0];
            int max = A[0];

            for (int num : A) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }

            bw.write(String.format("%d %d", min, max));
            bw.flush();
        }
    }
}
