package baekjoon.java.stepbystep.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6_N10869 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        System.out.printf("%d\n%d\n%d\n%d\n%d", num1 + num2, num1 - num2, num1 * num2, num1 / num2, num1 % num2);
    }
}
