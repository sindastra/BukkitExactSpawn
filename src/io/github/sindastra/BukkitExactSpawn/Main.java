/**
 * BukkitExactSpawn
 * Copyright (C) 2017 Sindastra <https://github.com/sindastra>
 * All rights reserved.
 *
 * This and the above copyright notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * This software is not affiliated with Bukkit.
 * 
 * @author Sindastra
 * @copyright Copyright (C) 2017 Sindastra. All rights reserved.
 */

package io.github.sindastra.BukkitExactSpawn;

import org.bukkit.OfflinePlayer;
import org.bukkit.World.Environment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener
{
	@Override
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getLogger().info("Enabled!");
	}
	
	@Override
	public void onDisable()
	{
		getServer().getLogger().info("Disabled.");
	}
	
	@EventHandler
	public void onPlayerFirstJoin(PlayerJoinEvent event)
	{
		OfflinePlayer offlinePlayer = (OfflinePlayer) event.getPlayer();
		Player player = (Player) event.getPlayer();
		
		if(!offlinePlayer.hasPlayedBefore())
			if(player.getWorld().getEnvironment().equals(Environment.NORMAL))
				player.teleport(player.getWorld().getSpawnLocation());
	}
}