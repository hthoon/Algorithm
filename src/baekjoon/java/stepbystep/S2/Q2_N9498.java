package baekjoon.java.stepbystep.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2_N9498 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int score = Integer.parseInt(br.readLine());

        if (score < 60) {
            System.out.println("F");
        }
        else if (score < 70) {
            System.out.println("D");
        }
        else if (score < 80) {
            System.out.println("C");
        }
        else if (score < 90) {
            System.out.println("B");
        }
        else {
            System.out.println("A");
        }
    }
}
