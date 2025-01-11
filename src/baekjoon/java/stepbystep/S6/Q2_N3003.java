package baekjoon.java.stepbystep.S6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2_N3003 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            int[] board = {1, 1, 2, 2, 2, 8};

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < board.length; i++) {
                board[i] -= Integer.parseInt(st.nextToken());
                System.out.printf("%d ", board[i]);
            }
        }
    }
}
