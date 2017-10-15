package com.practice;

import java.util.Scanner;

public class ConsecutiveSum {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int count = 0;
		try {
			long num = in.nextInt();
			count = consecutive(num);
			System.out.println(count);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
		in.close();
		}		
	}

	 static int consecutive(long num) {
		int count=0;
		long temp,i,j;
		long maxCount=(num/2);
		for(i=1;i<=maxCount;i++)
		{
			temp = num;
			j = i;
			while(j < temp)
			{
				temp = temp - j;
				j++;
			}
			if(j == temp)
			{
				count++;
			}
		}
		return count;
	}
}
