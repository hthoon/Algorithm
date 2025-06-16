package baekjoon.java.solved_class.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N8958 {
    /**
     * OX퀴즈
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int score = 0;
            int result = 0;

            char[] test = br.readLine().toCharArray();

            for (char answer : test) {
                /* 'O'이면 배점 증가 후 누적 */
                if (answer == 'O') {
                    score++;
                }
                /* 'X'면 배점 초기화 */
                else {
                    score = 0;
                }
                result += score;
            }
            System.out.println(result);
        }
    }
}
