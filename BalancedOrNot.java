package com.practice;

import java.util.Scanner;

public class BalancedOrNot {

	public static void main(String[] arg){  
		Scanner in = new Scanner(System.in);
		String[] exp = null;
		int[] replacements = null;
		try {
			int a1 = in.nextInt();
			exp = new String[a1];
			for (int i = 0; i < a1; i++) {
				exp[i] = in.next();
			}
			int b1 = in.nextInt();
			replacements = new int[b1];
			for (int j = 0; j < b1; j++) {
				replacements[j] = in.nextInt();
			} 
			int[] yesOrno = balancedOrNot(exp,replacements);
			System.out.println(yesOrno);
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			in.close();
		}				

	}

	 static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
		// TODO Auto-generated method stub
		int size = expressions.length;
		int[] returnValue = new int[size];
		for(int i=0 ;i<size;i++){
			String exp = expressions[i];
			if("<>".equals(exp)){
				returnValue[i] = 1;
			}
			else if("<".equals(exp)){
				returnValue[i] = 0;
			}
			else if(">".equals(exp)){
				returnValue[i] = 1;
			}		
			else{
				int p =0;
				for(int f =0; f<exp.length();f++){
					if(p< exp.length() -1){
						if('<' ==exp.charAt(p) && '>' == exp.charAt(p+1)){
							returnValue[i] = 1;
						}
						else{
							returnValue[i] = 0;
						}
						p = p+2;
					}
				}
				for(int a = 0 ; a<size;a++){
					String[] expSeq = exp.split("(?!^)");		
					if (">".equals(expSeq[a]) && expressions.length == maxReplacements[i]){
						returnValue[i] = 1;
					}
					if("<".equals(expSeq[a]) && expSeq[a] == expSeq[a+1])
					{ returnValue[i] = 0; }
				}
				if('<' ==exp.charAt(0) && '>' == exp.charAt(1) && exp.length() >2){
					String[] expSeq = exp.split("(?!^)");					
					StringBuilder expSB = new StringBuilder("<>");
					int lenghtofExp = expSeq.length;
					int replacement = maxReplacements[i];
					int  j = 1;
					for(int k=0 ; k < replacement; k++){
						if(">".equals(expSeq[j+1])){					
							expSB.append("<>");							
							expSB.append(expSeq[lenghtofExp-1]);
						}
						j++;
					}
					if(expSB.length() >2){
						if('<' == expSB.charAt(lenghtofExp -1)|| ('>' == expSB.charAt(lenghtofExp -1) && '>' == expSB.charAt(lenghtofExp -2))){
							returnValue[i] = 0;
						}
						else{
							returnValue[i] = 1;
						}
					}
					System.out.println(expSeq.toString());
				}
			}			
		}
		return returnValue;
	}

}
