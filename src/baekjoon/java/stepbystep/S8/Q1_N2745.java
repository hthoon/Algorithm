package baekjoon.java.stepbystep.S8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Todo: 다시 공부
public class Q1_N2745 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] S = br.readLine().split(" ");

            String N = S[0];
            int B = Integer.parseInt(S[1]);

            int result = 0;

            for (int i = N.length() - 1; i >= 0; i--) {
                char c = N.charAt(i);

                int conVal = toNum(c);

                int power = N.length() - 1 - i;

                result += conVal * mul(B, power);
            }

            System.out.println(result);
        }
    }

    private static int mul(int n, int time) {
        if (time == 0) {
            return 1;
        }
        return n * mul(n, time - 1);
    }

    // Character 타입 다루기
    private static int toNum(char c) {
        if (Character.isDigit(c)) {
            return c - '0';
        }
        else {
            return c - 'A' + 10;
            //return c - 39;
        }
    }
}
