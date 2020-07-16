import org.bukkit.plugin.java.JavaPlugin;

/**

* This class links all the subclasses needed for the whole plugin 
* creating the final product.

* @version 1.0
* @author Sled
* @since 2019-07-16

*/
public class Main extends JavaPlugin {
	
	/**
	 * The main class's constructor with no args (this gets auto loaded at server startup), 
	 * which instantiates any needed variables among the global ones.
	 */
	public Main()
	{
		
	}
	
	/**
	 *  Setters.
	 *  
	 *  Function used to load all the initial required data
	 */
	public void initial_load()
	{
		
	}
	
	/**
	 *  Setters.
	 *  
	 *  Function used to unload all the data
	 */
	public void stop_server()
	{
		
	}
	
	/**
	 *  Plugin load function
	 */
	@Override
	public void onLoad()
	{}
	
	/**
	 *  Happens after plugin load
	 */
	@Override
	public void onEnable()
	{
		initial_load();
	}
	
	/**
	 *  Happens at server shutdown
	 */
	@Override
	public void onDisable()
	{
		stop_server();
	}
}
