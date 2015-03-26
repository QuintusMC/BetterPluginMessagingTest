package io.quintus.betterpluginmessaging.test;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by akrill on 3/25/15.
 */
public class TestTask extends BukkitRunnable {

    BukkitBetterPluginMessagingTest plugin;
    Player player;

    public TestTask(BukkitBetterPluginMessagingTest plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
    }

    @Override
    public void run() {
        plugin.testChannel.requestIP(player);
        plugin.testChannel.requestGetServers();
        plugin.testChannel.requestPlayerList("ALL");
        plugin.testChannel.requestPlayerCount("ALL");
        plugin.testChannel.requestUUID(player);
        TestMessage msg = new TestMessage(0, player.getName());
        plugin.testChannel.requestForward("ONLINE", msg);
    }

}
