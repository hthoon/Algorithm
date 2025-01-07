package baekjoon.java.stepbystep.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4_25304 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int a, b;
        int total = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            total += a * b;
        }

        if (X == total) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
