package baekjoon.java.solved_class.class3.essential;

import java.io.*;

public class N11726 {
    /**
     * 2xn 타일링
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 1 <= n <= 1000

        /*
        * n = 1 -> |
        * => 1가지
        * n = 2 -> ||, =
        * => 2가지
        * n = 3 -> =|, |=, |||
        * => 3가지
        * n = 4 -> ==, ||||, ||=, |=|, =||
        * => 5가지
        * n = 5 -> |||||, |||=, ||=|, |=||, =|||, |==, =|=, ==|
        * => 8가지
        *
        * (n - 2)에서 = 블록 하나 추가하는 경우 + (n - 1)에서 |블록 하나 추가하는 경우
        * if (n >= 3), case(n) = case(n - 2) + case(n - 1)
        *  */

        /* n 범위에 맞춰 DP 배열 생성 */
        long[] cases = new long[n + 1];
        cases[1] = 1;

        if (n >= 2) {
            cases[2] = 2;

            for (int i = 3; i <= n; i++) {
                /* 10007 mod 연산 */
                cases[i] = (cases[i - 2] + cases[i - 1]) % 10007;
            }
        }
        System.out.print(cases[n]);
    }
}
