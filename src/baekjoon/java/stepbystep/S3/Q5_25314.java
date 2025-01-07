package baekjoon.java.stepbystep.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5_25314 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println("long ".repeat(N / 4) + "int");
    }
}
