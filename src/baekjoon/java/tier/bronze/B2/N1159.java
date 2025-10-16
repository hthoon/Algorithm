package baekjoon.java.tier.bronze.B2;

import java.io.*;

public class N1159 {
    /**
     * 농구 경기 - 아스키
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 선수의 수
        int[] alps = new int[26];
        for (int i = 0; i < N; i++) {
            char first = br.readLine().charAt(0);
            alps[first - 97]++;
        }

        // 카운팅 배열 순회하며 결과 쓰기
        boolean flag = false;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (alps[i] >= 5) {
                answer.append((char) (i + 97));
                flag = true;
            }
        }

        // flag에 따라 결과 출력
        if (flag) {
            System.out.print(answer);
        }
        else {
            System.out.print("PREDAJA");
        }
    }
}
