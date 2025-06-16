package baekjoon.java.solved_class.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2741 {
    /**
     * N 찍기
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            System.out.println(i);
        }
    }
}
