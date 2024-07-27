package java_algorithm.doit_begin.chapter6;

import java.util.Arrays;
import java.util.Random;

public class Q13_QuickInsertionSort {

    static void swap(int[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    static int sort3elem(int[] x, int a, int b, int c) {
        if (x[b] < x[a]) swap(x, b, a);
        if (x[c] < x[b]) swap(x, c, b);
        if (x[b] < x[a]) swap(x, b, a);
        return b;
    }

    static void quickSort(int[] array, int left, int right) {
        // 그룹의 요솟수가 9보다 적은 경우, 단순 삽입 정렬 수행
        if (right - left <= 9) {  // 요솟수 판단
            System.out.println("단순 삽입 정렬 수행");

            // 그룹에 대해 단순 삽입 정렬 수행
            for (int i = left + 1; i <= right; i++) {
                int temp = array[i];
                int j = i;
                while (j > left && array[j - 1] > temp) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = temp;
            }
            return;
        }

        int pl = left;
        int pr = right;
        int m = sort3elem(array, pl, (pl + pr) / 2, pr);
        int x = array[m];

        System.out.printf("array[%d] ~ array[%d]: {", left, right);
        for (int i = left; i < right; i++)
            System.out.printf("%d , ", array[i]);
        System.out.printf("%d}\n", array[right]);

        swap(array, m, right - 1);
        pl++;
        pr -= 2;

        do {
            while (array[pl] < x) pl++;
            while (array[pr] > x) pr--;
            if (pl <= pr)
                swap(array, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) quickSort(array, left, pr);
        if (pl < right) quickSort(array, pl, right);

    }

    public static void main(String[] args) {

        Random rand = new Random();

        int[] array = new int[20];

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10);
        }

        System.out.println(Arrays.toString(array));

        quickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));

        System.out.println("-------------------------------");
    }
}