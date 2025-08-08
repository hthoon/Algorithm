package baekjoon.java.solved_class.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1966 {
    /**
     * 프린터 큐
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        /* T회 반복 */
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   // 문서의 개수
            int M = Integer.parseInt(st.nextToken());   // 궁금한 문서의 인덱스

            st = new StringTokenizer(br.readLine());    // 문서의 중요도 행

            /* 중요도 카운팅 배열 */
            int[] priorities = new int[10];

            /* {인덱스, 중요도} 저장하는 프린터 큐 */
            Queue<Integer[]> printQ = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                /* 중요도 */
                Integer priority = Integer.parseInt(st.nextToken());

                /* 중요도, 인덱스 저장 */
                Integer[] print = {j, priority};
                printQ.add(print);

                /* 중요도 카운팅 배열에 반영 */
                priorities[priority]++;
            }

            /* 몇 번째 출력물인지 기록할 카운팅 변수 */
            int count = 1;
            for (int j = 9; j > 0; j--) {
                /* 중요도 카운팅 존재 시 반복 */
                while (priorities[j] > 0) {
                    Integer[] next = printQ.poll();

                    /* 중요도 일치, M과 일치하는 인덱스인 경우, 종료 */
                    if (next[1] == j && next[0] == M) {
                        /* 몇 번째로 출력되었는지 쓰기 */
                        sb.append(count).append("\n");
                        break;
                    }
                    /* 중요도만 일치할 경우 출력 */
                    else if (next[1] == j) {
                        /* 중요도 카운팅 배열 반영 */
                        priorities[next[1]]--;
                        /* 출력 순서 카운팅  */
                        count++;
                    }
                    /* 그 외의 경우 */
                    else {
                        printQ.offer(next);
                    }
                }

            }
        }
        System.out.print(sb);
    }
}