package baekjoon.java.stepbystep.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q7_N2480 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int result;

        if (A == B && B == C) {
            result = 10000 + A * 1000;
        }
        else  if (A == B || C == A) {
            result = 1000 + A * 100;
        }
        else if (B == C) {
            result = 1000 + C * 100;
        }
        else {
            result = max(A, B, C) * 100;
        }

        System.out.println(result);
    }

    private static int max(int a, int b, int c) {

        int result = a;

        if (result < b) {
            result = b;
        }
        if (result < c) {
            result = c;
        }

        return result;
    }
}
