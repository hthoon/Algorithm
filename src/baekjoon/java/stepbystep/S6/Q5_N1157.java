package baekjoon.java.stepbystep.S6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5_N1157 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            String word = br.readLine().toUpperCase();

            int[] alps = new int[26];

            for (char let : word.toCharArray()) {
                alps[let - 'A']++;
            }

            int freqN = 0;
            char freqC = '?';

            for (int i = 0; i < alps.length; i++) {

                if (alps[i] > freqN) {
                    freqN = alps[i];
                    freqC = (char) (i + 'A');
                }
                else if (freqN == alps[i]) {
                    freqC = '?';
                }
            }

            System.out.println(freqC);
        }
    }
}
