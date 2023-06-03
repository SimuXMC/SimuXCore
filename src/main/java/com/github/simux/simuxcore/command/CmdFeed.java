package com.github.simux.simuxcore.command;

import com.github.hapily04.simplecommandsystem.Description;
import com.github.hapily04.simplecommandsystem.Name;
import com.github.hapily04.simplecommandsystem.Permission;
import com.github.simux.simuxcore.chat.MessageUtils;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static com.github.simux.simuxcore.chat.MessageUtils.Color;

@Name("Feed")
@Description("Feeds the player")
@Permission("simux.feed")
public final class CmdFeed extends SimuXCommand<Player> {

    @Override
    protected String usage() {
        return "/feed [<player>]";
    }

    @Override
    public void execute(Player player, String[] args) {
        Player target = getTarget(player, args);
        if (target == null) return;
        target.setFoodLevel(20);
        MessageUtils.sendFeedback(target, "▌", "You have been fed");
        if (player != target) {
            MessageUtils.sendFeedback(player, "▌", Color.ACCENT_COLOR + target.getName() +
                    Color.CONTENT_COLOR + " has been fed");
        }
    }

    @Override
    public @NotNull Class<? extends Player> getExecutableBy() {
        return Player.class ;
    }

}

