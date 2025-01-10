package baekjoon.java.stepbystep.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4_N11654 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            char letter = br.readLine().charAt(0);

            System.out.println((byte) letter);

            /*
            int 형변환으로도 사용 가능.
            System.out.println((int) letter);
            */
        }
    }
}
