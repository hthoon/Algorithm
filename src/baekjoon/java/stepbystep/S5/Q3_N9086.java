package baekjoon.java.stepbystep.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3_N9086 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int T = Integer.parseInt(br.readLine());

            String word;
            char start, end;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < T; i++) {

                word = br.readLine();

                start = word.charAt(0);
                end = word.charAt(word.length() - 1);

                sb.append(start).append(end).append("\n");
            }

            System.out.println(sb);
        }
    }
}
