package baekjoon.java.stepbystep.S15;

import java.io.*;
import java.util.*;

public class N1934 {
    /**
     * 최소공배수
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(commonX(a, b) + "\n");
        }
        bw.flush();
    }

    private static int commonX(int a, int b) {

        int result = 1;
        int num = 2;

        /* 종료 조건: 둘 중 하나의 수라도 1이 되면 종료 */
        while (a > 1 || b > 1) {
            /* 1. 둘 중 하나의 수라도 나뉘면 result에 누적 */
            if (a % num == 0 || b % num == 0) {
                result *= num;

                /* 2. 나뉘는 수만 나눈다. */
                if (a % num == 0) a /= num;
                if (b % num == 0) b /= num;

                /* 3. num으로 다시 나뉠 수 있으므로, continue로 num 증가 패싱 */
                continue;
            }
            num++;
        }
        /* 결과에 서로소 곱하기 */
        result *= a * b;

        return result;
    }
}