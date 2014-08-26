package org.sort;

public class BubbleSort {
	
	public static void main(String[] args) {
		int a[] = new int[] {8,3,2,9,7,1,5,4};
		
		int high = a.length;
		bubblesort(a,high);
		
		for(int i=0; i < a.length  ; i++){
			System.out.println(a[i]);
		}
	}
	
	public static void bubblesort(int[] a, int N) { 
		int temp;
		for (int i = 0; i < N-1; i++) { 			
			for(int j=0; j< N-1-i; j++)
			{
				if(a[j]>a[j+1])
				{
					temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				}
			}

		}
	}

}





