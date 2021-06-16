package me.wassif.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {
	public static void main(String[] args) {
		usingFileReaderWriter();
		usingFileBufferedReaderWriter();
	}

	private static void usingFileReaderWriter() {
		try (FileReader fr = new FileReader("chapter8/src/main/resources/fr");
				FileWriter fw = new FileWriter("chapter8/src/main/resources/fw")) {
			int character;
			while ((character = fr.read()) != -1) {
				fw.write(character);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void usingFileBufferedReaderWriter() {
		try (BufferedReader br = new BufferedReader(new FileReader("chapter8/src/main/resources/br"));
				BufferedWriter bw = new BufferedWriter(new FileWriter("chapter8/src/main/resources/bw"))) {
			String line;
			int lineNumber = 1;
			while ((line = br.readLine()) != null) {
				bw.write(lineNumber++ + "- ");
				bw.write(line);
				bw.newLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
