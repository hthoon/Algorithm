package baekjoon.java.solved_class.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11651 {
    /**
     * 좌표 정렬하기 2 - Comparator
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /* 좌표 저장 */
        int[][] coords = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coords[i][0] = Integer.parseInt(st.nextToken());
            coords[i][1] = Integer.parseInt(st.nextToken());
        }

        /* y좌표 오름차순 정렬 */
        Arrays.sort(coords, (c1, c2) -> {
            /* y좌표 정렬 */
            if (c1[1] == c2[1]) return c1[0] - c2[0];
            /* x좌표 정렬 */
            return c1[1] - c2[1];
        });

        StringBuilder sb = new StringBuilder();
        for (int[] coord : coords) {
            sb.append(coord[0]).append(" ").append(coord[1]).append("\n");
        }
        System.out.print(sb);
    }
}
