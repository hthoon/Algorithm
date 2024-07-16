package java.doit_begin.chapter1;

import java.util.Scanner;

public class Q13_Square {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("변의 길이: ");
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
