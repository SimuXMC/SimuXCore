package com.github.simux.simuxcore.command;

import com.github.hapily04.simplecommandsystem.Description;
import com.github.hapily04.simplecommandsystem.Name;
import com.github.hapily04.simplecommandsystem.Permission;
import com.github.simux.simuxcore.chat.MessageUtils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Name("ban")
@Permission("ban.use")
@Description("bans a player from the server")
public final class CmdBan extends SimuXCommand<Player> {

    @Override
    protected String usage() {
        return "/ban <player> [<reason>]";
    }

    @Override
    public void execute(Player player, String[] args) {
        if (args.length == 0) {
            MessageUtils.sendFeedback(player, "▌", MessageUtils.Color.ERROR_MAIN + " please specify a person to be banned");
            return;
        }
        String playerName = args[0];
        BanList banList = Bukkit.getBanList(BanList.Type.NAME);
        OfflinePlayer target = Bukkit.getOfflinePlayer(playerName);
        if(banList.isBanned(playerName)) {
            MessageUtils.sendFeedback(player, "▌", MessageUtils.Color.ERROR_MAIN + target.getName() + MessageUtils.Color.ERROR_CONTENT + " is already banned from the server");
            return;
        }
        String banReason = args[1];
        banList.addBan(target.getName(), banReason, null, "SimuX");
        target.banPlayer(banReason);
        for(Player staff : Bukkit.getOnlinePlayers()) {
            if (staff.hasPermission("ban.list")) {
                MessageUtils.sendFeedback(player, "▌", MessageUtils.Color.ACCENT_COLOR + target.getName() +
                        MessageUtils.Color.CONTENT_COLOR + " got banned for  "+ banReason);
            }
        }
    }

    @Override
    public @NotNull Class<? extends Player> getExecutableBy() {
        return Player.class ;
    }

}
