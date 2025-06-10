package baekjoon.java.stepbystep.S10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6_N10101 {
    /**
     * 삼각형 외우기
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int z = Integer.parseInt(br.readLine());

        if (x + y + z != 180) {
            System.out.println("Error");
        }
        else if (x == 60 && y == 60) {
            System.out.println("Equilateral");
        }
        else if (x != y && y != z && x != z) {
            System.out.println("Scalene");
        }
        else {
            System.out.println("Isosceles");
        }
    }
}
