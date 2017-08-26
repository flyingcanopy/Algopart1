package Sorting;

/**
 * Created by zouken on 26-08-2017.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int a[] = {2, 3, 4, -2, -3};
        SelectionSort s = new SelectionSort();
        s.selectionSort(a);
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }

    public void selectionSort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            int j = findMin(a, i);
            exchange(a, i, j);
        }
    }

    private int findMin(int a[], int from) {
        int min = from;
        for (int j = from + 1; j < a.length; j++) {
            if (a[j] < a[min])
                min = j;
        }
        return min;
    }

    private void exchange(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }
}