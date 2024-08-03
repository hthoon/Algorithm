package java_algorithm.doit_begin.chapter6;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class Q11_QuickSort {

    static void swap(int[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    static void quickSort(int[] array, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);
        System.out.printf("정렬 시작, 초기 그룹 a[%d]~a[%d] 푸시\n", left, right);
        System.out.print("Lstack:"); lstack.dump();
        System.out.print("Rstack:"); rstack.dump();

        while (lstack.isEmpty() != true) {
            int pl = left = lstack.pop();
            System.out.printf("Lstack 인덱스 꺼내기: %d\n", left);

            int pr = right = rstack.pop();
            System.out.printf("Rstack 인덱스 꺼내기: %d\n", right);

            int pivot = array[(left + right) / 2];


            do {
                while (array[pl] < pivot) pl++;
                while (array[pr] > pivot) pr--;
                if (pl <= pr)
                    swap(array, pl++, pr--);
            } while (pl <= pr);

            if (left < pr) {
                lstack.push(left);
                rstack.push(pr);
                System.out.printf("a[%d]~a[%d] 그룹 인덱스 푸시\n", left, pr);
                System.out.print("Lstack 인덱스 푸시:"); lstack.dump();
                System.out.print("Rstack 인덱스 푸시:"); rstack.dump();
            }

            if (pl < right) {
                lstack.push(pl);
                rstack.push(right);
                System.out.printf("a[%d]~a[%d] 그룹 인덱스 푸시\n", pl, right);
                System.out.print("Lstack 인덱스 푸시:"); lstack.dump();
                System.out.print("Rstack 인덱스 푸시:"); rstack.dump();
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();

        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10);
        }

        System.out.println(Arrays.toString(array));

        quickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));

    }
}
