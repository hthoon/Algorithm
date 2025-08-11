package baekjoon.java.solved_class.class3.essential;

import java.io.*;

public class N11727 {
    /**
     * 2xn 타일링 2 - DP의 DP
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 1 <= n <= 1000

        /* |, =, ||, □

        * n = 1 -> | => 1가지
        * n = 2 -> □, || => 3가지
        * n = 3 -> |□, □|, ||| => 5가지
        * n = 4 -> ||□, □||, |□|, □□, |||| => 11가지
        * n = 5 -> |||□, ||□|, |□||, □|||, |□□, □|□, □□| => 21가지
        *
        * (n - 2)에서 □ 블록 하나 추가 + (n - 1)에서 | 블록 하나 추가
        * 단, □ 블록은 일체형, 가로 결합형 2가지이므로 2를 곱해준다.
        * if (n >= 3), case(n) = case(n - 2) * 2 + case(n - 1)
        * */

        /* n 범위에 맞춰 DP 배열 생성 */
        long[] cases = new long[n + 1];

        /* early return */
        if (n <= 2) {
            System.out.print(n == 2 ? 3 : 1);
            return;
        }
        /* 점화식으로 배열 채우기 */
        else {
            cases[1] = 1;
            cases[2] = 3;
            for (int i = 3; i <= n; i++) {
                /* 10007 mod 연산 */
                cases[i] = (cases[i - 2] * 2 + cases[i - 1]) % 10007;
            }
        }
        System.out.print(cases[n]);
    }
}
