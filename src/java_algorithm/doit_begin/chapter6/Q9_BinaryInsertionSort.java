package java_algorithm.doit_begin.chapter6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Q9_BinaryInsertionSort {

    static void binaryInsertionSort(int[] array, int n) {
        /* -----------------------------*/
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int firstInd = 0;           // 검색 범위 맨앞의 인덱스
            int lastInd = i - 1;        // 　 〃 　맨끝의 인덱스
            int midInd;                 // 　 〃 　중앙의 인덱스
            int putInd;                 // 삽입하는 위치의 인덱스

            do {
                midInd = (firstInd + lastInd) / 2;
                if (array[midInd] == key)            // 검색 성공
                    break;
                else if (array[midInd] < key)
                    firstInd = midInd + 1;
                else
                    lastInd = midInd - 1;
            } while (firstInd <= lastInd);
            putInd = (firstInd <= lastInd) ? midInd + 1 : lastInd + 1;

            for (int j = i; j > putInd; j--)
                array[j] = array[j - 1];
            array[putInd] = key;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("이진법을 적용한 단순 삽입 정렬");
        System.out.print("요솟수: ");
        int n = stdIn.nextInt();

        int[] array = new int[n];

        for (int i = 1; i <= n; i++) {
            array[i] = rand.nextInt(array.length);
        }

        System.out.printf("초기 배열 -> %s\n", Arrays.toString(array));

        binaryInsertionSort(array, n);

        System.out.printf("정렬 배열 -> %s\n", Arrays.toString(array));
    }
}