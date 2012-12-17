package com.igate.dam.smooks.controller;

import java.io.File;
import java.util.Scanner;

public class TestingSmooks
{
	public static void main(String[] args) {
		
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the input file to be transformed:");
		String inputFilename=scanner.next();
		String inputFile =  "D:\\TestingInputs\\"+inputFilename;
		TransformationMain transformationMain=new TransformationMain();
		transformationMain.fileMapperOperationInput(new File(inputFile));
	}

}
