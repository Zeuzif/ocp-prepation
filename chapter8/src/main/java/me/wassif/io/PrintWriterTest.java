package me.wassif.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;

public class PrintWriterTest {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		try (PrintWriter printWriter = new PrintWriter("chapter8/src/main/resources/printWriter")) {
			printWriter.print(false);
			printWriter.print(new String(" hello "));
			printWriter.format("%d %.2f %-10s %s", 10, 2.231, "mimox", "fin");
			System.out.println("program terminated");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
