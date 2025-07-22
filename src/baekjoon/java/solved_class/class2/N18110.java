package baekjoon.java.solved_class.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N18110 {
    /**
     * solved.ac
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        /* 점수는 1 ~ 30 */
        int[] scores = new int[31];
        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(br.readLine());
            scores[score]++;
        }

        /* 절사평균 범위 설정 */
        int outRange = (int) Math.round(n * 0.15);     // 절사평균 집계 제외 인원 범위
        int inRange = n - 2 * outRange;                // 절사평균 집계 해당 인원 범위

        /* 점수 1 ~ 30 순회하며 누적 */
        int sumOfScores = 0;
        int outRangeCount = outRange;                  // 제외 인원 카운팅

        for (int i = 1; i <= 30; i++) {
            while (scores[i]-- > 0) {
                /* 절사평균 해당 인원 */
                if (outRangeCount > 0) {
                    outRangeCount--;
                }
                /* 절사평균 제외 인원 */
                else if (inRange > 0) {
                    sumOfScores += i;
                    inRange--;
                }
                else {
                    break;
                }
            }
        }
        /* 절사평균 해당 인원 수로 평균 계산
        * 주의: 미리 double 타입으로 캐스팅하여 소숫점 소실 방지
        * */
        System.out.print(Math.round((double) sumOfScores / (n - 2 * outRange)));
    }
}
