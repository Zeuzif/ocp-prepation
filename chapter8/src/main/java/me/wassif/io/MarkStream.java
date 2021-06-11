package me.wassif.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MarkStream {
	public static void main(String[] args) throws IOException {
		File file = new File("chapter8/src/main/resources/mark_stream.txt");
		try (InputStream is = new BufferedInputStream(new FileInputStream(file))) {
			System.out.print((char) is.read());
			if (is.markSupported()) {
				is.mark(1);
				System.out.print((char) is.read());
				System.out.print((char) is.read());
				is.reset();
			}
			System.out.print((char) is.read());
			System.out.print((char) is.read());
			System.out.print((char) is.read());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
