package baekjoon.java.solved_class.class3.essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1463 {
    /**
     * 1로 만들기
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /* 힌트: 10 -> 9 -> 3 -> 1
        * 힌트에 매몰돼서 망했음.
        * */

        /* 인덱스 예외 해결 */
        if (N == 1) {
            System.out.print(0);
            return;
        }

        /* DP 배열 만들기 (1 <= N) */
        int[] minNodes = new int[N + 1];
        minNodes[1] = 0;
        minNodes[2] = 1;

        /* 골자: 이전 결과를 활용한 bottom-up 방식 */
        for (int i = 3; i <= N; i++) {
            /* -1 연산은 항상 가능하므로, 미리 연산하여 비교 대상으로 사용 */
            minNodes[i] = minNodes[i - 1] + 1;

            /* 2의 배수인 경우, i / 2번째 값에 1만 더하면 된다. */
            if (i % 2 == 0) {
                minNodes[i] = Math.min(minNodes[i], minNodes[i / 2] + 1);
            }

            /* 포인트: 6의 배수일 수 있다. 따라서 하나의 else-if 구문으로 판별하지 않는다. */
            if (i % 3 == 0) {
                minNodes[i] = Math.min(minNodes[i], minNodes[i / 3] + 1);
            }
        }
        System.out.print(minNodes[N]);
    }
}
