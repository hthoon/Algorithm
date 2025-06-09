package baekjoon.java.silver_9528;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10870 {

    public static void main(String[] args) throws IOException {
        /**
         * 피보나치 수 5
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // X3 = X1 + X2
        // th = 2 -> 0 + 1 = 1
        // th = 3 -> 1 + 1 = 2
        // th = 4 -> 1 + 2 = 3

        int N = Integer.parseInt(br.readLine());

        // N이 0 또는 1인 경우 -> 바로 출력
        if (N <= 1) {
            System.out.println(N);
            return;
        }

        // N이 2 이상인 경우
        // 첫 번째 수로 미리 초기화
        int result = 1;
        int th = 2;

        int a = 0;
        int b = 1;

        while (th <= N) {
            result = a + b;

            a = b;
            b = result;

            th++;
        }
        System.out.println(result);
    }
}
