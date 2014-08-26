package org.sort;

public class QuickSort {
	public static void main(String[] args) {
		int a[] = new int[] {8,3,2,9,7,1,5,4};
		
		int high = a.length;
		quicksort(a,0,high-1);
		
		for(int i=0; i < a.length  ; i++){
			System.out.println(a[i]);
		}
	}
	
	
	public static void quicksort(int[] a, int low, int high){
		int pos;

		if(low<high)
		{
			pos=partition(a,low,high);
			quicksort(a,low,pos-1);
			quicksort(a,pos+1,high);
		}
	}
	
	
	public static int partition(int[] a, int low, int high){
		int i,j,pivot,temp;
		pivot=a[low];
		i=low+1;
		j=high;
		while(i<=j)
		{


			while(i<=j && a[i]<=pivot)
				i++;

			while(a[j]>pivot)
				j--;
			if(i<j)
			{	temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		 }
		 temp=a[j];
		 a[j]=a[low];
		 a[low]=temp;
		 return j;

	}

}
