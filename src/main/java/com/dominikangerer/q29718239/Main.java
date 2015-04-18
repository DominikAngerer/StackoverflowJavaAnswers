package com.dominikangerer.q29718239;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		File file = new File("/Users/dominikangerer/Projekte/Stackoverflow/files/q29718239.csv");
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileWriter(file));
			pw.println("sep=\t");
			pw.println("test\ttest\ttest\t");
			pw.println("test\ttest\ttest\t");
			pw.println("test\ttest\ttest\t");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
