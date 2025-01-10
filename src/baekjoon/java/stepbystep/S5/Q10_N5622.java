package baekjoon.java.stepbystep.S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10_N5622 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String dial = br.readLine();

            int sum = 0;

            for (int i = 0; i < dial.length(); i++) {
                sum += switchDial(String.valueOf(dial.charAt(i)));
            }

            System.out.println(sum);
        }
    }

    // 향상된 switch 구문 사용 불가
    private static int switchDial(String alp) {

        switch (alp) {
            case "A":
            case "B":
            case "C":
                return 3;
            case "D":
            case "E":
            case "F":
                return 4;
            case "G":
            case "H":
            case "I":
                return 5;
            case "J":
            case "K":
            case "L":
                return 6;
            case "M":
            case "N":
            case "O":
                return 7;
            case "P":
            case "Q":
            case "R":
            case "S":
                return 8;
            case "T":
            case "U":
            case "V":
                return 9;
            case "W":
            case "X":
            case "Y":
            case "Z":
                return 10;
            default:
                return 0;
        }
    }
}
