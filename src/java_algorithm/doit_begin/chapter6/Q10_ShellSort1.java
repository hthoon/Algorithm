package java_algorithm.doit_begin.chapter6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Q10_ShellSort1 {

    static int shellSort1(int[] array, int n) {
        int count = 0;
        for (int h = n / 2; h > 0; h /= 2) {
            for (int i = h; i < n; i++) {
                int j;
                int temp = array[i];
                for (j = i - h; j >= 0 && array[j] > temp; j -= h) {
                    array[j + h] = array[j];
                    count++;
                }
                array[j + h] = temp;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("보초법을 적용한 단순 삽입 정렬");
        System.out.print("요솟수: ");
        int n = stdIn.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(array.length);
        }

        System.out.printf("초기 배열 -> %s\n", Arrays.toString(array));
        int count = shellSort1(array, n);
        System.out.printf("정렬 배열 -> %s\n", Arrays.toString(array));

        System.out.printf("요소 이동 횟수: %d", count);
    }


}
