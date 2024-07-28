package com.example;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class FileReadAndWrite {
	private static final String ROOT_DIR = "./data/KaQiu/";

	// 初始化数据文件夹
	public static void initDirectory() {
		File directory = new File(ROOT_DIR);
		if (!directory.exists()) {
			directory.mkdirs();
		}
	}

	// 增加某.txt文件
	public static CompletableFuture<Void> createFile(String fileName) {
		return CompletableFuture.runAsync(() -> {
			File file = new File(ROOT_DIR + fileName);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}


	// 给某.txt文件增加一行数据
	public static void appendToFile(String fileName, String key, String value) throws IOException {
		Path path = Paths.get(ROOT_DIR + fileName);
		String data = key + ":" + value;
		Files.write(path, Arrays.asList(data), StandardOpenOption.APPEND);
	}


	// 查找某.txt文件是否存在
	public static boolean isFileExists(String fileName) {
		File file = new File(ROOT_DIR + fileName);
		return file.exists();
	}

	// 查找某.txt文件的某一行的数据是否存在
	public static boolean isLineExists(String fileName, String key) throws IOException {
		Path path = Paths.get(ROOT_DIR + fileName);
		List<String> lines = Files.readAllLines(path);
		return lines.stream().anyMatch(line -> line.startsWith(key + ":"));
	}

	//读取某.txt文件的某一行的数据
	public static String readLine(String fileName, String key) throws IOException {
		Path path = Paths.get(ROOT_DIR + fileName);
		List<String> lines = Files.readAllLines(path);
		for (String line : lines) {
			if (line.startsWith(key + ":")) {
				return line.split(":")[1];
			}
		}
		return null;
	}

	// 更改某.txt文件的某一行的数据
	public static void updateLine(String fileName, String key, String newValue) throws IOException {
		Path path = Paths.get(ROOT_DIR + fileName);
		List<String> lines = Files.readAllLines(path);
		List<String> updatedLines = lines.stream().map(line -> {
			if (line.startsWith(key + ":")) {
				return key + ":" + newValue;
			} else {
				return line;
			}
		}).collect(Collectors.toList());
		Files.write(path, updatedLines, StandardOpenOption.WRITE);
	}
}
