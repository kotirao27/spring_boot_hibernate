package com.practice;

import java.util.ArrayList;

public class CountingGroups {

	public static void main(String[] args){

		int[][] multiples = {{1,0,1,1,0},{0,1,0,0,1},{1,0,1,1,0},{1,0,1,1,0},{0,1,0,0,1}};
		int count = 0;
		ArrayList<Integer> firstSet = new ArrayList<Integer>();
		ArrayList<Integer> secondSet = new ArrayList<Integer>();
		for(int i=0; i<multiples.length;i++){
			for(int j=0; j<multiples[i].length;j++){
				if(i!= multiples.length -1){
				int s = (multiples[i][j] - multiples[i+1][j]);
				firstSet.add(s);
				}
			}

		}
		for(int i=0; i<multiples.length;i++){
			for(int j=0; j<multiples[i].length;j++){
				if(j!= multiples[i].length -1){
				int s = (multiples[i][j] - multiples[i][j+1]);
				secondSet.add(s);
				}
			}

		}
		for(int i =0; i<firstSet.size();i++){
			if(firstSet.get(i) - secondSet.get(i) ==1){
				count++;
			}
		}
		System.out.println(count);

/*		int s = (multiples[0][0] - multiples[1][0]) + (multiples[1][0] - multiples[0][1]);  
		System.out.println(s);
*/
	}
}
