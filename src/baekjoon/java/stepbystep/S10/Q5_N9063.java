package baekjoon.java.stepbystep.S10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5_N9063 {
    /**
     * 대지
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /*
        상수를 활용할 수 있다.
        * */
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            /* Math 비교 메서드로 대입 */
            maxX = Math.max(x, maxX);
            minX = Math.min(x, minX);

            int y = Integer.parseInt(st.nextToken());
            maxY = Math.max(y, maxY);
            minY = Math.min(y, minY);
        }

        if (N == 1) {
            System.out.print(0);
            return;
        }

        System.out.print((maxX - minX) * (maxY - minY));
    }
}
