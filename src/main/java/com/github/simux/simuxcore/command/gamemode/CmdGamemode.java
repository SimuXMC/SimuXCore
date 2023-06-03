package com.github.simux.simuxcore.command.gamemode;

import com.github.hapily04.simplecommandsystem.Aliases;
import com.github.hapily04.simplecommandsystem.Description;
import com.github.hapily04.simplecommandsystem.Name;
import com.github.hapily04.simplecommandsystem.Permission;
import com.github.simux.simuxcore.chat.MessageUtils;
import com.github.simux.simuxcore.command.SimuXCommand;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.github.simux.simuxcore.chat.MessageUtils.Color;

@Name("Gamemode")
@Description("A simple command to update your gamemode")
@Permission("simux.gamemode")
@Aliases("gm")
public final class CmdGamemode extends SimuXCommand<Player> {

    @Override
    protected String usage() {
        return "/gamemode [<a/s/c/sp>] [<player>]";
    }

    @Override
    public void execute(Player player, String[] args) {
        Player target = getTarget(player, args);
        if (target == null) return;
        GameMode gameMode = GameMode.SURVIVAL;
        if (player.getGameMode() == GameMode.SURVIVAL) {
            gameMode = GameMode.CREATIVE;
        }
        updateGamemode(target, gameMode, player);
    }

    @Override
    public @NotNull Class<? extends Player> getExecutableBy() {
        return Player.class ;
    }

    // Package private for the subcommands
    static void updateGamemode(Player player, GameMode gameMode, Player... updater) {
        player.setGameMode(gameMode);
        MessageUtils.sendFeedback(player,
                "▌",
                "Your gamemode has been updated to " + Color.ACCENT_COLOR + gameMode);
        if (List.of(updater).contains(player)) return;
        for (Player p : updater) {
            MessageUtils.sendFeedback(p,
                    "▌",
                    Color.ACCENT_COLOR + player.getName() + Color.CONTENT_COLOR + "'s gamemode has been updated to " +
                            Color.ACCENT_COLOR + gameMode);
        }
    }

}
