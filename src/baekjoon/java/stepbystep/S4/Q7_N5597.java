package baekjoon.java.stepbystep.S4;

import java.io.*;

public class Q7_N5597 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int[] students = new int[30];

            for (int i = 0; i < 28; i++) {
                students[Integer.parseInt(br.readLine()) - 1] = 1;
            }

            int count = 0;

            for (int i = 0; i < students.length || count < 2; i++) {
                if (students[i] == 0) {
                    System.out.println(i + 1);
                    count++;
                }
            }
        }
    }
}
