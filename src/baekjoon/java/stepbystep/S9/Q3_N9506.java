package baekjoon.java.stepbystep.S9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3_N9506 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* 로직 */
        int n;

        // 입력이 -1이 주어질 때까지 반복한다.
        while ((n = Integer.parseInt(br.readLine())) != -1) {

            // 모든 약수를 구해야 한다.
            // 모든 양의 정수는 1을 약수를 가지므로, 미리 누적한다.
            int sum = 1;

            // 출력값을 만든다. 등호 뒷부분을 미리 만든다.
            StringBuilder result = new StringBuilder();
            result.append(1);

            // 약수면 sum에 누적한다.
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    sum += i;
                    result.append(" + ").append(i);
                }
            }

            // 완전수인 경우, "n = " 문자열을 앞에 붙인다.
            if (sum == n) {
                System.out.printf("%d = %s\n", n, result);

            // 완전수가 아닌 경우의 출력
            } else {
                System.out.printf("%d is NOT perfect.\n", n);
            }

            /* 로직 끝 */
        }
    }
}
