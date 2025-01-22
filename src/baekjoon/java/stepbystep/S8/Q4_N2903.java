package baekjoon.java.stepbystep.S8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4_N2903 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());

            int squareVal = square(2, N) + 1;

            System.out.println(squareVal * squareVal);
        }
    }

    private static int square(int n, int time) {
        if (time == 0) {
            return 1;
        }
        return n * square(n, time - 1);
    }
}
