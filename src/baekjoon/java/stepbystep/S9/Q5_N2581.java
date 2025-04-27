package baekjoon.java.stepbystep.S9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5_N2581 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        // 소수의 최솟값, 합계를 구해야 한다.
        int sum = 0;
        int min = 0;

        // 탐색 범위는 M 이상 N 이하다.
        for (int i = M; i <= N; i++) {

            // 1이면 패스
            if (i == 1) {
                continue;
            }

            // 소수 찾기
            boolean isPrime = true;
            int range = (int) Math.sqrt(i);

            for (int j = 2; j <= range; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            // 소수인데 저장된 최솟값이 없는 경우
            if (isPrime && min == 0) {
                sum += i;
                min = i;
            }
            // 소수인데 저장된 최솟값이 있는 경우
            else if (isPrime) {
                sum += i;
            }
        }

        // 소수가 없다 -> sum이 0
        if (sum == 0) {
            System.out.println(-1);
        }
        else {
            System.out.printf("%d\n%d", sum, min);
        }
    }
}
