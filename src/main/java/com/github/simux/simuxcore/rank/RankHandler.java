package com.github.simux.simuxcore.rank;

public class RankHandler {

    private static volatile RankHandler instance;

    private RankHandler() {
        if (instance != null) {
            throw new RuntimeException("Please use the getInstance() method to retrieve the instance of this class. " +
                    "Reflection is not supported here.");
        }
    }

    public static RankHandler getInstance() {
        if (instance == null) {
            synchronized (RankHandler.class) {
                if (instance == null) {
                    instance = new RankHandler();
                }
            }
        }
        return instance;
    }

}
