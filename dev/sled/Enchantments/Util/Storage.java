package dev.sled.Enchantments.Util;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;

/**

* This class handles all the storage/databse requests

* @version 1.0
* @author Sled
* @since 2020-07-29

*/
public class Storage
{
	public static Plugin plugin = null;
	private File file = null;
	private FileConfiguration file_conf = null;
	public static Double define_MAX_XP_REQ = 1073741824.0;
	
	public static double database_version = 1.0;
	
	public Storage(Plugin plugin)
	{
		Storage.plugin = plugin;
	}
	
	public Storage()
	{}
	
	/*
	 *  Function which loads the config file
	 */
	public void load_config()
	{		
		if(plugin == null)
			return;
		
		if(plugin != null)
		{
			// Getting the defaults
		     plugin.getConfig().options().copyDefaults(true);
		     
		     // Save the configs
		     plugin.saveConfig();
		}
	}
	
	private void set_config(String config)
	{
		file = new File(plugin.getDataFolder(), config + ".yml");
		
		if(!file.exists())
		{
			try
			{
				file.createNewFile();
			}
			catch(IOException e)
			{
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create the" + config + ".yml file!");
			}
		}
		
		file_conf = YamlConfiguration.loadConfiguration(file);
		
		try
		{
			file_conf.save(file);
		}
		catch (IOException e)
		{
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save to the " + config + ".yml file!");
		}
	}
	
	public void set_data(String config, String key, Object data)
	{
		if(file == null)
			return;
		
		if(config == null)
			return;
		
		set_config(config);
		file_conf.set(key, data);
		
		try
		{
			file_conf.save(file);
		}
		catch (IOException e)
		{
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save to the " + config + ".yml file!");
		}
	}
	
	public Object get_data(String path, String key)
	{
		FileConfiguration fc = null;
		File f = null;
		Object o;
		
		if(file_conf != null)
		{
			f = file;
			fc = file_conf;
		}
		
		set_config(path);
		
		o = file_conf.get(key);
		
		if(f != null)
		{
			file = f;
			file_conf = fc;
		}
		
		return o;
	}
}
