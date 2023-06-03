package com.github.simux.simuxcore.rank;

public enum CoreRank implements Rank {
    DEFAULT("", 0),
    HELPER("<#7FDDFF><b>HELPER</b>", "<#D4F4FF>", 10),
    MOD("<#75FF73><b>MOD</b>", "<#D3FFD2>", 20),
    ADMIN("<#BB73FF><b>ADMIN</b>", "<#EDDAFF>", 30),
    OWNER("<#FF886D><b>OWNER</b>", "<#FFDCD4>", 40);


    private final String prefix;
    private final String chatColor;
    private final int weight;

    CoreRank(String prefix, String chatColor, int weight) {
        this.prefix = prefix;
        this.chatColor = chatColor;
        this.weight = weight;
    }

    CoreRank(String prefix, int weight) {
        this(prefix, "<grey>", weight);
    }

    @Override
    public String getPrefix() {
        return prefix;
    }

    @Override
    public String getChatColor() {
        return chatColor;
    }

    @Override
    public int getWeight() {
        return weight;
    }

}
