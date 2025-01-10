package baekjoon.java.stepbystep.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1_N27866 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String S = br.readLine();

            char i = S.charAt(Integer.parseInt(br.readLine()) - 1);

            System.out.println(i);
        }
    }
}
