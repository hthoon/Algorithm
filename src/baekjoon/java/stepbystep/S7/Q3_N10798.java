package baekjoon.java.stepbystep.S7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3_N10798 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int N = 5;
            String[] rows = new String[N];

            int maxSize = 0;

            for (int i = 0; i < N; i++) {
                rows[i] = br.readLine();
                if (rows[i].length() > maxSize) {
                    maxSize = rows[i].length();
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < maxSize; i++) {
                for (int j = 0; j < N; j++) {
                    if (rows[j].length() <= i) {
                        continue;
                    }

                    char c = rows[j].charAt(i);
                    sb.append(c);
                }
            }

            System.out.println(sb);
        }
    }
}
