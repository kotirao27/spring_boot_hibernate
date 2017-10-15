package com.practice;

import java.util.Scanner;

public class InTheFuture {
	
	public static void main(String[] arss){
		Scanner in = new Scanner(System.in);
		try {
			int	asha = in.nextInt();
			int kelly = in.nextInt();
			int	problems = in.nextInt();
			int days = minNum(asha,kelly,problems);
			System.out.println(days);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			in.close();
		}		
	}

	 static int minNum(int A, int K, int P) {
		// TODO Auto-generated method stub
		if(K < A){
			return -1; 
		}
		else if(A == K){ return 1;}
		else{
			int diff = K-A;
			if(diff == P){
				return diff +1;
			}
			else{
				return diff -1;
			}
		}
		//return 0;
	}

}
