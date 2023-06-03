package com.github.simux.simuxcore.command.gamemode;

import com.github.hapily04.simplecommandsystem.Aliases;
import com.github.hapily04.simplecommandsystem.Description;
import com.github.hapily04.simplecommandsystem.Name;
import com.github.hapily04.simplecommandsystem.SubCommand;
import com.github.simux.simuxcore.command.SimuXCommand;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Name("Spectator")
@Description("Sets the player's gamemode to spectator")
@Aliases(value = "sp", registerAsTabCompletions = true)
@SubCommand(parent = CmdGamemode.class)
public class SubSpectator extends SimuXCommand<Player> {

    @Override
    protected String usage() {
        return "/gamemode spectator [<player>]";
    }

    @Override
    public void execute(Player player, String[] args) {
        Player target = getTarget(player, args);
        if (target == null) return;
        CmdGamemode.updateGamemode(target, GameMode.SPECTATOR, player);
    }

    @Override
    public @NotNull Class<? extends Player> getExecutableBy() {
        return Player.class;
    }

}
