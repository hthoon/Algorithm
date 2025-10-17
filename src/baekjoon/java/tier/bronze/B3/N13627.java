package baekjoon.java.tier.bronze.B3;

import java.io.*;
import java.util.StringTokenizer;

public class N13627 {
    /**
     * Dangerous Dive - 문자열 처리
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 1 <= R <= N <= 10^4
        int R = Integer.parseInt(st.nextToken());

        boolean[] survivors = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < R; i++) {
            survivors[Integer.parseInt(st.nextToken())] = true;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (!survivors[i]) {
                answer.append(i).append(" ");
            }
        }
        System.out.print(answer.length() == 0 ? "*" : answer);
    }
}
