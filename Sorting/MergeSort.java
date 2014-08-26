package org.sort;

public class MergeSort {
	
	public static void main(String[] args) {
		int a[] = new int[] {8,3,2,9,7,1,5,4};
		
		int high = a.length;
		mergesort(a,0,high-1);
		
		for(int i=0; i < a.length  ; i++){
			System.out.println(a[i]);
		}
	}
	
	public static void mergesort(int[] a,int low, int high){
		int mid;
		//System.out.println("MergeSort=>> Low = " + low + " High = " + high);
	
		if(low<high){
			mid = (low + high)/2;
			
			//System.out.println("Low = " + low + " Mid = " + mid + " High = " + high);
			mergesort(a,low,mid);
			mergesort(a,mid+1,high);
			merge(a,low,mid,high);
		}
	}
	
	
	public static void merge(int[] a,int low,int mid, int high){
		int i,j,k;
		int c[] = new int[50];
		i = k = low;
		j = mid +1;
		
	//	System.out.println("Merge ==> Low = " + low + " Mid = " + mid + " High = " + high);
		while((i<=mid) && (j<=high)){
			if(a[i] < a[j]){
				c[k] = a[i];
				k++;
				i++;
			}else{
				c[k] = a[j];
				k++;
				j++;
			}
		}
		
		while(i<=mid){
				c[k] = a[i];
				k++;
				i++;
		}
		
		while(j<=high){
				c[k] = a[j];
				k++;
				j++;
		}
		
		for(i=low;i<k;i++){
			a[i]=c[i];
		}
		
		
		
	}

}





