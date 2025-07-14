package baekjoon.java.solved_class.class2.essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N4153 {
    /**
     * 직각삼각형
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int[] sides = new int[3];
            StringTokenizer st = new StringTokenizer(br.readLine());
            sides[0] = Integer.parseInt(st.nextToken());
            sides[1] = Integer.parseInt(st.nextToken());
            sides[2] = Integer.parseInt(st.nextToken());

            /* 종료 조건 */
            if (sides[0] + sides[1] + sides[2] == 0) {
                return;
            }

            Arrays.sort(sides);

            if (mul(sides[0]) + mul(sides[1]) == mul(sides[2])) {
                System.out.println("right");
            }
            else {
                System.out.println("wrong");
            }
        }
    }

    private static int mul(int num) {
        return num * num;
    }
}
