package com.practice;

import java.util.Scanner;

public class BuyingShowTickets {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int[] tickets =null;
		int noofPersons =0;
		try {
			int noofElements = in.nextInt();
			tickets = new int[noofElements];
			for (int j = 0; j < noofElements; j++) {
				tickets[j] = in.nextInt();
			}
			noofPersons = in.nextInt();
			System.out.println(waitingTime(tickets,noofPersons));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{in.close();}
		
	}
	 static long waitingTime(int[] tickets, int p) {
        long count = 0;
        int ticketsGiven = 0;
        int personCount = tickets.length;
        if(personCount > p)
        {
            while(tickets[p] != 0)
            {
                if(tickets[ticketsGiven] != 0)
                {
                    tickets[ticketsGiven] = tickets[ticketsGiven] -1;
                    if(ticketsGiven == personCount -1){
                    	ticketsGiven = 0;
                    }
                    else{
                    	ticketsGiven ++;}
                    count ++;
                }
                else {
                    if (ticketsGiven == personCount - 1) {ticketsGiven = 0;}
                    else{
                    	ticketsGiven++;
                    }
                }
            }
        }
        else
        {
            return 0;
        }
        return count;
    }
}
