package baekjoon.java.stepbystep.S10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3_N3009 {
    /**
     * 네 번째 점 - XOR
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] x = new int[3];
        int[] y = new int[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        /*
        XOR 연산
        일치하는 수는 사라지므로, 다른 수만 남는다.
        if x1 == x2 -> x1 ^ x2 -> 0
        */
        int x4 = x[0] ^ x[1] ^ x[2];
        int y4 = y[0] ^ y[1] ^ y[2];

        System.out.printf("%d %d", x4, y4);
    }
}
