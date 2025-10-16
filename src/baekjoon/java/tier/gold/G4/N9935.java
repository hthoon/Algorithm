package baekjoon.java.tier.gold.G4;

import java.io.*;

public class N9935 {
    /**
     * 문자열 폭발 - 문자열 처리, 끝부분 검사, 스택
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder text = new StringBuilder(br.readLine());
        String bomb = br.readLine();

        StringBuilder answer = new StringBuilder();
        int bombLen = bomb.length();                // 재사용 변수
        for (int i = 0; i < text.length(); i++) {
            answer.append(text.charAt(i));

            // 폭탄 처리
            if (answer.length() >= bombLen) {
                boolean trigger = true;

                // 끝부분 비교
                for (int j = 0; j < bombLen; j++) {
                    char cText = answer.charAt(answer.length() - j - 1);
                    char cBomb = bomb.charAt(bombLen - j - 1);

                    if (cBomb != cText) {
                        trigger = false;
                        break;
                    }
                }

                // 끝부분이 bomb와 일치하면 삭제
                if (trigger) {
                    answer.delete(answer.length() - bombLen, answer.length());
                }
            }
        }
        System.out.print(answer.length() == 0 ? "FRULA" : answer);
    }
}
