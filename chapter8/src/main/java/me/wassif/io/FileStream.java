package me.wassif.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

public class FileStream {
	public static void main(String[] args) {
		usingFileStreams();
		usingBufferedStreams();
	}

	private static void usingFileStreams() {
		try (FileInputStream fis = new FileInputStream("chapter8/src/main/resources/fis");
				FileOutputStream fos = new FileOutputStream("chapter8/src/main/resources/fos")) {
			// read return an int if EOF is reached it return -1
			int c;
			while ((c = fis.read()) != -1) {
				fos.write(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void usingBufferedStreams() {
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("chapter8/src/main/resources/bis"));
				BufferedOutputStream bos = new BufferedOutputStream(
						new FileOutputStream("chapter8/src/main/resources/bos"))) {
			byte[] buffer = new byte[1024];
			int lengthRead;
			while ((lengthRead = bis.read(buffer)) > 0) {
				bos.write(buffer, 0, lengthRead);
				bos.flush();
				LocalDate date = LocalDate.of(2021, 04, 19);
				System.out.println(date.plusMonths(6));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
