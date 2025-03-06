package baekjoon.java.stepbystep.S8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2_N11005 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            StringBuilder sb = new StringBuilder();

            while (N > 0) {
                sb.append(toAlp(N % B));
                N /= B;
            }

            System.out.println(sb.reverse());
        }
    }

    private static char toAlp(int i) {

        char[] digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        return digits[i];
    }
}