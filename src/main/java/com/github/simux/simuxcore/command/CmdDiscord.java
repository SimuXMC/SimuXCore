package com.github.simux.simuxcore.command;

import com.github.hapily04.simplecommandsystem.Description;
import com.github.hapily04.simplecommandsystem.Name;
import com.github.simux.simuxcore.chat.MessageUtils;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Name("Discord")
@Description("Sends the discord invite to the player.")
public final class CmdDiscord extends SimuXCommand<Player> {

    @Override
    protected String usage() {
        return "/discord";
    }

    @Override
    public void execute(Player player, String[] args) {
        MessageUtils.sendFeedback(player, "<#5865F2>", "<#DEE0F3>", "▌",
                "<hover:show_text:Click to Join><click:open_url:https://discord.gg/YMxNFeADJt><b><#CCD0F3>Click</b>" +
                        " <#DEE0F3>this message to join the Discord!</click>");
    }

    @Override
    public @NotNull Class<? extends Player> getExecutableBy() {
        return Player.class ;
    }

}
