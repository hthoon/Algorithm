package baekjoon.java.stepbystep.S13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2750 {
    /**
     * 수 정렬하기
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        sort(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    /* 버블 정렬 */
    private static void sort(int[] nums) {
        boolean swapped;
        do {
            swapped = false;
            /* 정렬된 값이 있으면 swapped = true 할당하여 루프 지속 */
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                    swapped = true;
                }
            }
        }
        while (swapped);
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
