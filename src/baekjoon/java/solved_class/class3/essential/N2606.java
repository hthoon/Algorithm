package baekjoon.java.solved_class.class3.essential;

import java.io.*;
import java.util.*;

public class N2606 {
    /**
     * 바이러스 - DFS (재귀)
     */

    /* 풀이에 사용할 전역 변수 */
    static List<Integer>[] network;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computers = Integer.parseInt(br.readLine());
        int connections = Integer.parseInt(br.readLine());

        /* 네트워크 생성 - 인접 리스트 */
        network = new ArrayList[computers + 1];
        for (int i = 1; i <= computers; i++) {
            network[i] = new ArrayList<>();
        }

        /* 네트워크 연결 정보 */
        for (int i = 1; i <= connections; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            /* 무방향 */
            network[prev].add(next);
            network[next].add(prev);
        }

        /* 무방향 그래프 탐색이므로 노드 방문 정보를 저장해야 한다. */
        boolean[] isInfected = new boolean[computers + 1];

        /* 시작 노드: 1번 컴퓨터 */
        infect(1, isInfected);

        /* 첫 번째 컴퓨터는 카운팅에서 제외 */
        System.out.print(count - 1);
    }

    private static void infect(int computer, boolean[] isInfected) {
        // 인자로 들어온 노드를 방문 처리, 감염 컴퓨터 카운팅
        isInfected[computer] = true;
        count++;
        // 네트워크 상에서 연결된 컴퓨터 탐색
        for (int next : network[computer]) {
            // next에 해당되는 컴퓨터를 방문하지 않았으면 재귀 호출
            if (!isInfected[next]) {
                infect(next, isInfected);
            }
        }
    }
}
