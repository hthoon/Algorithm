package baekjoon.java.solved_class.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2577 {
    /**
     * 숫자의 개수
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        /* 세 수의 곱 */
        int target = A * B * C;

        /* 쓰인 수를 기록할 배열 */
        int[] used = new int[10];

        while (target > 0) {
            int digit = target % 10;
            used[digit]++;
            target /= 10;
        }
        for (int num : used) {
            System.out.println(num);
        }
    }
}
