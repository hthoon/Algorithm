package baekjoon.java.silver_9528;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2798 {
    /**
    * 블랙잭 - 브루트 포스
    * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int M = 5;  // 카드의 수
//        int N = 21; // 목표 합
//        int[] cards = {5, 6, 7, 8, 9};

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 카드의 수
        int N = Integer.parseInt(st.nextToken()); // 목표 합

        st = new StringTokenizer(br.readLine());
        int[] cards = new int[M];
        for (int i = 0; i < M; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 0; i < M - 2; i++) {
            for (int j = i + 1; j < M - 1; j++) {
                // 첫 번째, 두 번째 카드 합 미리 누적
                int sum = cards[i] + cards[j];

                for (int k = j + 1; k < M; k++) {
                    // 세 번째 카드 누적
                    int sum2 = sum + cards[k];

                    // 조건 충족 시 해 갱신
                    // 1. 합이 N보다 작음
                    // 2. 합이 이전에 저장된 해보다 큼
                    if (sum2 <= N && sum2 > result) {
                        result = sum2;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
