package com.cg;

public class MinMaxFinder {
	public int[] findMinMax(int[] arr) {

		int[] arr1= new int[2];

		int min=arr[0];

		int max=arr[0];

		for(int i=0; i<arr.length; i++)

		{

		if(arr[i]<min)

		min=arr[i];

		else if(arr[i]>max)

		max=arr[i];

		}

		 

		arr1[0]=min;

		arr1[1]=max;

		 

		return arr1;

		}
}