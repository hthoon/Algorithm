package java.doit_begin.chapter1;

import java.util.Scanner;

public class Q5_Median2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        System.out.println("중위값: " + median_2(a, b, c));
    }

    static int median_2(int a, int b, int c) {
        if ((b >= a && c <= a) || (b <= a && c >= a)) return a;
        else if ((a > b && c < b) || (a < b && c > b)) return b;
        return c;
    }

}
