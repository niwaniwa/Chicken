package com.github.niwaniwa.chicken;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Chicken extends JavaPlugin {

	private static Chicken instance;

	@Override
	public void onEnable() {
		instance = this;
		run();
	}

	public void run(){
		new BukkitRunnable() {
			World world = Bukkit.getWorlds().get(0);
			@Override
			public void run() {
				if(world.getTime() >= 0
						&& world.getTime() <= 39){
					playSound();
				}
			}
		}.runTaskTimer(instance, 60, 20);
	}

	public void playSound(){
		for(Player p : Bukkit.getOnlinePlayers()){
			p.playSound(p.getLocation(), Sound.CHICKEN_HURT, 1, 1);
			p.sendMessage("§rｺｯｺｯｺ");
			new BukkitRunnable() {
				@Override
				public void run() {
					p.playSound(p.getLocation(), Sound.CHICKEN_IDLE, 1, 1);
				}
			}.runTaskLater(instance, 5);
		}
	}

	public static Chicken getInstance(){
		return instance;
	}

}
