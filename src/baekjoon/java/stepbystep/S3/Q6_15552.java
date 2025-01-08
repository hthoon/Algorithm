package baekjoon.java.stepbystep.S3;

import java.io.*;

public class Q6_15552 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int space = 0;
            String nums = br.readLine();

            for (int j = 0; j < nums.length(); j++) {
                if (nums.charAt(j) == ' ') {
                    space = j;
                    break;
                }
            }

            int A = Integer.parseInt(nums.substring(0, space));
            int B = Integer.parseInt(nums.substring(space + 1));

            sb.append(A + B).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}