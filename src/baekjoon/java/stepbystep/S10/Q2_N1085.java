package baekjoon.java.stepbystep.S10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2_N1085 {
    /**
     * 직사각형에서 탈출
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        /*
        * x -> w - x
        * y -> h - y
        * */

        /* x   w-x   y   h-y*/
        int[] dist = {x, w - x, y, h - y};

        int min = dist[0];
        for (int i : dist) {
            if (i < min) {
                min = i;
            }
        }
        System.out.println(min);
    }
}
