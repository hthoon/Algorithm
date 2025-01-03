package baekjoon.java.stepbystep.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q3_N1001 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println(num1 - num2);

        /*---------------------------------*/
//      BufferedReader 사용

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int int1 = Integer.parseInt(st.nextToken());
        int int2 = Integer.parseInt(st.nextToken());

        System.out.println(int1 - int2);
    }
}
