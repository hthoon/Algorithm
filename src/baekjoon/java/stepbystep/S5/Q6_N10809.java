package baekjoon.java.stepbystep.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q6_N10809 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String S = br.readLine();

            int[] alps = new int[26];
            Arrays.fill(alps, -1);

            int letter;

            for (int i = 0; i < S.length(); i++) {

                letter = S.charAt(i) - 97;

                if (alps[letter] == -1) {
                    alps[letter] = i;
                }
            }

            for (int q : alps) {
                System.out.printf("%d ", q);
            }
        }
    }
}
