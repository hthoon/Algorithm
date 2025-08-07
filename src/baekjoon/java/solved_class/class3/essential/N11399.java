package baekjoon.java.solved_class.class3.essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11399 {
    /**
     * ATM
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        /* 소요 시간 배열 */
        int[] times = new int[N];
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        /* 오름차순 정렬일 때 최소 시간 소요 */
        Arrays.sort(times);

        /*
        * current: 현재 순서의 사람이 기다린 시간
        * total: 총 소요 시간
        *
        * 첫 순서는 미리 누적하고 시작한다.
        * */
        int current = times[0];
        int total = current;
        for (int i = 1; i < N; i++) {
            current += times[i];
            total += current;
        }
        System.out.print(total);
    }
}
