package baekjoon.java.stepbystep.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9_N2908 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
            int B = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());

            System.out.println(A > B ? A : B);
        }
    }
}
