package baekjoon.java.stepbystep.S9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4_N1978 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 소수 숫자 카운팅
        int count = 0;

        for (int i = 0; i < N; i++) {

            int n = Integer.parseInt(st.nextToken());

            /* 소수 찾기 시작 */

            // n = 1이면 패스
            if (n == 1) {
                continue;
            }

            boolean isPrime = true;

            // n의 루트값 이하까지만 검사해도 된다 한다.
            // 약수가 하나라도 더 있으면 false 할당 후 조건문 멈추기
            for (int j = 2; j <= Math.sqrt(n); j++) {
                if (n % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            // isPrime이 true를 유지하면 count 증가
            if (isPrime) {
                count++;
            }

            /* 소수 찾기 끝 */
        }
        System.out.println(count);
    }
}
