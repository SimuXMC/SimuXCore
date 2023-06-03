package com.github.simux.simuxcore.command.gamemode;

import com.github.hapily04.simplecommandsystem.Aliases;
import com.github.hapily04.simplecommandsystem.Description;
import com.github.hapily04.simplecommandsystem.Name;
import com.github.hapily04.simplecommandsystem.SubCommand;
import com.github.simux.simuxcore.command.SimuXCommand;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Name("Creative")
@Description("Sets the player's gamemode to creative")
@Aliases(value = "c", registerAsTabCompletions = true)
@SubCommand(parent = CmdGamemode.class)
public class SubCreative extends SimuXCommand<Player> {

    @Override
    protected String usage() {
        return "/gamemode creative [<player>]";
    }

    @Override
    public void execute(Player player, String[] args) {
        Player target = getTarget(player, args);
        if (target == null) return;
        CmdGamemode.updateGamemode(target, GameMode.CREATIVE, player);
    }

    @Override
    public @NotNull Class<? extends Player> getExecutableBy() {
        return Player.class;
    }

}
