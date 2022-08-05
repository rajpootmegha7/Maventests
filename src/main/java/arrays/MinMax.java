package arrays;

import java.util.Arrays;

public class MinMax {
	public class Pair{
		int min,max;
		public Pair(int min,int max) {
			this.min = min;
			this.max = max;
		}
	}

	public static void main (String args[]) {
		MinMax m = new MinMax();
		int arr[] = {4,2,45,445,3,6,0};
		int arr2[]= {0,0,0,-4,0,-10};
		int arr3[]= {2,9,10,11,12,15,5};
		//Pair p = m.getMaxAndMin(arr2);
		//System.out.println(p.min);
		//System.out.println(p.max);
		//m.getSum(arr3);
		//m.findPeakElement(arr3);
		//System.out.println(m.sortElement(arr3, 2));
		m.lowestElements(arr3);
		
	}
	
	public Pair getMaxAndMin(int[] arr) {
		
		
		if((arr == null)||arr.length==0) {
		System.out.println("Array is empty or length is 0.");
		return new Pair(-1,-1);
		}
		
		int max = arr[0];//4 45 445
		int min = arr[0];//4 2
		for(int i=1; i<arr.length;i++) {
		
		if (max<arr[i]) {
			max = arr[i];
		}
			
		if	(min>arr[i]) {
			
			min = arr[i];
		}
	}
		//System.out.println(max);
		//System.out.println(min);
	return new Pair(min,max);
}
	public void getSum(int[]arr) {
		int sum = 0;
		for(int i = 0 ;i <arr.length;i++) {
			
			sum += arr[i];
		}
		System.out.println(sum);
	}
	
	public void findPeakElement(int[]arr3) {
		//2,9,4
		//a[0]> a[0+1]
		int peak = -1;
		int n = arr3.length;
		  for(int i=0;i<n;i++) {
			  
			  if (i==0) {
				  if(arr3[i]>arr3[i+1]) peak=i;
			  }else if (i==n-1) {
				  if(arr3[i-1]<arr3[i]) peak=i;
			  }else {
				  if((arr3[i-1]<arr3[i])&&(arr3[i]>arr3[i+1])) peak =i;
			  }
		  }
				System.out.println(peak);
	}
	
	public int sortElement(int[] arr3,int n ) {
		int len = arr3.length;
		Arrays.sort(arr3);
		return arr3[len-n];
	}
	
	public void lowestElements(int[] arr3) {
		int min=0;
		
		for(int i = 0; i < arr3.length; i++) {
			min = 0;
			for(int j = 0; j < arr3.length; j++) {
				if (arr3[i] == arr3[j]) continue;
				else if(arr3[i] > arr3[j]) min++;
				
			}
			System.out.println("Array value =" + arr3[i]);
			System.out.println("minmum"+min);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}