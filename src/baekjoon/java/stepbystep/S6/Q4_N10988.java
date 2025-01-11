package baekjoon.java.stepbystep.S6;

import java.io.*;

public class Q4_N10988 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            String word = br.readLine();

            boolean result = true;

            for (int i = 0; i < word.length() / 2; i++) {

                if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                    result = false;
                    break;
                }
            }

            System.out.println(result ? 1 : 0);
        }
    }
}
