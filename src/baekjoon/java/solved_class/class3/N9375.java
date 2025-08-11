package baekjoon.java.solved_class.class3;

import java.io.*;
import java.util.*;

public class N9375 {
    /**
     * 패션왕 신해빈 - 경우의 수, Map 순회
     *
     * 참고) entrySet 순회
     * for (Map.Entry<String, Integer> entry : map.entrySet()) {
     *     String key = entry.getKey();
     *     Integer value = entry.getValue();
     * }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        /*
        * 1. 부위 별로 안 입을 수도 있다.
        * 2. 하지만 뭐라도 하나 걸쳐야 한다.
        * */

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> clothes = new HashMap<>();
            for (int j = 0; j < n; j++) {
                /* 카테고리 추출 */
                String category = br.readLine().split(" ")[1];

                /* 해당 카테고리의 갯수 카운팅 */
                clothes.put(category, clothes.getOrDefault(category, 0) + 1);
            }

            int combinations = 1;
            /* 중요! Map 순회 */
            for (int quantity : clothes.values()) {
                /* 안 입을 수도 있으므로, 1을 추가해 누적한다. */
                combinations *= quantity + 1;
            }
            /* 아예 안 입는 경우를 뺀다. */
            System.out.println(combinations - 1);
        }
    }
}
