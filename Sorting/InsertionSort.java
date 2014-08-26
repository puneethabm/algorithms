package org.sort;

public class InsertionSort {

	public static void main(String[] args) {
		int a[] = new int[] { 8, 3, 2, 9, 7, 1, 5, 4 };

		int high = a.length;
		insertionsort(a, high);

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void insertionsort(int[] a, int N) { 
		int temp;
		for (int i = 1; i < N; i++) { 
			for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
				temp = a[j];
				a[j] = a[j-1];
				a[j-1] = temp;
			}
		}

	}

}
