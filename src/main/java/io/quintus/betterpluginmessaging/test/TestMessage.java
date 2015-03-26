package io.quintus.betterpluginmessaging.test;

/**
 * Created by akrill on 3/25/15.
 */
public class TestMessage {
    private Integer id;
    private String playerName;

    public TestMessage() {}

    public TestMessage(Integer id, String playerName) {
        this.id = id;
        this.playerName = playerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return "TestMessage [id=" + id + ", playerName=" + playerName + "]";
    }
}
