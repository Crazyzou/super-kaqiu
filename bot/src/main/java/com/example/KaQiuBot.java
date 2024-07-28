package com.example;

import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public final class KaQiuBot extends JavaPlugin {
	public static final KaQiuBot INSTANCE = new KaQiuBot();

	private KaQiuBot() {
		super(new JvmPluginDescriptionBuilder("top.crazy.zou", "0.1.0")
				.name("KaQiuBot")
				.author("z")
				.build());
	}

	@Override
	public void onEnable() {
		try {
			init.start();
		} catch (IOException | ExecutionException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}