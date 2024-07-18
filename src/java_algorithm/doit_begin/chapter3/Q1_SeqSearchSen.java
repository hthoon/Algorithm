package java_algorithm.doit_begin.chapter3;

import java.util.Scanner;

public class Q1_SeqSearchSen {

    static int seqSearchSen(int[] a, int n, int key) {
        int i = 0;

        a[n] = key;

        System.out.print("   |");

        System.out.printf(String.format("%%2d | %%%dd\n", n));

        while (true) {
            if (a[i] == key)
                break;
            i++;
        }
        return i == n ? -1 : i;
    }

    static int seqSearchSenQ1(int[] a, int n, int key) {
        int i = 0;

        a[n] = key;

        for ( ;; ) {
            if (a[i] == key)
                break;
            i++;
        }
        return i == n ? -1 : i;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("요솟수: ");
        //int num = input.nextInt();
        int num = 5;
        int[] x = new int[num + 1];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = input.nextInt();
        }

        System.out.print("검색할 값: ");
        int ky = input.nextInt();

        int idx = seqSearchSenQ1(x, num, ky);

        if (idx == 1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
    }
}
