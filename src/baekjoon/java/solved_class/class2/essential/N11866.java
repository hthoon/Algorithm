package baekjoon.java.solved_class.class2.essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N11866 {
    /**
     * 요세푸스 문제 0 - Queue
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int K = Integer.parseInt(st.nextToken()); // 제거 주기

        /* 접근
        * 순회하며 결과 배열에 값 저장
        * */

        Queue<Integer> table = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            table.add(i + 1);
        }

        StringBuilder sb = new StringBuilder("<");
        int count = 0;
        while (!table.isEmpty()) {
            /* 주기에 해당하면 결과 큐에 저장 */
            if (count == K - 1) {
                sb.append(table.poll()).append(", ");
                count = 0;
                continue;
            }
            /* 주기에 해당하지 않으면 뒤로 밀어내기 */
            table.add(table.poll());
            count++;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");

        System.out.println(sb);
    }
}
