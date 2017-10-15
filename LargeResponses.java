package com.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class LargeResponses {
	private static final Scanner scan = new Scanner(System.in);
	static String fileName =null;
	public static void main(String[] args){
		fileName = scan.nextLine();
		File file = new File(fileName+".txt");
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		int bytesSum = 0;
		int countResponses = 0;
		ArrayList<String> lines = new ArrayList<String>();
		try{

			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);			
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				//stringBuffer.append(line);
				lines.add(line);
				//stringBuffer.append("\n");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				fileReader.close();		
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		processFile(bytesSum, countResponses, lines);
	}
	static void processFile(int bytesSum, int countResponses, ArrayList<String> lines) {
		ArrayList<String> bytes = new ArrayList<String>();
		for(int i =0; i<lines.size() ;i++){
			String lineI = lines.get(i);
			String bytesfromLine = lineI.substring(lineI.lastIndexOf(" ")+1);
			bytes.add(bytesfromLine);
		}

		for(String bytesString : bytes){
			if(Integer.parseInt(bytesString) > 5000){
				countResponses ++;
				bytesSum = bytesSum + Integer.parseInt(bytesString);
			}
		}
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("bytes_"+fileName+".txt", "UTF-8");
			writer.println(countResponses);
			writer.println(bytesSum);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		finally{
		writer.close();
		}
	}
}
