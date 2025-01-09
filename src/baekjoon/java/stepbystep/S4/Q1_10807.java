package baekjoon.java.stepbystep.S4;

import java.io.*;
import java.util.StringTokenizer;

public class Q1_10807 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine());
            int[] nums = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int v = Integer.parseInt(br.readLine());
            int count = 0;

            for (int num : nums) {
                if (num == v) {
                    count++;
                }
            }

            bw.write(Integer.toString(count));
            bw.flush();
        }
    }
}
