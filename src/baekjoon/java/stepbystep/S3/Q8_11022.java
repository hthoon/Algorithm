package baekjoon.java.stepbystep.S3;

import java.io.*;
import java.util.StringTokenizer;

public class Q8_11022 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int T = Integer.parseInt(br.readLine());

            for (int i = 1; i <= T; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                bw.write(String.format("Case #%d: %d + %d = %d\n", i, A, B, (A + B)));
            }
        }
    }
}
