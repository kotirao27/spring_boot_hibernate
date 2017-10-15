package com.practice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindTheWinner {

	public static void main(String[] arss){

		Scanner in = new Scanner(System.in);
		int[] andrea = null;
		int[] maria = null;
		String game = null;
		try {
			int a = in.nextInt();
			andrea = new int[a];
			for (int i = 0; i < a; i++) {
				andrea[i] = in.nextInt();
			}
			int m = in.nextInt();
			maria = new int[m];
			for (int j = 0; j < m; j++) {
				maria[j] = in.nextInt();
			}
			game = in.next();
			String winner = winner(andrea,maria,game);
			System.out.println(winner);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			in.close();
		}		
	}

	 static String winner(int[] andrea, int[] maria, String s) {
		// TODO Auto-generated method stub
		Set<Integer> evenNum = new HashSet<Integer>();
		Set<Integer> oddNum = new HashSet<Integer>();
		if("Even".equals(s)) { 
			evenNum.add(0);
			for(int i=0; i<andrea.length && i< maria.length;i++){
				if(andrea[i] % 2 == 0)
				{  if(i < andrea.length -1){
					evenNum.add(andrea[i]);  
				}
				}
				else if(maria[1]%2 ==0){
					if(i < maria.length -1){
						evenNum.add(andrea[i]); 
					}
				}
			}
			Object[] even = evenNum.toArray();
			int andreaSum = 0;
			for(int k = 0; k<even.length; k++){
				int num = (int) even[k];
				andreaSum = andreaSum + (andrea[num] - maria[num]);
			}
			int mariaSum = 0;
			for(int k = 0; k<even.length; k++){
				int num = (int) even[k];
				mariaSum = mariaSum + (maria[num] - andrea[num]);
			}
			return (andreaSum > mariaSum) ? "Andrea" : "Maria";

		}
		else if("Odd".equals(s)){
			for(int i=0; i<andrea.length && i< maria.length;i++){
				if(andrea[i] % 2 != 0)
				{   if(i < andrea.length -1){
					oddNum.add(andrea[i]);     
				}
				}
				else if(maria[1]%2 ==0){
					if(i < maria.length -1){
						oddNum.add(andrea[i]);
					}
				}
			}
			Object[] odd = oddNum.toArray();
			int andreaSum = 0;
			for(int k = 0; k<odd.length; k++){
				int num = (int) odd[k];
				andreaSum = andreaSum +(andrea[num] - maria[num]);
			}
			int mariaSum = 0;
			for(int k = 0; k<odd.length; k++){
				int num = (int) odd[k];
				mariaSum = mariaSum + (maria[num] - andrea[num]);
			}
			return (andreaSum > mariaSum) ? "Andrea" : "Maria";
		}

		return null;
	}
}
