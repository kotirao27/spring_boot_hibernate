package com.practice;

public class TwoCircles {


	public static void main(String[] args){
		//dummy data
		String[] info = new String[5];
		info[0]="4";
		info[1]="12 0 21 14 0 23";
		info[2]="0 45 8 0 94 9";
		info[3]="35 0 13 10 0 38";
		info[4]="0 26 8 0 9 25";
		String[] returnString = circles(info);
		System.out.println(returnString);
	}
	private static String[] circles(String[] info){
        
		String[] infos = new String[info.length];
		for(int i=1; i< info.length ;i++){
		String[] circles = info[i].split(" ");
		double distance = Math.pow((Double.valueOf(circles[0]) - Double.valueOf(circles[3])) * (Double.valueOf(circles[0]) - Double.valueOf(circles[3]))
				+ (Double.valueOf(circles[1]) - Double.valueOf(circles[4])) * (Double.valueOf(circles[1]) - Double.valueOf(circles[4])), 0.5);

		if (distance > (Double.valueOf(circles[2]) + Double.valueOf(circles[5]))) {
			infos[i-1] ="Disjoint-Outside";
		}else if (distance == (Double.valueOf(circles[2]) + Double.valueOf(circles[5]))) {
			infos[i-1] ="Touching";
		}else if (Double.valueOf(circles[0]) == Double.valueOf(circles[3]) && Double.valueOf(circles[1]) == Double.valueOf(circles[4])) {
			infos[i-1] ="Concentric";
		} else if (distance == Math.abs(Double.valueOf(circles[2]) - Double.valueOf(circles[5]))) {
			infos[i-1] ="Touching";
		} else if(distance < Math.abs(Double.valueOf(circles[2]) - Double.valueOf(circles[5]))) {
			infos[i-1] ="Disjoint-Inside";
		}else {
			infos[i] ="Intersecting";
		}
		}
		return infos;
	}

}
