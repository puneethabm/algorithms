package org.sort;

public class SelectionSort {
	
	public static void main(String[] args) {
		int a[] = new int[] {8,3,2,9,7,1,5,4};
		
		int high = a.length;
		selectionsort(a,high);
		
		for(int i=0; i < a.length  ; i++){
			System.out.println(a[i]);
		}
	}
	
	public static void selectionsort(int[] a, int N) { // Sort a[] into increasing order.
		int temp;
		for (int i = 0; i < N - 1; i++) { 			
				int index_of_min = i;
				for (int j = i + 1; j < N ; j++)
				{
					if(a[index_of_min]>a[j])
						index_of_min = j;
				}				
				temp = a[i];
				a[i] = a[index_of_min];
				a[index_of_min] = temp;
		}
	}

}





