package baekjoon.java.solved_class.class2.essential;

import java.io.*;
import java.util.*;

public class N1920 {
    /**
     * 수 찾기 - 이분 탐색
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /* 정수 배열 */
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 이분 탐색을 위해 정렬
        Arrays.sort(nums);

        /* 탐색 대상 정수 배열 */
        int M = Integer.parseInt(br.readLine());
        int[] targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        /* 탐색 */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(bs(nums, targets[i])).append("\n");
        }
        System.out.print(sb);
    }

    private static int bs(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 탐색 성공
            if (nums[mid] == target) {
                return 1;
            }
            // 탐색 범위가 대상보다 클 경우,
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            // 탐색 범위가 대상보다 작을 경우,
            else {
                left = mid + 1;
            }
        }
        return 0;
    }
}
