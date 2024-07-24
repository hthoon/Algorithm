package java_algorithm.doit_begin.chapter6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Q6_SelectionSort {

    static void swap(int[] array, int a, int b) {
        int temp;
        temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    static void selectionSort(int[] array, int n) {
        System.out.printf("초기 배열: %s\n", Arrays.toString(array));
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++)
                if (array[j] < array[min])
                    min = j; // 가장 작은 인덱스

            for (int k = 0; k < n; k++) {
                if (k == i) {                 // k가 정렬하지 않은 부분의 맨 앞이면 * 출력
                    System.out.print("  *");
                } else if (k == min) {        // k가 정렬하지 않은 부분 중 최솟값이면 + 출력
                    System.out.print("  +");
                } else {                      // 어느 경우에도 해당되지 않으면 공백 출력해서 패스
                    System.out.print("   ");
                }
            }
            System.out.println();

            for (int k = 0; k < n; k++) {
                System.out.printf("%3d", array[k]); // 교환이 이루어지기 전의 배열 출력
            }
            System.out.println();
            swap(array, i, min);  // 요소 교환
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Random rand = new Random();

		System.out.println("단순선택정렬");
		System.out.print("요솟수 : ");

        int n = stdIn.nextInt();
        int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = rand.nextInt(20);
		}

		selectionSort(array, n);			// 배열 x를 단순선택정렬

		System.out.println("오름차순으로 정렬하였습니다.");
		for (int i = 0; i < n; i++)
			System.out.println("x[" + i + "]＝" + array[i]);
    }

}
