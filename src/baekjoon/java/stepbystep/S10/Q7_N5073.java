package baekjoon.java.stepbystep.S10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q7_N5073 {
    /**
     * 삼각형과 세 변
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] es = new int[3];
            for (int i = 0; i < es.length; i++) {
                es[i] = Integer.parseInt(st.nextToken());
            }

            if (es[0] + es[1] + es[2] == 0) {
                return;
            }

            Arrays.sort(es);

            if (es[0] + es[1] <= es[2]) {
                System.out.println("Invalid");
            }
            else if (es[0] == es[1] && es[1] == es[2]) {
                System.out.println("Equilateral");
            }
            else if (es[0] != es[1] && es[1] != es[2] && es[2] != es[0]) {
                System.out.println("Scalene");
            }
            else {
                System.out.println("Isosceles");
            }
        }
    }
}
