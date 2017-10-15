package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PsychometricTesting {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] scores;
		int[] lowerLimits;
		int[] upperLimits;
		try {
			int n1 = in.nextInt();
			scores = new int[n1];
			for (int i = 0; i < n1; i++) {
				scores[i] = in.nextInt();
			}
			int n2 = in.nextInt();
			lowerLimits = new int[n2];
			for (int i = 0; i < n2; i++) {
				lowerLimits[i] = in.nextInt();
			}
			int n3 = in.nextInt();
			upperLimits = new int[n3];
			for (int i = 0; i < n3; i++) {
				upperLimits[i] = in.nextInt();
			} 
			int[] offers = jobOffers(scores,lowerLimits,upperLimits);	
			System.out.println(offers);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			in.close();
		}
		//int[] scores = {4,8,7};
		//int[] lowerLimits = {2,4};
		//int[] upperLimits = {8,4};

	}

	private static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {
		// TODO Auto-generated method stub
		int noOfCandidates = 0;
		List<Integer> jobOffersList = new ArrayList<>();

		for(int i=0; i<lowerLimits.length; i++){
			int lowerCutOff = lowerLimits[i];
			int upperCutOff = upperLimits[i];
			for(int j=0; j<scores.length; j++){
				if(scores[j]>=lowerCutOff && scores[j]<=upperCutOff){
					noOfCandidates++;
				}
			}
			jobOffersList.add(noOfCandidates);
			noOfCandidates = 0;
		}

		int[] jobOffers = new int[jobOffersList.size()];
		//	jobOffers = jobOffersList.toArray(jobOffers);

		for(int k=0; k<jobOffersList.size(); k++){
			jobOffers[k] = jobOffersList.get(k);
			//System.out.println(jobOffers[k]);
		}
		return jobOffers;
	}

}
