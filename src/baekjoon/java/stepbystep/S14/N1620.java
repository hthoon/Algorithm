package baekjoon.java.stepbystep.S14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1620 {
    /**
     * 나는야 포켓몬 마스터 이다솜
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /*
         * 이름 - 번호 형식의 도감 만들기
         * 양방향 조회를 위해 두 개의 Map 생성
         * */
        Map<String, Integer> pokemons1 = new HashMap<>();
        Map<Integer, String> pokemons2 = new HashMap<>();
        for (int i = 1; i < N + 1; i++) {
            String name = br.readLine();
            pokemons1.put(name, i);
            pokemons2.put(i, name);
        }

        /*
         * SB 사용 시, 메모리는 조금 더 써도 시간은 훨씬 빠름.
         * 65420 -> 70080(KB)
         * 1072    -> 600(ms)
         * */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String find = br.readLine();

            /* 입력이 정수면 2에서 탐색 */
            if (isNumeric(find)) {
                sb.append(pokemons2.get(Integer.parseInt(find))).append("\n");
            }
            /* 입력이 문자열이면 1에서 탐색 */
            else {
                sb.append(pokemons1.get(find)).append("\n");
            }
        }
        System.out.print(sb);
    }

    /* 숫자 판별 */
    private static boolean isNumeric(String s) {
        return s.chars().allMatch(Character::isDigit);
    }
}