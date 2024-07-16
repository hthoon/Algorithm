package java.doit_begin.chapter2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Q4_Copy {

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

        copy(myArray1, myArray2);

    }

    static void copy(int[] array1, int[] array2) {
        System.out.println("복사 전");
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));

        for (int i = 0; i < array1.length; i++) {
            array2[i] = array1[i];
        }

        System.out.println("복사 후");
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }
}
