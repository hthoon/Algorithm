package baekjoon.java.stepbystep.S4;

import java.io.*;

public class Q4_N2562 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int[] nums = new int[9];
            int max = 0;
            int idx = 0;

            for (int i = 0; i < nums.length; i++) {
                int num = Integer.parseInt(br.readLine());
                if (max < num) {
                    max = num;
                    idx = i + 1;
                }
            }

            bw.write(String.format("%d\n%d", max, idx));
            bw.flush();
        }
    }
}
