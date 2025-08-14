package baekjoon.java.solved_class.class3;

import java.io.*;
import java.util.*;

public class N18870 {
    /**
     * 좌표 압축
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 1 <= N <= 1000000

        /*
        2  4 -10 4 -9
        2  3  0  3  1

        1000  999 1000  999 1000  999
           1    0    1    0    1    0

       위의 두 예시를 보면, 가장 작은 값부터 오름차순으로 새로운 좌표가 메겨짐.
       -> 가장 작은 좌표값 -> 그 뒤로 1씩 증가하는 새로운 배열
        */

        /* 입력값 저장
        * coords: 초기 좌표 배열
        * */
        int[] coords = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coords[i] = Integer.parseInt(st.nextToken());
        }

        /* 초기 배열의 정렬본 획득 */
        int[] sortedCoords = coords.clone();
        Arrays.sort(sortedCoords);

        /* Map Collection에 압축 좌표를 저장 */
        Map<Integer, Integer> compressedCoords = new HashMap<>();
        int prev = -1000000000; // 하한값
        int count = 0;
        for (int coord : sortedCoords) {
            // 최적화: 정렬된 배열에서 값을 가져온다.
            // 따라서, 이전값과 다르면 새로 추가할 좌표값이다.
            if (coord != prev) {
                compressedCoords.put(coord, count);
                prev = coord;
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int coord : coords) {
            sb.append(compressedCoords.get(coord)).append(" ");
        }
        System.out.print(sb);
    }
}
