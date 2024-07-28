package com.example;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class init {

	public static void start() throws IOException, ExecutionException, InterruptedException {
		Ascii();
		FileInit();
	}

	//ascii字体展示
	public static void Ascii(){
		System.out.println("===================================[ 卡丘BOT-init ]===================================");
		System.out.println("'##:::'##::::'###:::::'#######::'####:'##::::'##:'########:::'#######::'########:");
		System.out.println(" ##::'##::::'## ##:::'##.... ##:. ##:: ##:::: ##: ##.... ##:'##.... ##:... ##..::");
		System.out.println(" ##:'##::::'##:. ##:: ##:::: ##:: ##:: ##:::: ##: ##:::: ##: ##:::: ##:::: ##::::");
		System.out.println(" #####::::'##:::. ##: ##:::: ##:: ##:: ##:::: ##: ########:: ##:::: ##:::: ##::::");
		System.out.println(" ##. ##::: #########: ##:'## ##:: ##:: ##:::: ##: ##.... ##: ##:::: ##:::: ##::::");
		System.out.println(" ##:. ##:: ##.... ##: ##:.. ##::: ##:: ##:::: ##: ##:::: ##: ##:::: ##:::: ##::::");
		System.out.println(" ##::. ##: ##:::: ##:: ##### ##:'####:. #######:: ########::. #######::::: ##::::");
		System.out.println("..::::..::..:::::..:::.....:..::....:::.......:::........::::.......::::::..:::::");
		try {
			Thread.sleep(2000); // 停顿两秒
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void FileInit() throws IOException, InterruptedException, ExecutionException {
		FileReadAndWrite.initDirectory();
		System.out.println("数据路径完整性☑");
		if(FileReadAndWrite.isFileExists("卡丘BOT配置.txt")){
			System.out.println("配置文件完整性☑");
		} else {
			CompletableFuture<Void> future = FileReadAndWrite.createFile("卡丘BOT配置.txt");
			future.get();  // 等待文件创建完成
			//BOT配置文件初始化
			FileReadAndWrite.appendToFile("卡丘BOT配置.txt", "超级管理员", "null");
			System.out.println("配置文件初始化☑");
		}
	}


}
