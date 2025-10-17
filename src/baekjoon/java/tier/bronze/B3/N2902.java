package baekjoon.java.tier.bronze.B3;

import java.io.*;

public class N2902 {
    /**
     * KMP는 왜 KMP일까? - 문자열 처리
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();

        // A: 65
        String[] words = text.split("-");

        StringBuilder answer = new StringBuilder();
        for (String word : words) {
            answer.append(word.charAt(0));
        }
        System.out.print(answer);
    }
}
