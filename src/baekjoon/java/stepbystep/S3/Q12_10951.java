package baekjoon.java.stepbystep.S3;

import java.io.*;
import java.util.StringTokenizer;

public class Q12_10951 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String input;
            boolean isFirst = true;
            StringBuilder sb = new StringBuilder();

            // 인텔리제이에서는 주석 해제해야 종료됨.
            while ((input = br.readLine()) != null) {
//                if (input.isEmpty()) {
//                    break;
//                }

                StringTokenizer st = new StringTokenizer(input);

                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                if (isFirst) {
                    sb.append(A + B);
                    isFirst = false;
                    continue;
                }

                sb.append("\n").append(A + B);
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }
}