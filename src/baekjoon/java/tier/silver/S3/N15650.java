package baekjoon.java.tier.silver.S3;

import java.io.*;
import java.util.StringTokenizer;

public class N15650 {
    /**
     * N과 M (2) = DFS, 백트래킹
     */
    static int N, M;
    static StringBuilder answer = new StringBuilder();
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수열을 만들 수의 범위
        M = Integer.parseInt(st.nextToken()); // 수열의 길이

        memo = new int[M];

        backtrack(1, 0);

        System.out.print(answer);
    }

    // 중복 없이 오름차순으로 뽑기: 나보다 큰 수만 뽑으면 된다. 따라서 visited 배열이 불필요.
    private static void backtrack(int start, int depth) {
        // 깊이 도달 시 수열 작성
        if (depth == M) {
            for (int num : memo) {
                answer.append(num).append(" ");
            }
            answer.append("\n");
            return;
        }

        // 다음 탐색점 선택. start는 이전의 num보다 1이 크므로, 오름차순 정렬과 중복 방지를 동시에 해결할 수 있음.
        for (int num = start; num <= N; num++) {
            memo[depth] = num;
            backtrack(num + 1, depth + 1); // 다음 탐색은 더 큰 수부터 시작한다.
        }
    }
}
