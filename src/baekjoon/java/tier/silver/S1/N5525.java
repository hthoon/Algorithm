package baekjoon.java.tier.silver.S1;

import java.io.*;

public class N5525 {
    /**
     * IOIOI - 문자열 처리, 그리디
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 1      <= N <= 1000000
        int M = Integer.parseInt(br.readLine()); // 2N + 1 <= M <= 1000000
        String S = br.readLine();

        /*
        Pn = I와 O가 교대로 이루어진 문자열. n은 O의 수
        P1 = IOI
        P2 = IOIOI
        */

        int answer = 0;
        int count = 0;

        for (int i = 1; i < M - 1; i++) {
            char letterA = S.charAt(i - 1);
            char letterB = S.charAt(i);
            char letterC = S.charAt(i + 1);

            // pi 배열 판단
            // i 증가 처리로 효율성 향상 (2 step)
            if (letterA == 'I' && letterB == 'O' && letterC == 'I') {
                count++;
                i++;
            }
            // pi 배열이 아닐 경우 처리
            else {
                count = 0;
            }

            // Pn 카운팅
            // 겹치는 경우를 대비해 count 감소 처리
            // 초기화는 위의 else 문에서 해결
            if (count == N) {
                answer++;
                count--;
            }
        }
        System.out.print(answer);
    }
}
