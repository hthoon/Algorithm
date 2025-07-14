package baekjoon.java.solved_class.class2.essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1181 {
    /**
     * 단어 정렬 - Comparator
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /* 중복 제거 */
        Set<String> words = new HashSet<>();
        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        List<String> list = new ArrayList<>(words);
        /* Comparator 사용하여 길이순 -> 사전순 정렬 */
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                /* 길이순 정렬 */
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }
                /* 사전순 정렬 */
                return o1.compareTo(o2);
            }
        });

        /* 람다 사용
        list.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            return o1.compareTo(o2);
        });
        */

        for (String word : list) {
            System.out.println(word);
        }
    }
}
