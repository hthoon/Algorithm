package baekjoon.java.stepbystep.S4;

import java.io.*;
import java.util.StringTokenizer;

public class Q2_N10871 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            StringBuilder sb = new StringBuilder();
            boolean isFirst = true;

            for (int num : A) {
                if (num < X && isFirst) {
                    sb.append(num);
                    isFirst = false;
                }
                else if (num < X) {
                    sb.append(" ").append(num);
                }
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }
}
