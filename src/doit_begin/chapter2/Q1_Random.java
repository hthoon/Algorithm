package doit_begin.chapter2;

import java.util.Random;
import java.util.Scanner;

public class Q1_Random {

    static int maxOf (int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }

    static int maxOf_Rand (int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        System.out.println("키의 최댓값을 구합니다.");
        System.out.print("사람 수: ");
        // int num = input.nextInt(); 난수를 위해 주석 처리
        int num = rand.nextInt(1, 100);

        int[] height = new int[num];

        System.out.println("킷값은 다음과 같습니다.");
        for (int i = 0; i < num; i++) {
            height[i] = 100 + rand.nextInt(90);
            System.out.println("height[" + i + "]: " + height[i]);
        }

        System.out.println("최댓값은 " + maxOf_Rand(height) + "입니다.");
    }
}
