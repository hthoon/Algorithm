package java.doit_begin.chapter2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Q5_reCopy {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("요솟수: ");
        int num = input.nextInt();

        int[] myArray1 = new int[num];
        int[] myArray2 = new int[num];

        for (int i = 0; i < num; i++) {
            //System.out.print("x[" + i + "]" );
            myArray1[i] = rand.nextInt(100);
        }

        System.out.println(Arrays.toString(myArray1));
        System.out.println(Arrays.toString(myArray2));

        reCopy(myArray1, myArray2);

    }

    static void swap(int[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
        // System.out.println("array[" + idx1 + "]와 array[" + idx2 + "]를 교환합니다.");
    }

    static void reCopy(int[] array1, int[] array2) {

        for (int i = 0; i < array1.length; i++) {
            array2[i] = array1[i];
        }

        for (int i = 0; i < array2.length / 2; i++) {
            swap(array2, i, array2.length - i - 1);
        }

        System.out.println("역순 복사 후");
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }
}
