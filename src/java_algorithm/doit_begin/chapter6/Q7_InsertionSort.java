package java_algorithm.doit_begin.chapter6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Q7_InsertionSort {

    static void insertionSort(int[] array, int n) {

        // 두 번째 요소부터 배열의 끝까지 정렬을 (n - 1)번 수행
        for (int i = 1; i < n; i++) {

            // 정렬 전 배열 출력
            System.out.print("  ");
            for (int num : array) {
                System.out.printf("%-3d", num);
            }
            System.out.println();

            int j;
            int temp = array[i];
            for (j = i; j > 0 && array[j - 1] > temp; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;

            // 시각화 출력부
            System.out.print("  ");

            // 1. 삽입이 일어난 경우
            if (j < i) {
                // ^ 전까지 공백 출력
                for (int k = 0; k < j; k++) {
                    System.out.print("   ");
                }
                System.out.print("^--");

                // + 전까지 - 출력
                for (int k = j + 1; k < i; k++) {
                    System.out.print("---");
                }
            }

            // 2. 삽입이 일어나지 않은 경우
            else {
                for (int k = 0; k < j; k++) {
                    System.out.print("   ");
                }
            }

            // 앞 요소들을 출력한 후, + 출력
            System.out.print("+\n");
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수: ");
        int n = stdIn.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(10);
        }

        System.out.println("초기 배열: " + Arrays.toString(array));
        System.out.println("-----------------------------------");

        insertionSort(array, array.length);

        System.out.println("오름차순으로 정렬 완료");
        System.out.println("정렬 배열: " + Arrays.toString(array));
    }
}
