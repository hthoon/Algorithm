package baekjoon.java.stepbystep.S13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N25305 {
    /**
     * 커트라인
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        sortDesc(scores);

        System.out.println(scores[k - 1]);
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

    /* 내림차순 정렬 */
    private static void sortDesc(int[] nums) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i + 1, i);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
