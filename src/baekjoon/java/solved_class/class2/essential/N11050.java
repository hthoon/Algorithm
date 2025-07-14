package baekjoon.java.solved_class.class2.essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11050 {
    /**
     * 이항 계수 1
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        /* n! / (n - k)! * k! */
        int result = factorial(N) / (factorial(N - K) * factorial(K));

        System.out.println(result);
    }

    private static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
}