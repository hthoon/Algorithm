package baekjoon.java.solved_class.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10989 {
    /**
     * 수 정렬하기 3 - Counting sort
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /*
        수의 범위: 1 <= int <= 10000
        1. 범위에 대응하는 배열을 생성
        2. 입력값에 대응하는 인덱스를 카운팅
        */
        int[] nums = new int[10001];
        for (int i = 0; i < N; i++) {
            nums[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            /* early return: N회 수행 시 종료 */
            if (count == N) return;

            /* 각 수의 카운팅이 존재하면 결과에 저장 및 차감, count 증가 */
            while (nums[i] > 0) {
                sb.append(i).append("\n");
                nums[i]--;
                count++;
            }
        }
        System.out.println(sb);
    }
}
