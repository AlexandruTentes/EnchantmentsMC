package dev.sled.Enchantments;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Events implements Listener {
	
	@EventHandler
	public void on_player_message(PlayerCommandPreprocessEvent event)
	{
		Player player = event.getPlayer();
		String [] command = event.getMessage().split(" ");
		
		switch(command[0])
		{
			case "/enchant_test": player.sendMessage("Enchantment plugin is running!"); break;
			default: return;
		}
	}
}
