package baekjoon.java.stepbystep.S8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3_N2720 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int T = Integer.parseInt(br.readLine());

            int Q, D, N, P;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < T; i++) {
                int C = Integer.parseInt(br.readLine());

                Q = C / 25;
                C %= 25;

                D = C / 10;
                C %= 10;

                N = C / 5;
                C %= 5;

                P = C;

                sb.append(Q).append(" ").append(D).append(" ").append(N).append(" ").append(P).append("\n");
            }

            System.out.println(sb);
        }
    }
}
