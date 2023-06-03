package com.github.simux.simuxcore.command;

import com.github.hapily04.simplecommandsystem.CommandElement;
import com.github.simux.simuxcore.chat.ComponentUtils;
import com.github.simux.simuxcore.chat.MessageUtils;
import com.github.simux.simuxcore.command.annotations.PermissionWeight;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.annotation.Annotation;
import java.util.Optional;

import static com.github.simux.simuxcore.chat.MessageUtils.Color;

public abstract class SimuXCommand<T extends CommandSender> extends CommandElement<T> {

    private final int requiredWeight;

    public SimuXCommand() {
        super();
        this.requiredWeight = getOptional(PermissionWeight.class).map(PermissionWeight::value).orElse(0);
    }

    /**
     * Is applied to the following SimuX usage format: <br>
     * <br>
     * ▌ USAGE <br>
     * ▌ {@link SimuXCommand#usage()} <br>
     * <br>
     * MiniMessage is supported and will be handled automatically.
     *
     * @return String to be used in {@link CommandElement#getUsage()}
     */
    protected abstract String usage();

    @Override
    public final String getUsage() {
        MiniMessage miniMessage = MiniMessage.miniMessage();
        return ComponentUtils.componentToString(miniMessage.deserialize(
                "<#00C678><b>▌ USAGE</b>\n▌ <reset><#CDEBDF>" + usage()));
    }

    protected Player getTarget(Player player, String[] args) {
        if (args.length == 0) return player;
        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null) {
            MessageUtils.sendFeedback(player, Color.ERROR_MAIN, Color.ERROR_CONTENT, "▌", "The referenced player was not found");
        }
        return target;
    }

    private <A extends Annotation> Optional<A> getOptional(Class<A> annotationClass) {
        return Optional.ofNullable(this.getClass().getAnnotation(annotationClass));
    }

}
