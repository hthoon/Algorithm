package baekjoon.java.stepbystep.S6;

import java.io.*;

public class Q3_N2444 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            int N = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();

            for (int i = N - 1; i >= 0; i--) {
                sb.append(" ".repeat(i));
                sb.append("*".repeat((N - i) * 2 - 1));
                sb.append("\n");
            }

            for (int i = 1; i < N; i++) {
                sb.append(" ".repeat(i));
                sb.append("*".repeat((N - i) * 2 - 1));
                sb.append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
