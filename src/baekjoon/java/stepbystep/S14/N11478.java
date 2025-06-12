package baekjoon.java.stepbystep.S14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N11478 {
    /**
     * 서로 다른 부분 문자열의 개수
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* 문자열 타입으로 받은 후, substring */
        String S = br.readLine();

        /* 결괏값을 Set에 담아 중복 방지 */
        Set<String> result = new HashSet<>();

        /* len -> 글자 수. 1 ~ 총 길이 */
        for (int len = 1; len <= S.length(); len++) {
            /* len에 맞춰 루프 조정 */
            for (int i = 0; i <= S.length() - len; i++) {
                result.add(S.substring(i, i + len));
            }
        }
        System.out.println(result.size());
    }
}