package baekjoon.java.stepbystep.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10_N2588 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());

        int mult1 = (num2 % 10);
        int mult2 = (num2 % 100) / 10;
        int mult3 = (num2 / 100);
        int result = num1 * num2;

        System.out.printf("%d\n%d\n%d\n%d", num1 * mult1, num1 * mult2, num1 * mult3, result);
    }
}
