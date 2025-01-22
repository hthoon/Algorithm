package baekjoon.java.stepbystep.S8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5_N2292 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(br.readLine());

            int pass = 1;
            int room = 1;

            while (room < N) {
                room += 6 * pass;
                pass++;
            }

            System.out.println(pass);
        }
    }
}
