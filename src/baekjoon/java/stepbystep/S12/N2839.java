package baekjoon.java.stepbystep.S12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2839 {
    /**
     * 설탕 배달
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /* 더 적은 개수의 봉지 배달하기 */
        for (int i = N / 5; i >= 0; i--) {
            int remain = N - i * 5;

            /* 나누어 떨어지면 결과 출력
            * 최소 봉지 수부터 시작하기 때문에 더 검사할 필요 없음.
            * */
            if (remain % 3 == 0) {
                System.out.println(i + remain / 3); // 3kg + 5kg
                return;
            }
        }
        System.out.println(-1);
    }
}
