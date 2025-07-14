package baekjoon.java.stepbystep.S13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2587 {
    /**
     * 대표값2
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = new int[5];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        sort(nums);

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        System.out.printf("%d\n%d", sum / 5, nums[5 / 2]);
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
