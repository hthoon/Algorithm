package baekjoon.java.stepbystep.S14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1269 {
    /**
     * 대칭 차집합
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> A = new HashSet<>();

        /* 집합 A */
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(st.nextToken());
        }

        int inter = 0;

        /* 합집합 */
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            String e = st.nextToken();
            if (A.contains(e)) {
                inter++;
                continue;
            }
            A.add(e);
        }
        /* 합집합 - 교집합 */
        System.out.println(A.size() - inter);
    }
}