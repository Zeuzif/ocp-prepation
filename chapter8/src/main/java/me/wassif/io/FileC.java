package me.wassif.io;

import java.io.File;
import java.io.IOException;

public class FileC {
	public static void main(String[] args) throws IOException {
		File parent = new File("C:\\unix");
		File child = new File(parent, "child");
		System.out.println(child.isFile());
		File file = new File("chapter8/src/main/resources/file.txt");
		if (file.exists()) {
			System.out.println("parent : " + file.getParent());
			System.out.println("absolute path : " + file.getAbsolutePath());
			System.out.println("canonical path : " + file.getCanonicalPath());
			System.out.println("size of file : " + file.length());
			System.out.println("last modified : " + file.lastModified());
		}
	}
}
