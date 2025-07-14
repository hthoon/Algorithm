package baekjoon.java.solved_class.class2.essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11650 {
    /**
     * 좌표 정렬하기 - Comparator
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /* 길이 N, 좌표 (x, y)를 담는 배열 */
        int[][] coords = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coords[i][0] = Integer.parseInt(st.nextToken());
            coords[i][1] = Integer.parseInt(st.nextToken());
        }

        /*
        * 정렬 조건
        * 1. x좌표 오름차순
        * 2. y좌표 오름차순
        * */
        Arrays.sort(coords, (c1, c2) -> {
            /* 1. x좌표값이 같은 경우 y좌표 오름차순 정렬 */
            if (c1[0] == c2[0]) return c1[1] - c2[1];
            /* 2. x좌표 오름차순 정렬 */
            return c1[0] - c2[0];
        });

        /* 일일이 출력 시 시간 초과 발생
        for (int[] coord : coords) {
            System.out.printf("%d %d\n", coord[0], coord[1]);
        }
        */

        /* 한 번에 출력해 출력 시간 줄이기 */
        StringBuilder sb = new StringBuilder();
        for (int[] coord : coords) {
            sb.append(coord[0]).append(" ").append(coord[1]).append("\n");
        }
        System.out.print(sb);
    }
}
