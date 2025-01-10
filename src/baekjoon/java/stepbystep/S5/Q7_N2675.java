package baekjoon.java.stepbystep.S5;

import java.io.*;
import java.util.StringTokenizer;

public class Q7_N2675 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int T = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < T; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int R = Integer.parseInt(st.nextToken());
                String S = st.nextToken();

                for (int j = 0; j < S.length(); j++) {
                    sb.append(String.valueOf(S.charAt(j)).repeat(R));
                }

                sb.append("\n");
            }

            bw.write(String.valueOf(sb));
            bw.flush();
        }
    }
}
