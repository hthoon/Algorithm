package baekjoon.java.stepbystep.S6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Q7_N1316 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            int N = Integer.parseInt(br.readLine());
            int count = 0;

            for (int i = 0; i < N; i++) {

                String S = br.readLine();
                if (isGroupWord(S)) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    private static boolean isGroupWord(String S) {

        HashSet<Character> seen = new HashSet<>();

        char prev = '\0';

        for (char c : S.toCharArray()) {

            if (c != prev) {

                if (seen.contains(c)) {
                    return false;
                }

                seen.add(c);
            }

            prev = c;
        }

        return true;
    }
}
