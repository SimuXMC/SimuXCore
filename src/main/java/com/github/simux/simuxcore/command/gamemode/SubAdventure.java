package com.github.simux.simuxcore.command.gamemode;

import com.github.hapily04.simplecommandsystem.Aliases;
import com.github.hapily04.simplecommandsystem.Description;
import com.github.hapily04.simplecommandsystem.Name;
import com.github.hapily04.simplecommandsystem.SubCommand;
import com.github.simux.simuxcore.command.SimuXCommand;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Name("Adventure")
@Description("Sets the player's gamemode to adventure")
@Aliases(value = "a", registerAsTabCompletions = true)
@SubCommand(parent = CmdGamemode.class)
public final class SubAdventure extends SimuXCommand<Player> {

    @Override
    protected String usage() {
        return "/gamemode adventure [<player>]";
    }

    @Override
    public void execute(Player player, String[] args) {
        Player target = getTarget(player, args);
        if (target == null) return;
        CmdGamemode.updateGamemode(target, GameMode.ADVENTURE, player);
    }

    @Override
    public @NotNull Class<? extends Player> getExecutableBy() {
        return Player.class;
    }

}
