package baekjoon.java.stepbystep.S8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6_N1193 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int X = Integer.parseInt(br.readLine());

            // 해당 분수가 몇 번째 줄에 존재하는지 탐색
            int row = 1;
            int sum = 0;

            // 누적값이 후에 영향을 주지 않도록 한다.
            while (sum + row < X) {
                sum += row;
                row++;
            }

            int idx = X - sum - 1;

            int N, D;

            // 짝수 행이면
            if (row % 2 == 0) {
                N = idx + 1;
                D = row - idx;
            }
            else {
                N = row - idx;
                D = idx + 1;
            }

            System.out.printf("%d/%d", N, D);
        }
    }
}
