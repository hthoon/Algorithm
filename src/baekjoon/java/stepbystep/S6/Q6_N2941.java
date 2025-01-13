package baekjoon.java.stepbystep.S6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6_N2941 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            String word = br.readLine();

            /*
             * dz=
             * c= s= z=
             * c- d-
             * lj nj
             * */

            String[] croatia = {"dz=", "c=", "s=", "z=", "c-", "d-", "lj", "nj"};

            for (String alp : croatia) {
                word = word.replace(alp, "!");
            }

            System.out.println(word.length());
        }
    }
}
