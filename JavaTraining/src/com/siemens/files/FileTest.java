package com.siemens.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileTest {

	public static void main(String[] args) {
		// fileFun();
		// fileReadFun();
		// fileWriteFun();
		fileCopyFun();
	}

	static void fileFun() {
		File file = new File("D:\\Documents\\Aadhaar.pdf");
		System.out.println("Can Execute: " + file.canExecute());
		System.out.println("Can Read: " + file.canRead());
		System.out.println("Can Write: " + file.canWrite());
		System.out.println("Modified: " + new Date(file.lastModified()));
		System.out.println("Path: " + file.getAbsolutePath());
		File directory = new File("D:\\Documents");
		if (directory.isDirectory()) {
			File[] files = directory.listFiles();
			for (File singleFile : files) {
				System.out.println(singleFile);
			}
		}
	}

	static void fileReadFun() {
		File file = new File("D:\\Documents\\Calculator.java");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void fileWriteFun() {
		File file = new File("D:\\Documents\\JavaFile.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			String textInfo1 = "Hello!";
			String textInfo2 = "Have a good day!";
			bw.write(textInfo1);
			bw.newLine();
			bw.write(textInfo2);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void fileCopyFun() {
		File inputFile = new File("D:\\Documents\\JavaFile.txt");
		File outputFile = new File("D:\\Documents\\JavaFile-copy.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
			String line = null;
			while ((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}
			bw.flush();
			br.close();
			bw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
