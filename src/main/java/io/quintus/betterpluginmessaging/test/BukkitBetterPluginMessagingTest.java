package io.quintus.betterpluginmessaging.test;

import com.google.common.collect.Iterables;
import io.quintus.betterpluginmessaging.BukkitBetterPluginMessaging;
import io.quintus.betterpluginmessaging.PluginChannelManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class BukkitBetterPluginMessagingTest extends JavaPlugin implements Listener {

    public PluginChannelManager channelManager;
    public TestChannel testChannel;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        channelManager = ((BukkitBetterPluginMessaging)this.getServer().getPluginManager().getPlugin("BukkitBetterPluginMessaging")).getChannelManager();
        testChannel = new TestChannel(this, "TestChannel");
        channelManager.registerChannel(this, testChannel);
        BukkitTask task = new TestTask(this, Iterables.getFirst(getServer().getOnlinePlayers(), null)).runTaskLater(this, 10);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
    }

}
