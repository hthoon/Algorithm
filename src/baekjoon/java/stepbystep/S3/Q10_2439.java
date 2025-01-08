package baekjoon.java.stepbystep.S3;

import java.io.*;

public class Q10_2439 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int T = Integer.parseInt(br.readLine());

            for (int i = 1; i <= T; i++) {
                StringBuilder sb = new StringBuilder();

                sb.append("*".repeat(i));

                bw.write(String.format("%" + T + "s", sb));

                if (i != T) {
                    bw.newLine();
                }
            }
        }
    }
}