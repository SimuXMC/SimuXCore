package com.github.simux.simuxcore;

import com.github.hapily04.simplecommandsystem.SimpleCommandSystem;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimuXCore extends JavaPlugin {

    @Override
    public void onEnable() {
        SimpleCommandSystem.registerCommands(this, Bukkit.getCommandMap(), "com.github.simux.simuxcore");
    }

}
