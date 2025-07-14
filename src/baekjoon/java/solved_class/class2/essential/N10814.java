package baekjoon.java.solved_class.class2.essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class N10814 {
    /**
     * 나이순 정렬 - Bucket Sort
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /**
         * 버킷 정렬 접근법
         * 1. 각 나이의 마지막 인덱스를 찾는다.
         * 2. 해당 인덱스의 뒤에 값을 삽입한다.
         * -> 나이에 해당하는 버킷에 입력값을 저장한다.
         * */

        /*
         * (나이, 이름) 형식의 입력이 주어진다.
         * 나이 범위 길이의 이중 List 선언
         * */
        int MAX_AGE = 200;
        List<List<String>> list = new ArrayList<>();
        for (int i = 1; i <= MAX_AGE + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            /* 나이 추출 */
            int age = Integer.parseInt(line.split(" ")[0]);

            /* 나이 인덱스에 라인 저장 */
            list.get(age).add(line);
        }

        for (List<String> l : list) {
            for (String s : l) {
                System.out.println(s);
            }
        }
    }
}
