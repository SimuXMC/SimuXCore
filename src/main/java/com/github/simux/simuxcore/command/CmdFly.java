package com.github.simux.simuxcore.command;

import com.github.hapily04.simplecommandsystem.Description;
import com.github.hapily04.simplecommandsystem.Name;
import com.github.hapily04.simplecommandsystem.Permission;
import com.github.simux.simuxcore.chat.MessageUtils;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static com.github.simux.simuxcore.chat.MessageUtils.Color;

@Name("Fly")
@Description("Allows the player to fly")
@Permission("simux.fly")
public final class CmdFly extends SimuXCommand<Player> {

    @Override
    protected String usage() {
        return "/fly [<player>]";
    }

    @Override
    public void execute(Player player, String[] args) {
        Player target = getTarget(player, args);
        if (target == null) return;
        boolean newFlight = !target.getAllowFlight();
        target.setAllowFlight(newFlight);
        String flightStatus = Color.ACCENT_COLOR + target.getName() + Color.CONTENT_COLOR + "'s Flight: " + Color.ACCENT_COLOR +
                (newFlight ? "Enabled" : "Disabled");
        MessageUtils.sendFeedback(target, "▌", flightStatus);
        if (player != target) {
            MessageUtils.sendFeedback(player, "▌", flightStatus);
        }
    }

    @Override
    public @NotNull Class<? extends Player> getExecutableBy() {
        return Player.class ;
    }

}
