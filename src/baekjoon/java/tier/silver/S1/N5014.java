package baekjoon.java.tier.silver.S1;

import java.io.*;
import java.util.*;

public class N5014 {
    /**
     * 스타트링크 - BFS, 최단 거리
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken()); // 건물의 층수
        int S = Integer.parseInt(st.nextToken()); // 강호 위치
        int G = Integer.parseInt(st.nextToken()); // 목표 층수
        int U = Integer.parseInt(st.nextToken()); // 위로 U층 이동
        int D = Integer.parseInt(st.nextToken()); // 아래로 D층 이동

        // 조기 종료
        if (S == G) {
            System.out.print(0);
            return;
        }

        // 버튼 입력 횟수를 기록할 배열
        final int MAX_FLOOR = F;
        final int MIN_FLOOR = 1;
        int[] pressed = new int[MAX_FLOOR + 1];
        Arrays.fill(pressed, -1);
        pressed[S] = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(S);

        int[] nextDist = new int[2];
        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == G) {
                System.out.print(pressed[G]);
                return;
            }

            nextDist[0] = current + U; // 상
            nextDist[1] = current - D; // 하

            for (int next : nextDist) {
                // 경계 처리
                if (next > MAX_FLOOR || next < MIN_FLOOR) continue;

                // 미방문 시 버튼 입력 횟수 기록
                if (pressed[next] == -1) {
                    pressed[next] = pressed[current] + 1;
                    queue.offer(next);
                }
            }
        }
        // 여기에 도달했다는 것은, 탐색에 실패했다는 것이다.
        System.out.print("use the stairs");
    }
}
