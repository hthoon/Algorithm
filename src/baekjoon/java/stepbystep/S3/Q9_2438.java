package baekjoon.java.stepbystep.S3;

import java.io.*;

public class Q9_2438 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int T = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++) {
                for (int j = 0; j <= i; j++) {
                    bw.write("*");
                }
                bw.newLine();
            }
        }
    }
}