package baekjoon.java.solved_class.class3.essential;

import java.io.*;

public class N1003 {
    /**
     * 피보나치 함수 - DP(Memoization)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 1 <= N <= 40

        /*
        int fibonacci(int n) {
            if (n == 0) {
                printf("0");
                return 0;
            } else if (n == 1) {
                printf("1");
                return 1;
            } else {
                return fibonacci(n‐1) + fibonacci(n‐2);
            }
        }
        */

        /* DP 배열 생성
        입력값 범위: 1 <= T <= 40
        [i][0] - i에서의 0 호출 횟수
        [i][1] - i에서의 1 호출 횟수

        (3) -> (*2), (*1)
        (*2) -> (1), (0) -> 1 리턴, 0 리턴
        (*1) -> 1 리턴
        --> 1: 2, 0: 1
        */
        int[][] countArr = new int[41][2];
        countArr[0][0] = 1;
        countArr[0][1] = 0;

        countArr[1][0] = 0;
        countArr[1][1] = 1;

        /* DP 배열도 피보나치 수열 형성 원리대로 생성한다. */
        for (int i = 2; i < 41; i++) {
            countArr[i][0] = countArr[i - 1][0] + countArr[i - 2][0];
            countArr[i][1] = countArr[i - 1][1] + countArr[i - 2][1];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(countArr[N][0] + " " + countArr[N][1]);
            bw.newLine();
        }
        bw.flush();
    }
}
