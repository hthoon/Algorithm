package baekjoon.java.stepbystep.S8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q7_N2869 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String[] nums = br.readLine().split(" ");

            int A = Integer.parseInt(nums[0]);
            int B = Integer.parseInt(nums[1]);
            int V = Integer.parseInt(nums[2]);

            int day = 1;

            // 정수 연산으로 올림 처리(V에 (B + 1)을 뺄셈)
            day += (V - B - 1) / (A - B);

            System.out.println(day);
        }
    }
}
