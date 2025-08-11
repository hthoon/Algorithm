package baekjoon.java.solved_class.class3.essential;

import java.io.*;
import java.util.StringTokenizer;

public class N11659 {
    /**
     * 구간 합 구하기 4
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /*
        * 정직하게 누적합을 구하면 시간 초과
        * -> 누적합 DP 배열 -> 누적합[끝점] - 누적합[시작점] = 구간합
        * */
        st = new StringTokenizer(br.readLine());
        int[] distAccumulates = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            distAccumulates[i] = distAccumulates[i - 1] + Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            /* start에서 1을 빼야 올바른 구간합을 구할 수 있다. */
            sb.append(distAccumulates[end] - distAccumulates[start - 1]).append("\n");
        }
        System.out.print(sb);
    }
}
