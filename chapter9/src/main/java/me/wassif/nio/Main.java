package me.wassif.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) {
		Path path3 = Paths.get("E:\\data");
		Path path4 = Paths.get("E:\\user\\home");
		Path relativePath = path3.relativize(path4);
		System.out.println(relativePath);
		System.out.println(path3.resolve(relativePath));
		Path path = Paths.get("/zoo/animals/bear/koala/food.txt");
		System.out.println(path.subpath(1, 3).getName(1).toAbsolutePath());
	}
}
