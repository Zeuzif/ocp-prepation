package me.wassif;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class MultiCatch {
	public static void main(String[] args) {
		try {
			Path path = Paths.get("uri");
			String strDate = new String(Files.readAllBytes(path));
			LocalDate date = LocalDate.parse(strDate);
			System.out.println(date);
		} catch (IOException | DateTimeParseException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
}
