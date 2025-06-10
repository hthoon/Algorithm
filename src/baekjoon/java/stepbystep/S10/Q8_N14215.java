package baekjoon.java.stepbystep.S10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q8_N14215 {
    /**
     * 세 막대
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] es = new int[3];

        for (int i = 0; i < es.length; i++) {
            es[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(es);

        /*
        삼각형 조건이 성립하지 않는 경우
        1. 가장 긴 변의 길이가 나머지 두 변의 길이 합보다 길다.
        2. 조건 1 + 이등변 삼각형이 될 수 없다.
        */
        if (es[0] + es[1] <= es[2] && es[1] != es[2]) {
            es[2] = es[0] + es[1] - 1;
        }

        System.out.println(es[0] + es[1] + es[2]);
    }
}
