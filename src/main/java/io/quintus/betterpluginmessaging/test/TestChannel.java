package io.quintus.betterpluginmessaging.test;

import io.quintus.betterpluginmessaging.PluginChannel;
import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.logging.Level;

/**
 * Created by akrill on 3/25/15.
 */
public class TestChannel extends PluginChannel {

    public TestChannel(BukkitBetterPluginMessagingTest plugin, String name) {
        setPlugin(plugin);
        setName(name);
        setMessageClass(TestMessage.class);

    }

    public void onReceiveIP(String ip, short port) {
        getPlugin().getLogger().log(Level.INFO, "ReceiveIP: " + ip + ":" + String.valueOf(port));
    }

    public void onReceivePlayerCount(String server, int count) {
        getPlugin().getLogger().log(Level.INFO, "ReceivePlayerCount: " + server + " -> " + String.valueOf(count));
    }

    public void onReceivePlayerList(String server, String[] playerNames) {
        getPlugin().getLogger().log(Level.INFO, "ReceivePlayerList: " + server + " -> " + StringUtils.join(playerNames, ", "));
        for (String playerName : playerNames) {
            requestUUIDOther(playerName);
        }
    }

    public void onReceiveGetServers(String[] servers) {
        getPlugin().getLogger().log(Level.INFO, "ReceiveGetServers: " + StringUtils.join(servers, ", "));
        for (String server : servers) {
            requestServerIP(server);
            requestPlayerList(server);
            requestPlayerCount(server);
        }
    }

    public void onReceiveGetServer(String server) {
        getPlugin().getLogger().log(Level.INFO, "ReceiveGetServer: " + server);
    }

    public void onReceiveForward(Player player, Object message) {
        getPlugin().getLogger().log(Level.INFO, message.toString());

    }

    public void onReceiveUUID(UUID uuid) {
        getPlugin().getLogger().log(Level.INFO, "ReceiveUUID: " + uuid.toString());
    }

    public void onReceiveUUIDOther(String playerName, UUID uuid) {
        getPlugin().getLogger().log(Level.INFO, "ReceiveUUIDOther: " + playerName + " -> " + uuid.toString());
    }

    public void onReceiveServerIP(String server, String ip, short port) {
        getPlugin().getLogger().log(Level.INFO, "ReceiveServerIP: " + server + " -> " + ip + ":" + String.valueOf(port));
    }

}
