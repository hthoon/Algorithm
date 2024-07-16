package java.doit_begin.chapter2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Q3_SumOf {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("요솟수: ");
        int num = input.nextInt();

        int[] myArray = new int[num];

        for (int i = 0; i < num; i++) {
            //System.out.print("x[" + i + "]" );
            myArray[i] = rand.nextInt(100);
        }

        System.out.println(sumOf(myArray));

    }

    static int sumOf(int[] array) {
        int result = 0;

        for (int nums : array) {
            result += nums;
        }

        return result;
    }
}
