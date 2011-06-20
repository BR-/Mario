package me.br_.minecraft.bukkit.mario;

import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;

public class MMain extends JavaPlugin {
	public void onDisable() {
		System.out.println("[Mario] Disabled.");
	}

	public void onEnable() {
		this.getServer()
				.getPluginManager()
				.registerEvent(Event.Type.PLAYER_INTERACT, new MListener(),
						Event.Priority.Low, this);
		System.out.println("[Mario] Enabled.");
	}
}