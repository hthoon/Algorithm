package baekjoon.java.solved_class.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N31403 {
    /**
     * A + B - C
     * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        /* int */
        System.out.println(Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C));

        /* String */
        System.out.println(Integer.parseInt(A + B) - Integer.parseInt(C));
    }
}
