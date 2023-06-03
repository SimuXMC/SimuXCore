package com.github.simux.simuxcore.command;

import com.github.hapily04.simplecommandsystem.Description;
import com.github.hapily04.simplecommandsystem.Name;
import com.github.hapily04.simplecommandsystem.Permission;
import com.github.simux.simuxcore.chat.MessageUtils;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static com.github.simux.simuxcore.chat.MessageUtils.Color;

@Name("Heal")
@Description("Heals the player")
@Permission("simux.heal")
public final class CmdHeal extends SimuXCommand<Player> {

    @Override
    protected String usage() {
        return "/heal [<player>]";
    }

    @Override
    public void execute(Player player, String[] args) {
        Player target = getTarget(player, args);
        if (target == null) return;
        AttributeInstance maxHealth = target.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        assert maxHealth != null;
        target.setHealth(maxHealth.getValue());
        MessageUtils.sendFeedback(target, "▌", "You have been healed");
        if (player != target) {
            MessageUtils.sendFeedback(player, "▌", Color.ACCENT_COLOR + target.getName() +
                    Color.CONTENT_COLOR + " has been healed");
        }
    }

    @Override
    public @NotNull Class<? extends Player> getExecutableBy() {
        return Player.class ;
    }

}
