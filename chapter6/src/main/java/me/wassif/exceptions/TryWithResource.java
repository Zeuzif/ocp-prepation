package me.wassif.exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TryWithResource {
	public static void main(String[] args) {
		try (Door door1 = new Door(); Door door2 = new Door()) {
			// if the try throw an exception
			throw new IllegalAccessError("illegal access");
		} catch (IllegalStateException e) {
			System.out.println("Caught : " + e.getMessage());
			for (Throwable th : e.getSuppressed()) {
				System.out.println(th.getMessage());
			}
		}
	}

	public static void oldApproch(Path in, Path out) throws IOException {
		BufferedReader bin = null;
		BufferedWriter bout = null;
		try {
			bin = Files.newBufferedReader(in);
			bout = Files.newBufferedWriter(out);
			bout.write(bin.readLine());
		} finally {
			if (bin != null)
				bin.close();
			if (bout != null)
				bout.close();
		}
	}

	public static void newApproch(Path in, Path out) throws IOException {
		try (BufferedReader bin = Files.newBufferedReader(in); BufferedWriter bout = Files.newBufferedWriter(out)) {
			// some work to do
		}
	}
}

class Door implements AutoCloseable {
	@Override
	public void close() throws IllegalStateException {
		throw new IllegalStateException("door was already closed");
	}
}
