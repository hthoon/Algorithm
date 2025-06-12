package baekjoon.java.stepbystep.S14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N10815 {
    /**
     * 숫자 카드
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* 상근 카드 */
        int N = Integer.parseInt(br.readLine());
        Set<Integer> cardsN = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cardsN.add(Integer.parseInt(st.nextToken()));
        }

        /* 비교 카드 */
        int M = Integer.parseInt(br.readLine());
        int[] cardsM = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            cardsM[i] = Integer.parseInt(st.nextToken());
        }

        /* 탐색 */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (cardsN.contains(cardsM[i])) {
                sb.append("1 ");
            }
            else {
                sb.append("0 ");
            }
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
}