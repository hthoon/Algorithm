package baekjoon.java.stepbystep.S3;

import java.io.*;
import java.util.StringTokenizer;

public class Q11_10952 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringBuilder sb = new StringBuilder();

            int A, B;
            boolean ifFirst = true;

            for (;;) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                A = Integer.parseInt(st.nextToken());
                B = Integer.parseInt(st.nextToken());

                if (A == 0 && B == 0) {
                    break;
                }

                if (ifFirst) {
                    sb.append(A + B);
                    ifFirst = false;
                    continue;
                }

                sb.append("\n").append(A + B);
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }
}