package me.br_.minecraft.bukkit.mario;

import net.minecraft.server.EntityFireball;
import net.minecraft.server.EntityLiving;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.util.Vector;

public class MListener extends PlayerListener {
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.getMaterial() == Material.RED_ROSE) {
			Player player = event.getPlayer();
			net.minecraft.server.World notchWorld = null;
			EntityFireball notchEntity = null;
			Vector velocity = null;
			CraftPlayer playerE = null;
			playerE = (CraftPlayer) player;
			Location location = player.getEyeLocation();
			notchWorld = ((CraftWorld) player.getWorld()).getHandle();
			EntityLiving playerEntity = playerE.getHandle();
			notchEntity = new EntityFireball(notchWorld, playerEntity,
					location.getX(), location.getY(), location.getZ());
			velocity = player.getEyeLocation().getDirection().multiply(5);
			notchWorld.addEntity(notchEntity);
			Entity Bukkitentity = notchEntity.getBukkitEntity();
			Bukkitentity.teleport(player.getEyeLocation());
			Bukkitentity.setVelocity(velocity);
		}
	}
}
