package baekjoon.java.solved_class.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2108 {
    /**
     * 통계학
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /* 범위 도출용 변수 */
        int max = -4001;    // 최댓값
        int min = 4001;     // 최솟값

        /* 숫자 배열
        * -4000 -> 0
        *     0 -> 4000
        *     1 -> 4001
        *  4000 -> 8000
        * */
        int[] nums = new int[8001]; // -4000 ~ 4000
        int offset = 4000;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            /* 카운팅 배열에 반영 */
            nums[num + offset]++;

            /* 최댓값 및 최솟값 갱신 */
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        System.out.println(getAvg(nums, N, offset));    // 산술평균
        System.out.println(getMid(nums, N, offset));    // 중앙값
        System.out.println(getFreq(nums, offset));          // 최빈값
        System.out.println(max - min);                      // 범위
    }

    private static int getAvg(int[] num, int size, int offset) {
        int[] arr = num.clone();
        double avg = 0;
        for (int i = 0; i < arr.length; i++) {
            /* 오버플로우 방지 위해 모듈러 연산 */
            avg += (double) (i - offset) * arr[i] / size;
        }
        /* round 메서드 사용으로 단순 캐스팅으로 인한 버림 방지 */
        return (int) Math.round(avg);
    }

    private static int getMid(int[] nums, int size, int offset) {
        int[] arr = nums.clone();
        int midCount = size / 2;
        int count = 0;
        /* 카운팅 배열 순회 */
        for (int i = 0; i < arr.length; i++) {
            /* 카운팅 */
            count += arr[i];

            /* 목표 카운트보다 커질 때 중앙값 발견 */
            if (count > midCount) {     // 주의: >= 조건에서는 찾지 못할 수 있음.
                return i - offset;
            }
        }
        return 0;
    }

    /* 두 번째 최빈값 처리가 조금 까다로웠음. */
    private static int getFreq(int[] nums, int offset) {
        int[] arr = nums.clone();
        int maxFreq = 0;
        int freq = 0;
        boolean firstFound = true;
        /* 카운팅 배열 순회 */
        for (int i = 0; i < arr.length; i++) {
            /* 첫 번째 최빈값 탐색 */
            if (arr[i] > maxFreq) {
                maxFreq = arr[i];
                freq = i - offset;
                firstFound = true;
            }
            /* 다른 최빈값이 존재하면 갱신 */
            else if (arr[i] == maxFreq && firstFound) {
                freq = i - offset;
                firstFound = false;
            }
        }
        return freq;
    }
}
