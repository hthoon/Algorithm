package baekjoon.java.stepbystep.S14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N10816 {
    /**
     * 숫자 카드 2
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /*
         * 상근 카드
         * 카드 수를 미리 카운팅
         * */
        Map<Long, Integer> cards = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Long card = Long.parseLong(st.nextToken());
            /* cards에 card가 존재하면 value를 +1하여 저장 */
            cards.put(card, cards.getOrDefault(card, 0) + 1);
        }

        /* 카드 찾기 */
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            long find = Long.parseLong(st.nextToken());
            /* key 존재 확인 */
            if (cards.containsKey(find)) {
                sb.append(cards.get(find)).append(" ");
            }
            else {
                sb.append("0 ");
            }
        }
        System.out.print(sb);
    }
}