package com.practice;

import java.util.Scanner;

public class LargestSubsetSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int k = in.nextInt();
			int[] n = new int[k];
			for (int i = 0; i < k; i++) {
				n[i] = in.nextInt();
			}
			System.out.println(maxSubSetSum(n));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			in.close();
		}
	}

   static long[] maxSubSetSum(int[] k) {
		// TODO Auto-generated method stub
		long[] returnVal = new long[k.length];
		int sum =1;
		for(int i=0; i<k.length; i++){
			sum = sum + k[i];
			returnVal[i] = sum;
		}

		return returnVal;
	}
}