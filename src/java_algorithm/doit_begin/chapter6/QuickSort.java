package java_algorithm.doit_begin.chapter6;

import java.util.Arrays;

public class QuickSort {

    static void swap(int[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    static void quickSortRecur(int[] array, int left, int right) {

        int pl = left;
        int pr = right;
        int pivot = array[(pl + pr) / 2];

        System.out.printf("Pivot: %3d", pivot);
        System.out.printf("array[%d] ~ array[%d]: {", left, right);
        for (int i = left; i < right; i++)
            System.out.printf("%d , ", array[i]);
        System.out.printf("%d}\n", array[right]);

        /*----pivot을 기준으로 분할----*/
        do {
            while (array[pl] < pivot) pl++;
            while (array[pr] > pivot) pr--;
            if (pl <= pr)
                swap(array, pl++, pr--);
        } while (pl <= pr);


        if (left < pr) quickSortRecur(array, left, pr);
        if (pl < right) quickSortRecur(array, pl, right);
    }

    public static void main(String[] args) {
        int[] array = {3, 7, 8, 5, 2, 1, 9, 6};

        System.out.printf("정렬 전: %s", Arrays.toString(array));

        quickSortRecur(array, 0, array.length - 1);

        System.out.printf("정렬 후: %s", Arrays.toString(array));
    }



}
