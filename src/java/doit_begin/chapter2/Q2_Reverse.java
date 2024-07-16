package java.doit_begin.chapter2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Q2_Reverse {

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

        reverse(myArray);

    }

    static void swap(int[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
        System.out.println("array[" + idx1 + "]와 array[" + idx2 + "]를 교환합니다.");
    }

    static void reverse(int[] array) {
        // 초기 배열 출력
        System.out.println(Arrays.toString(array));
        // array.length / 2 -> 짝수, 홀수 구분이 필요없다.
        for (int i = 0; i < array.length / 2; i++) {
            // i = 0일 때, array[0]과 array[3]을 치환
            swap(array, i, array.length - i - 1);
            System.out.println(Arrays.toString(array));
        }
        // 결과 출력
        System.out.println("요소를 역순으로 정렬했습니다.");
        System.out.println("x = " + Arrays.toString(array));
    }
}
