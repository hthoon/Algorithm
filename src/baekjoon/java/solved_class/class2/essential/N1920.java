package baekjoon.java.solved_class.class2.essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N1920 {
    /**
     * 수 찾기 S4
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /* 정수 Set */
        Set<Long> nums = new HashSet<>();

        /* Set에 정수 입력 */
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums.add(Long.parseLong(st.nextToken()));
        }

        /* 검사 대상 정수 */
        int M = Integer.parseInt(br.readLine());

        /* 존재 여부에 따라 출력
        -> StringBuilder 사용 시 메모리, 시간 이점 큼
        */

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (nums.contains(Long.parseLong(st.nextToken()))) {
                sb.append(1).append("\n");
            }
            else sb.append(0).append("\n");
        }
        System.out.println(sb);
    }
}
