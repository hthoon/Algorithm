package java.doit_begin.chapter1;

import java.util.Scanner;

public class Q8_Loop {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("a: ");
        int a = input.nextInt();
        System.out.print("b: ");
        int b = input.nextInt();

        System.out.println(sumof(a, b));
    }

    static int sumof(int a, int b) {
        int sum = 0, temp = 0;

        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        }

        while (a <= b) {
            sum += a;
            a++;
        }

        return sum;
    }
}
