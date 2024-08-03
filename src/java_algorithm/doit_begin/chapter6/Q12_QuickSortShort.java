package java_algorithm.doit_begin.chapter6;

import java.util.Arrays;
import java.util.Random;

public class Q12_QuickSortShort {

    static void swap(int[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    static void quickSortShort9(int[] array, int left, int right) {

        int pl = left;
        int pr = right;
        int pivot = array[(pl + pr) / 2];

        // 보충수업 중,
        System.out.printf("array[%d] ~ array[%d]: {", left, right);
        for (int i = left; i < right; i++)
            System.out.printf("%d , ", array[i]);
        System.out.printf("%d}\n", array[right]);

        do {
            while (array[pl] < pivot) pl++;
            while (array[pr] > pivot) pr--;
            if (pl <= pr)
                swap(array, pl++, pr--);
        } while (pl <= pr);

        // 조건 추가.
        // 왼쪽 그룹의 요솟수가 더 적을 때,
        if (pr - left < right - pl) {
            if (left < pr) quickSortShort9(array, left, pr);
            if (pl < right) quickSortShort9(array, pl, right);
        }

        // 오른쪽 그룹의 요솟수가 더 적을 때, 혹은 요솟수가 같을 때
        else {
            if (pl < right) quickSortShort9(array, pl, right);
            if (left < pr) quickSortShort9(array, left, pr);
        }
    }

    static void quickSortShort10(int[] array, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        while (lstack.isEmpty() != true) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int pivot = array[(left + right) / 2];
            // 보충수업 중,
            System.out.printf("array[%d] ~ array[%d]: {", left, right);
            for (int i = left; i < right; i++)
                System.out.printf("%d , ", array[i]);
            System.out.printf("%d}\n", array[right]);

            do {
                while (array[pl] < pivot) pl++;
                while (array[pr] > pivot) pr--;
                if (pl <= pr)
                    swap(array, pl++, pr--);
            } while (pl <= pr);

            // 왼쪽 그룹의 요솟수가 더 적을 때,
            if (pr - left < right - pl) {
                if (left < pr) {
                    lstack.push(left);
                    rstack.push(pr);
                }
                if (pl < right) {
                    lstack.push(pl);
                    rstack.push(right);
                }
            // 오른쪽 그룹의 요솟수가 더 적을 때,
            } else {
                if (pl < right) {
                    lstack.push(pl);
                    rstack.push(right);
                }
                if (left < pr) {
                    lstack.push(left);
                    rstack.push(pr);
                }
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

        quickSortShort9(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));

        System.out.println("-------------------------------");

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10);
        }

        System.out.println(Arrays.toString(array));

        quickSortShort10(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));

    }
}
